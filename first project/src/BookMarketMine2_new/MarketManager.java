package BookMarketMine2_new;

import java.util.Scanner;

public class MarketManager {
boolean exitFlag;
Book [] mBookList=new Book[3];
Cart mCart= new Cart();// 생성이후로부터 도면의 내용을 다 가지면서 영향받는 분신이다.
    public MarketManager(){
        mBookList[0]= new Book("ISBN1234","쉽게 배우는 JSP 웹프로그래밍",27000,"송미영","단계별로 쇼핑몰을 구현하며 배우는 JSP 웹프로그래밍","IT전문서","2018/10/08");
        mBookList[1]= new Book("ISBN1235","안드로이드 프로그래밍",33000,"우재남","실습 단계별 명쾌한 멘토링!","IT전문서","2022/01/22");
        mBookList[2]= new Book("ISBN1236","스크래치",22000,"고광일","컴퓨팅 사고력을 키우는 블록 코딩","컴퓨터 입문","2019/06/10");
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

    //case1
    public void menuConfirmInfo(){

    }

    //case2
    public void menuConfirmItemCart(){
            this.mCart.cartCheck();
    }
        // 엠북리스트 안에 있는 북을 보내고 싶은데 어떻게 하면 좋을까,
        // 1.복수로 보내자니 매개변수의 칸이 한정되어있고 그때마다 여러게 보낼수는 없고,
        // 2.북리스트는 북의 형식이기는 하지만, 이렇게 보내면 인식이 불가능하다.
        // 해당 함수에서 뉴 생성자로 받아보는 방법은,
        // 해당 키워드: 배열 객체 클래스로 보내기
        // 카트 체크에는 아이객체만 보내면서 for문으로 돌리는 수 밖에 없을수도


    //case3
    public void menuClearCart(){

    }

    //case4
    public void menuAddCartItem(){
        Scanner input= new Scanner(System.in);
        System.out.println("더할 isbn입력하세요");
        String isbn=input.nextLine();
        boolean flag=false;



        for(int i=0;i<mBookList.length;i++){
            if(isbn.equals(this.mBookList[i].getIsbn())){
                for(int j=0;j<this.mCart.itemCount;j++){
                    if(this.mCart.cartList[j].getBook().getIsbn().equals(isbn)){
                        this.mCart.cartList[j].setItemCount(this.mCart.cartList[j].getItemCount()+1);
                        flag=!flag;
                        break;
                    }
                }
                if(!flag){
                    this.mCart.appendItem(this.mBookList[i]);
                    break;
                }
            }
        }

        // 기존 방식은 인덱스를 -1로 값 설정하고 북을 찾아야 해당 인덱스를 놓고 북을 찾아서 건네고 아니면 -1 < i 에 걸려서 예외처리 문구 출력.
    }

    //case5
    public void menuDecreaseCartItem(){
        Scanner input = new Scanner(System.in);
        System.out.println("줄일 isbn 입력");
        String inputIsbn = input.nextLine();
        for(int index=0; index < mCart.itemCount; index++){
            if(inputIsbn.equals(mCart.cartList[index].getBook().getIsbn())){
                this.mCart.decreaseItem(index);
                if(this.mCart.cartList[index].getItemCount()==0){
                    mCart.deleteItem(index);
                }
                break;
            }
        }
    }

    //case6
    public void menuDeleteCartItem(){
        Scanner input = new Scanner(System.in);
        System.out.println("지울 isbn 입력");
        String inputIsbn = input.nextLine();
        for(int index=0; index < mCart.itemCount; index++){
            if(inputIsbn.equals(mCart.cartList[index].getBook().getIsbn())){
                System.out.println(mCart.deleteItem(index).getTitle()+"을 삭제하였습니다.");
                break;
            }
        }
    }

    //case7
    public void menuConfirmBill(){

    }

    //case8
    public void menuAdminLogin(){

    }

}
