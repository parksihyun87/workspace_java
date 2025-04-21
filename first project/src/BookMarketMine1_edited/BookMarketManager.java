package BookMarketMine1_edited;

import java.util.Scanner;

public class BookMarketManager {

     private Book[] bookList=new Book[3];
     private Cart mcart=new Cart();

    public BookMarketManager(){
    bookList[0]= new Book("ISBN1234","쉽게 배우는 JSP 웹프로그래밍",27000,"송미영","단계별로 쇼핑몰을 구현하며 배우는 JSP 웹프로그래밍","IT전문서","2018/10/08");
    bookList[1]= new Book("ISBN1235","안드로이드 프로그래밍",33000,"우재남","실습 단계별 명쾌한 멘토링!","IT전문서","2022/01/22");
    bookList[2]= new Book("ISBN1236","스크래치",22000,"고광일","컴퓨팅 사고력을 키우는 블록 코딩","컴퓨터 입문","2019/06/10");
    }
    //생성자 함수를 멤버 변수의 초기값을 지정해 주는 것으로. 초기값 선언은 함수안에서만 이루어지므로, 생성자 함수에서 이루어지는 것이 좋으며,
    //구동시마다 다른 초기값을 지정할 게 아니라면, 매개변수는 공란으로 두고 배열안에 들어갈 값을 적어 자동으로 값이 나타나도록 한다.

    public void run() {

        Scanner input = new Scanner(System.in);
        System.out.print("당신의 이름을 입력하세요 : ");
        String name = input.nextLine();
        System.out.print("연락처를 입력하세요 : ");
        String phone = input.nextLine();

        Person user = new Person(name, phone);
        // 여기서 유저 객체 만듬, 이름과 폰번호 넣어서 만듬.
        // 유저가 생겼음.

        while(true){
            boolean endflag=false;
            menuIntroduction();
            System.out.print("메뉴 번호를 선택하세요: ");
            int select = input.nextInt();
            switch (select) {
                case 1:
                    menuGuestInfo(user);
                    break;
                case 2:
                    menuCartItemList();
                    break;
                case 3:
                    menuCartClear();
                    break;
                case 4:
                    menuCartAddItem();
                    break;
                case 5:
                    menuCartRemoveItemCount();
                    break;
                case 6:
                    menuCartRemoveItem();
                    break;
                case 7:
                    menuCartBill();
                    break;
                case 8:
                    endflag = true;
                    System.out.println("종료");
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

        System.out.println("***********************************************");
    }

    public void menuGuestInfo(Person user) {
        System.out.println("현재 고객 정보 : ");
        System.out.println("이름 " + user.getName() +
                " 전화번호 " + user.getPhone());
    }

    public void menuCartItemList(){
        mcart.printCart();
    }

    public void menuCartClear() {
        System.out.println("장바구니 비우기");
        mcart.emptyCart();
    }

    // 장바구니 항목 추가 구현
    public void menuCartAddItem() {
        System.out.println("장바구니 항목 추가하기 ");
        
        // 책 선택 위한 목록 출력
        for (int i = 0; i < bookList.length; i++) {
            System.out.print(bookList[i].getIsbn() + " | ");
            System.out.println();
        }

        while (true) {
            boolean exit = false;
            System.out.print("장바구니에 추가할 도서의 ID를 입력하세요 : ");
            Scanner input = new Scanner(System.in);
            String bookid = input.nextLine();

            int index = -1;

            for (int i = 0; i < bookList.length; i++) {
                if (bookid.equals(bookList[i].getIsbn())) {
                    index = i;// 장바구니에 추가되고 있는 도서의 id
                    break;
                }
            }

            if (index != -1) {
                // 만약에 책이 있으면 해당 실행
                System.out.println("장바구니에 추가하겠습니까? Y|N");
                String yn = input.nextLine();

                if (yn.toUpperCase().equals("Y")) {
                    if(mcart.isCartInBook(bookid)){
                       mcart.increaseBookCount(bookid);
                    }else{
                       mcart.appendBook(bookList[index]);
                    }
                    System.out.println(bookList[index].getTitle() + "가 장바구니에 추가되었습니다.");
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
    RemoveCartItemCount();
    }

    public void menuCartRemoveItem() {
        System.out.println("장바구니의 항목 삭제하기");
        deleteCart();
    }
    // 항목 수량 줄이기
    public void RemoveCartItemCount(){
        while(true) {
            this.mcart.printCart();
            //
            System.out.println("줄일 ISBN ID 선택");
            Scanner s1 = new Scanner(System.in);
            String inputIsbn = s1.nextLine();

            if (this.mcart.isCartInBook(inputIsbn)) {
                this.mcart.decreaseCartItem(inputIsbn);
                break;
            } else {
                System.out.println("잘못된 ISBN입니다.");
            }
        }
    }
    // 장바구니 항목 삭제하기
    public void deleteCart(){
        this.mcart.printCart();
        System.out.println("삭제항목의 ISBN입력");
        Scanner s1= new Scanner(System.in);
        String isbn=s1.nextLine();
        if(this.mcart.isCartInBook(isbn)){
            System.out.println(this.mcart.removeCartItem(isbn)+"를 삭제하였음");
        }else{
            System.out.println("틀린 ISBN");
        }
    }

    public void menuCartBill() {
        System.out.println("영수증 표시하기");
    }

}
