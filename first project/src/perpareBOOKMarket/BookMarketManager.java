package perpareBOOKMarket;

import java.util.ArrayList;
import java.util.Scanner;

public class BookMarketManager {
//    private Book[] mBook = new Book[3];
    private ArrayList<Book> mBook= new ArrayList<>(3);
    private Cart mCart = new Cart();
    private Person mCurrentUser=null;
    // 퍼슨의 자료형으로 커런트 유저를 만들때, 유저나 어드민은 둘 다 연계가 가능하다.


    public BookMarketManager() {
        Book book1=new Book("ISBN1234","쉽게 배우는 JSP 웹프로그래밍",27000,
                "송미영","단계별로 구현하여 배우는 JSP 프로그래밍","IT전문서",
                "2018/10/08");
        Book book2=new Book("ISBN1235","안드로이드 프로그래밍",33000,"우재남",
                "실습단계별 명확한 멘토링!","IT전문서","2022/01/22");

        Book book3=new Book("ISBN1236","스크래치", 22000,"고광일",
                "컴퓨팅 사고력을 키우는 블록 코딩","컴퓨터 입문","2019/06/10");
        this.mBook.add(book1);
        this.mBook.add(book2);
        this.mBook.add(book3);
    }

    public void run(){
        Scanner input = new Scanner(System.in);
        System.out.print("당신의 이름을 입력하세요 : ");
        String name = input.nextLine();
        System.out.print("연락처를 입력하세요 : ");
        String phone = input.nextLine();

        Person user = new User(name, phone);
        // 유저는 퍼슨의 자식(확장받음)이며, 퍼슨으로 인해 매개변수를 입력받아 가지고 있으며 아직 다른 정보들은 가지고 있지 않다.
        // 유저로 만들면 상속 개념이 더 확실함.
        mCurrentUser=user;

        while(true){
            boolean endflag=false;
            menuIntroduction();
            System.out.print("메뉴 번호를 선택하세요: ");
            int select = input.nextInt();
            switch (select) {
                case 1:
                    this.menuGuestInfo(user);
                    break;
                case 2:
                    this.menuCartItemList();
                    break;
                case 3:
                    this.menuCartClear();
                    break;
                case 4:
                    this.menuCartAddItem();
                    break;
                case 5:
                    this.menuCartRemoveItemCount();
                    break;
                case 6:
                    this.menuCartRemoveItem();
                    break;
                case 7:
                    this.menuCartBill();
                    break;
                case 8:
                    endflag = true;
                    System.out.println("종료");
                    break;
                case 9:
                    this.menuAdminLogin();
                    break;
            }

            if(endflag){
                break;
            }
        }
    }
    public void menuIntroduction() {
        String greeting = "Welcome to Shopping Mall";
        String tagline = "Welcome to Book Market!";

        System.out.println("***********************************************");
        System.out.println("\t" + greeting);
        System.out.println("\t" + tagline);
        System.out.println("***********************************************");
        System.out.println("1. 고객정보 확인하기 \t\t\t4. 바구니에 황목 추가하기");
        System.out.println("2. 장바구니 상품 목록 보기\t\t5. 장바구니의 항목 수량 줄이기");
        System.out.println("3. 장바구니 비우기\t\t\t\t6. 장바구니의 항목 삭제하기");
        System.out.println("7. 영수증 표시하기\t\t\t\t8. 종료");
        System.out.println("9. 관리자 로그인");
        

        System.out.println("***********************************************");
    }

    public void menuGuestInfo(Person user) {
        System.out.println("현재 고객 정보 : ");
        System.out.println("이름 " + user.getName() +
                " 전화번호 " + user.getPhone());
    }

    public void menuCartItemList() {
        this.mCart.printCart();
    }

    public void menuCartClear() {
        System.out.println("장바구니 비우기");
        this.mCart.clearCart();
    }

    public void bookList(){
        for(int i=0; i<this.mBook.size(); i++) {
            System.out.print("도서 ID :");
            System.out.println(this.mBook.get(i).getItemId());
            System.out.print("도서 이름: ");
            System.out.println(this.mBook.get(i).getName());
            System.out.print("도서 가격: ");
            System.out.println(this.mBook.get(i).getPrice());
            System.out.print("저자 : ");
            System.out.println(this.mBook.get(i).getAuthor());
            System.out.print("도서 설명 : ");
            System.out.println(this.mBook.get(i).getDescription());
            System.out.print("분류 : ");
            System.out.println(this.mBook.get(i).getCategory());
            System.out.print("출판일 : ");
            System.out.println(this.mBook.get(i).getPublishDate());
            System.out.println("======================================");
        }
    }

    public void menuCartAddItem() {
        System.out.println("장바구니 항목 추가하기 ");

        bookList();

        while (true) {
            boolean exit = false;
            System.out.print("장바구니에 추가할 도서의 ID를 입력하세요 : ");

            Scanner input = new Scanner(System.in);
            String bookid = input.nextLine();

            int index = -1;

            for (int i = 0; i < this.mBook.size(); i++) {
                if (bookid.equals(this.mBook.get(i).getItemId())) {
                    index = i;
                    break;
                }
            }

            if (index != -1) {
                System.out.println("장바구니에 추가하겠습니까? Y|N");
                String yn = input.nextLine();

                if (yn.toUpperCase().equals("Y")) {
                    if(this.mCart.isCartInItem(bookid)){
                        this.mCart.inCreaseItemCount(bookid);
                    }else{
                        this.mCart.appendItem(this.mBook.get(index));
                    }
                    System.out.println(this.mBook.get(index).getName() + "이(가) 장바구니에 추가되었습니다.");
                }
                exit = true;
            } else {
                System.out.println("도서가 존재하지 않습니다.");
            }

            if(exit){
                break;
            }

        }
    }



    public void menuCartRemoveItemCount() {
        System.out.println("장바구니에 항목 수량 줄이기");
        while(true){
            this.mCart.printCart();
            System.out.println("수량을 줄이실 도서ID를 입력하세요 : ");
            Scanner input = new Scanner(System.in);
            String bookId = input.nextLine();
            if(!this.mCart.isCartInItem(bookId)){
                System.out.println("장바구니에 존해하는 도서가 아닙니다.");
                continue;
            }
            System.out.println(bookId + "의 수량을 줄이시겠습니까? Y|N");
            String yn = input.nextLine();
            if(yn.toUpperCase().equals("Y")){
                Book book = (Book) this.mCart.deCreaseItemCount(bookId);
                //북 개체인지 확신이 없으므로
                // 위에를 Item item
//                Book book=null;
//                if(item instanceof Book) {
//                    book=(Book)item;
//                }
                // 인스탄스 오브는 원래 정체를 물어봄
                System.out.println( book.getName() + " 한권이 장바구니에서 삭제되었습니다. ");
            }
            break;
        }
    }

    public void menuCartRemoveItem() {
        System.out.println("장바구니의 항목 삭제하기");
        this.mCart.printCart();
        System.out.println("삭제할 항목의 ISBN을 입력하세요 : ");
        Scanner input = new Scanner(System.in);
        String bookId = input.nextLine();
        if(this.mCart.isCartInItem(bookId)){
            Book book = (Book) this.mCart.removeCartItem(bookId);
            // 업케스팅을 다운캐스팅 해줘서 사용가능하게 함.
            System.out.println(book.getName() + "가 장바구니에서 삭제되었습니다.");
        }else{
            System.out.println("장바구니에 없는 책입니다.");
        }
    }

    public void menuCartBill() {
        System.out.println("영수증 표시하기");
    }

    public void menuAdminLogin(){
        AdminLoginProcess();
    }

    public void AdminLoginProcess(){
        // 만약 클래스로 들어가려면 각 객체의 데이터를 표현하는 함수가 맞는가를 기준으로 소속을 정한다.
        // 지금 같은 경우는 잠깐 공용으로 사용하고 두는 버퍼객체를 이용하는 것도 매니저에 있게되는 데에 영향이 있다.
        // 공통 버퍼를 제외하고 클래스에도 속하게 하려면 이중으로 함수 호출한다.
        Scanner input= new Scanner(System.in);
        Admin admin= new Admin(this.mCurrentUser.getName(),this.mCurrentUser.getPhone());
        // 어드민은 퍼슨으로부터 상속받은 클래스, id와 pw의 자체 추가 정보를 가지고 있다.
        boolean loginFlag=false;

        while(true){
            System.out.println("관리자 정보를 입력하세요");
            System.out.println("id 입력");
            String Id=input.nextLine();
            System.out.println("pw 입력");
            String pw=input.nextLine();

            if(admin.getId().equals(Id)){
                if(admin.getPw().equals(pw)){
                    System.out.println("로그인 성공");
                    loginFlag=!loginFlag;
                    this.mCurrentUser=admin;
                    // 커런트 유저에 admin 자료형으로 만든 자료도 들어가는데, Person admin객체 식이 되고, person에서 정의한 자료로 공개범위가 한정되어 사용 가능하다.
                    break;
                }
                System.out.println("pw가 틀렸습니다.");
            }
            if(!loginFlag){
                System.out.println("로그인 id가 틀렸습니다.");
            }
        }
        // 이렇게 안하고 그냥 if 구문 && 로 확인 정도만 해도 괜찮다.
        System.out.println("로그인 정보는 id:"+admin.getId()+" pw:"+admin.getPw()+"입니다.");
        System.out.println("이름:"+mCurrentUser.getName()+" 번호:"+mCurrentUser.getPhone());
    }
}
