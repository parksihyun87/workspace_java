import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class DBFunction {
    String currentUser;
    Scanner input = new Scanner(System.in);
    private Connection conn;
    private Statement stmt = null;//연결된후 안에서 선언하고 사용

    public void currentUser(String user){
        this.currentUser= user;
    }

    public DBFunction(Connection connect){
        try{
            this.conn = connect;
            this.stmt = this.conn.createStatement();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public String login() {
        boolean loginFlag = false;
        while (true) {
            System.out.println("id");
            String id = input.nextLine();
            System.out.println("pw");
            String pw = input.nextLine();

            String sql = "select * from usertbl where userid=? and userpw=?";
            try {
                PreparedStatement pstmt = this.conn.prepareStatement(sql);
                pstmt.setString(1, id);
                pstmt.setString(2, pw);
                pstmt.executeQuery();// 실행
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    System.out.println("로그인성공");
                    return id;
                } else {
                    System.out.println("로그인실패");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }// login 끝


    // 입력 함수

    public int searchBook(){
        ArrayList<Book> bookList = new ArrayList<>();
        int inputIsbn= 0;

        System.out.println("검색 입력:");
        String inputWord= input.nextLine();
        String word="%" + inputWord + "%";

        String sql="select * from booktbl where title like ? or author like ? or publisher like ?";
        try{
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setString(1,word);
        pstmt.setString(2,word);
        pstmt.setString(3,word);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()){
            int isbn = rs.getInt("isbn");
            String callnum = rs.getString("callnum");
            String title = rs.getString("title");
            String author = rs.getString("author");
            String publisher = rs.getString("publisher");
            int pubyear = rs.getInt("pubyear");
            int rentnum = rs.getInt("rentnum");

            bookList.add(new Book(isbn,callnum,title,author,publisher,pubyear,rentnum));
        }
        rs.close();

        if(bookList.size()==0){
            System.out.println("검색결과가 없습니다.");
        }

        for(Book eb: bookList){
            System.out.println(eb.getIsbn());
            System.out.println(eb.getTitle());
        }
        System.out.println("isbn 입력");
        inputIsbn= input.nextInt();
        input.nextLine();

        } catch (Exception e){
            System.out.println("잘못된 ISBN입니다.");
        }

        return inputIsbn;
    }

    public void rentBook(int inputIsbn) {
        LocalDate today = LocalDate.now();
        LocalDate returnDate = today.plusDays(13);
        try {
            Book book = getRentedBook(inputIsbn); // 대여중 책 확인
            boolean isRented = book != null;

            if (!isRented) {
                // 대출 가능 상태
                book = getBookByIsbn(inputIsbn);
                if (book == null) {
                    System.out.println("해당 ISBN의 책이 존재하지 않습니다.");
                    return;
                }
                System.out.println("대출가능 합니다. 대출하시겠습니까? (y/n)");
                if (confirm()) {
                    rentNow(book, today, returnDate);
                } else {
                    System.out.println("대출이 취소되었습니다.");
                }
            } else {
                // 대출중 → 예약 가능 여부 확인
                if (countUserReservation(inputIsbn, currentUser) > 0) {
                    System.out.println("이미 예약중인 책입니다.");
                    return;
                }

                int reserveCount = getReserveCount(inputIsbn);
                printBook(book);
                System.out.println("대출상태: 대출중");
                System.out.println("예약대기자: " + reserveCount + "명");

                if (reserveCount >= 3) {
                    System.out.println("예약인원 초과로 예약 하실 수 없습니다.");
                    return;
                }

                System.out.println("예약 하시겠습니까? (y/n)");
                if (confirm()) {
                    reserveBook(book, today, reserveCount + 1);
                } else {
                    System.out.println("예약이 취소되었습니다.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void printBook(Book book){
        System.out.println(book.getIsbn());
        System.out.println(book.getTitle());
        System.out.println(book.getAuthor());
        System.out.println(book.getPublisher());
        System.out.println(book.getPubyear());
    }


    public int countRecord(int isbn){
        int rcount=0;
        String sql="select count(*) as cnt from booktbl where isbn=?";
        try{
            ResultSet rs = this.stmt.executeQuery(sql);
            while(rs.next()){
                rcount= rs.getInt("cnt");
            }
            rs.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return rcount;
    }

    private Rent getBookedRent(int isbn) throws SQLException {
        String sql = "SELECT * FROM renttbl r INNER JOIN booktbl b ON r.isbn = b.isbn WHERE r.isbn = ? AND r.turnin = 0";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, isbn);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) return mapRent(rs);
        }
        return null;
    }


    private Book getRentedBook(int isbn) throws SQLException {
        String sql = "SELECT * FROM renttbl r INNER JOIN booktbl b ON r.isbn = b.isbn WHERE r.isbn = ? AND r.turnin = 0";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, isbn);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) return mapBook(rs);
        }
        return null;
    }

    private Book getBookByIsbn(int isbn) throws SQLException {
        String sql = "SELECT * FROM booktbl WHERE isbn = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, isbn);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) return mapBook(rs);
        }
        return null;
    }

    private Book mapBook(ResultSet rs) throws SQLException {
        return new Book(
                rs.getInt("isbn"),
                rs.getString("callnum"),
                rs.getString("title"),
                rs.getString("author"),
                rs.getString("publisher"),
                rs.getInt("pubyear"),
                rs.getInt("rentnum")
        );
    }

    private Rent mapRent(ResultSet rs) throws SQLException {
        return new Rent(
                rs.getInt("rentnumber"),
                rs.getString("userid"),
                rs.getInt("isbn"),
                rs.getDate("rentdate"),
                rs.getDate("duedate"),
                rs.getBoolean("prolong"),
                rs.getDate("turnindate"),
                rs.getBoolean("turnin")
        );
    }

    private void rentNow(Book book, LocalDate today, LocalDate returnDate) throws SQLException {
        String sql = "INSERT INTO renttbl VALUES (?,?,?,?,?,?,?,?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, 0);
            pstmt.setString(2, currentUser);
            pstmt.setInt(3, book.getIsbn());
            pstmt.setDate(4, Date.valueOf(today));
            pstmt.setDate(5, Date.valueOf(returnDate));
            pstmt.setInt(6, 0);
            pstmt.setString(7, null);
            pstmt.setInt(8, 0);
            pstmt.executeUpdate();
        }
        System.out.println("대출이 완료되었습니다.");
    }

    private int countUserReservation(int isbn, String userId) throws SQLException {
        String sql = "SELECT COUNT(*) FROM reservetbl WHERE isbn=? AND userid=? AND reservestatus='예약대기'";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, isbn);
            pstmt.setString(2, userId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) return rs.getInt(1);
        }
        return 0;
    }

    private int getReserveCount(int isbn) throws SQLException {
        String sql = "SELECT COUNT(*) FROM reservetbl WHERE isbn=? AND reservestatus='예약대기'";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, isbn);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) return rs.getInt(1);
        }
        return 0;
    }

    private void reserveBook(Book book, LocalDate today, int position) throws SQLException {
        String sql = "INSERT INTO reservetbl VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, 0);
            pstmt.setString(2, currentUser);
            pstmt.setInt(3, book.getIsbn());
            pstmt.setDate(4, Date.valueOf(today));
            pstmt.setInt(5, position);
            pstmt.setString(6, "예약대기");
            pstmt.executeUpdate();
        }
        System.out.println("예약이 완료되었습니다.");
    }

    private boolean confirm() {
        String inputYn = input.nextLine().trim().toUpperCase();
        return inputYn.equals("Y");
    }

    public void returnBook() {
        //키워드: 현재 대여책/ 현재 대여 책 보여주는 쿼리문-> 모두 보여 주면서 반납할 책의 isbn 입력 받음->
        //입력시 반납처리- 1.update 쿼리분으로 대여책의 turnindate 기입, turnin을 1로 바꿈.
        // 2. 예약 테이블에 존재하는 책인지 확인하는 쿼리문, 3.있으면 해당 책의 대기자들 예약순위를 -1씩 감소시킴.
        LocalDate today = LocalDate.now();

        try{
//            myBook(currentUser);
            System.out.println("반납할 책 isbn 입력");
            int inputIsbn=input.nextInt();
            input.nextLine();
            String sql= "update renttbl set turnindate = ? , turnin=? where userid=? and isbn=? and turnin=true";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDate(1,Date.valueOf(today));
            pstmt.setBoolean(2,true);
            pstmt.setString(3,currentUser);//수정
            pstmt.setInt(4,inputIsbn);
            int updated = pstmt.executeUpdate();
            if (updated > 0) {
                System.out.println("정상적으로 반납되었습니다.");
            } else {
                System.out.println("반납 실패 - 조건에 맞는 대여 기록이 없습니다.");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    private void myBook(String user) throws SQLException {//스트링->유저
        ArrayList<Book> bookList = new ArrayList<>();
        String sql="select * from renttbl where userid=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,user);//유저.겟아이디
        ResultSet rs = pstmt.executeQuery();
        while(rs.next()){
            bookList.add(mapBook(rs));
        }
        if(bookList.size()==0){
            System.out.println("대여중인 책이 없습니다.");
        }
        rs.close();
        for(Book bookE:bookList){
            printBook(bookE);
        }
    }
}// 클래스