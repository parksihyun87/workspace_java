package dbpackage;

import java.sql.*;

// 컨트롤 클래스로 만들거임.
public class UserDBConnect {
    private String driver ="com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://127.0.0.1:3306/cookdb?serverTimeZone=UTC";
    //포트번호는 고정임.
    private String user = "root";
    private String password = "1234";
    // 접속하기 위한 객체 생성

    private Connection conn = null;
    private Statement stmt = null;
    // 연결 객체, 명령 객체 생성.

    public UserDBConnect(){

    }
    //구색

    public void initDBConnect(){
        try{
            Class.forName(this.driver);
//           // 마에스큐엘 드라이버를 먼저 로드하고
            this.conn= DriverManager.getConnection(this.url, this.user, this.password);
            // 제대로 하면 연결 객체가 생성되어서 전달됨. getconnection은 정적 메서드다. 연결 객체가 생성됨. 연결 시도해서
            // 성립하면 연결객체가 만들어지고
            // 명령 객체 만들기. 이 명령 객체를 통해 쿼리를 실행할 수 있음.
            this.stmt = this.conn.createStatement();
            // 크리에이터를 통해 명령 객체 만듬. 이것들이 제디피시에서 제공하는 에피아이
            // 일반적인 명령 객체를 만듬.

        }catch (ClassNotFoundException e){//잘못된 이름으로 찾을 때 발동됨.
            e.printStackTrace();// 오류가 난 순서를 스택으로 쌓이듯이 히스토리를 보여줌.
        }catch (SQLException e){// 전부 포함하는 예외
            e.printStackTrace();
        }
    }

    public int countRecord(){
        String sql="select count(*) as cnt from usertbl"; //세미클론 안함
        int rcount=0;
        try{
            ResultSet rs = this.stmt.executeQuery(sql);
            // 셀렉트 문을 담을 수 있는 객체임. api에서 제공하는 클래스임.
            // 셀렉트 문의 결과를 받아 담을 수 있는 객체 클래스임. 결과 set이라고 함.
            while(rs.next()){// rs.넥스트 하면 리절트 객체에 넥스트 하면 하나씩 화살표가 다음으로 간다.
              rcount= rs.getInt("cnt");
            }
            rs.close();
            // 가져다 썻으면 클로즈
        } catch (SQLException e){
            e.printStackTrace();
        }
        return rcount;
    }

    public User[] allFetchUsertbl(){
        int count = this.countRecord();
        User[] userList = new User[count];
        String sql = "select * from usertbl";
        try{
            ResultSet rs = this.stmt.executeQuery(sql);
            int userCount=0;
            while(rs.next()){
                String userid = rs.getString("userid");
                String username = rs.getString("username");
                int birthyear = rs.getInt("birthyear");
                String addr = rs.getString("addr");
                String mobile1 = rs.getString("mobile1");
                String mobile2 = rs.getString("mobile2");
                int height = rs.getInt("height");
                Date mdate= rs.getDate("mdate");

                User user = new User(userid, username, birthyear, addr, mobile1, mobile2, height, mdate);
                userList[userCount++]=user;
            }
            rs.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return userList;
    }


    public User selectUser(String user_name){
        int count= this.countRecord();
        String sql= "select * from usertbl where username = '" + user_name+ "'" ;
        User user = null;
        try{
            ResultSet rs = this.stmt.executeQuery(sql);
            while(rs.next()){
                String userid = rs.getString("userid");
                String username = rs.getString("username");
                int birthyear = rs.getInt("birthyear");
                String addr = rs.getString("addr");

                String mobile1 = rs.getString("mobile1");
                String mobile2 = rs.getString("mobile2");
                int height = rs.getInt("height");
                Date mdate= rs.getDate("mdate");

                user = new User(userid, username, birthyear, addr, mobile1, mobile2, height, mdate);
                break;
            }
            rs.close();
            // 결과set을 닫을 거다.
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }


    public void inputUser(User user){
        String sql = "insert into usertbl values(?,?,?,?,?,?,?,?, null)";
        try{
            PreparedStatement pstmt = this.conn.prepareStatement(sql); //
            // 동적 쿼리 명령 객체 가져옴.
            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getUserName());
            pstmt.setInt(3, user.getBirthYear());
            pstmt.setString(4, user.getAddr());
            pstmt.setString(5, user.getMobile1());
            pstmt.setString(6, user.getMobile2());
            pstmt.setInt(7, user.getHeight());
            pstmt.setDate(8, user.getMdate());
            pstmt.executeUpdate();
            // 익스큐트 쿼리는 조회만 하고 나머진 다 이걸로 퉁침. 인서트 델리트 업데이트
            //영향받은 레코드의 수가 리턴됨.
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean deleteUser(String username){
        String sql = "delete from usertbl where username = '" + username + "'";
        try{
            int delete_count = this.stmt.executeUpdate(sql);
            if(delete_count > 0){
                return true;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void releaseDB(){
        try{
            this.stmt.close();
            this.conn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}// 클래스 끝
