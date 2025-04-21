package BookMarketMine2_new;

import java.util.Scanner;

public class MarketManager {
boolean exitFlag;
Book [] bookList=new Book[3];
Cart mCart= new Cart();
    public MarketManager(){
        bookList[0]= new Book("ISBN1234","쉽게 배우는 JSP 웹프로그래밍",27000,"송미영","단계별로 쇼핑몰을 구현하며 배우는 JSP 웹프로그래밍","IT전문서","2018/10/08");
        bookList[1]= new Book("ISBN1235","안드로이드 프로그래밍",33000,"우재남","실습 단계별 명쾌한 멘토링!","IT전문서","2022/01/22");
        bookList[2]= new Book("ISBN1236","스크래치",22000,"고광일","컴퓨팅 사고력을 키우는 블록 코딩","컴퓨터 입문","2019/06/10");
    }

    public void run(){
        // 기본 실행 디렉토리 생성.
        // 나중에 가져올 시 구현에 대하여 생각

        while (true) {

            System.out.println("1.고객정보확인 4.바구니항목추가");
            System.out.println("2.장바구니 상품목록확인 5.바구니 항목 수량 줄이기");
            System.out.println("3.장바구니 비우기 6.바구니 항목 삭제");
            System.out.println("7.영수증 표시 8.종료");
            System.out.println("9.관리자 로그인");
            System.out.println("번호선택");

            Scanner input= new Scanner(System.in);
            int typeNum=input.nextInt();
            input.nextLine();

            switch (typeNum){
                case 1:
                    menuConfirmInfo();
                break;

                case 2:
                    menuConfirmItemCart();
                break;

                case 3:
                    menuClearCart();
                break;

                case 4:
                    menuAddCartItem();
                break;

                case 5:;
                    menuDecreaseCartItem();
                break;

                case 6:
                    menuDeleteCartItem();
                break;

                case 7:
                    menuConfirmBill();
                break;

                case 8:
                    exitFlag=true;
                    break;

                case 9:
                    menuAdminLogin();
                break;
            }
            if(exitFlag){
                break;
            }
        }//while 메뉴 끝
    }// run method 끝

    public void menuConfirmInfo(){

    }
    public void menuConfirmItemCart(){
        this.mCart.cartCheck(bookList[0]);
    }
    public void menuClearCart(){

    }
    public void menuAddCartItem(){
        Scanner input= new Scanner(System.in);
        System.out.println("더할 isbn입력하세요");
        String isbn=input.nextLine();
        this.mCart.appnedBooks(this.bookList[0]);
    }
    public void menuDecreaseCartItem(){

    }
    public void menuDeleteCartItem(){

    }
    public void menuConfirmBill(){

    }
    public void menuAdminLogin(){

    }

}//market manager 클래스 끝
