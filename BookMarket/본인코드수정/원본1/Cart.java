import java.util.Scanner;

public class Cart {
    private CartItem[] mCart = new CartItem[3];
    // 빈카트를 만들어서 북담을 배열을 만듬. 이 안에서 중복여부로 어떤 것을 늘릴지 선택.
    private int mCartItemCount = 0;

    public boolean isCartInBook(String bookId){
        for(int i=0; i<mCartItemCount; i++){
            if(bookId.equals(mCart[i].getBook().getIsbn())){
                return true;
            }
        }
        return false;
    }

    public void appendBook(Book book){
        mCart[mCartItemCount++] = new CartItem(book);
    }

    public void increaseBookCount(String bookid){
        for(int i=0; i<mCartItemCount; i++){
            if(bookid.equals(mCart[i].getBook().getIsbn())){
                mCart[i].setCount(mCart[i].getCount() + 1);
            }
        }
    }

    public void printCart() {
        System.out.println("장바구니 상품 목록 보기");
        // mcart[i]에는 ()3가지가 담긴 카트아이템 자료형의 객체가 생성된다.
        // 카트아이템 클래스의 객체는 북객체 자체와, 카운트, 토탈프라이스가 주 구성원
        System.out.println("도서ID|상품개수|총 가격");
        for(int i=0;i<mCartItemCount;i++){
            System.out.println((i+1)+mCart[i].getBook().getIsbn()+"|"
                    +mCart[i].getCount()+"|"
                    +mCart[i].getTotalPrice()+"|");
        }
    }

    // 메뉴에서 항목 줄이는 부분
//    public void menuCartRemoveItemCount(){
//        while(true) {
//            this.printCart();
//            //
//            System.out.println("줄일 ISBN ID 선택");
//            Scanner s1 = new Scanner(System.in);
//            String inputIsbn = s1.nextLine();
//

//* 복구 키워드: 해당 부분에서 카트제거 함수,줄이는 함수 넣어서 실행
//            for (int i = 0; i < mCartItemCount; i++) {
//                if (mCart[i].getBook().getIsbn().equals(inputIsbn)) {
//                    mCart[i].setCount(mCart[i].getCount() - 1);
//                    if (mCart[i].getCount() == 0) {
//                        this.removeCartItem(i);
//
//                        브레이크 지운 부분
//                        mCart[i] = null;
//                        mCartItemCount--;
//                    }
//                    break;
//                } else {
//                    System.out.println("잘못된 ISBN입니다.");
//                }
//            }

//        }
//    }

//?? 위에 브레이크 써서 끊어줌

////   갯수 감소부분을 따로 함수 추가하여 작성.이것은 그냥 기록용
//// 더 로우 레벨의 배열 삭제해서 당기는 공식
////        for(int i=index; i<this.mCartItemCount-1;i++){
////            this.mCart[i]=this.mCart[i+1];
////        }
////        this.mCart[this.mCartItemCount-1]=null;
////        this.mCartItemCount--;
////    }
////

// * 복구 키워드: 카트제거 함수
//   private void removeCartItem(int index){
////        *필터와 유사한 방식으로 배열 재구성하는 방법
//        CartItem[] newCartItemList=new CartItem[3];
//        int number=0;
//        for(int i=0; i<this.mCartItemCount;i++){
//            if(i != index){
//                newCartItemList[number++]=this.mCart[i];
//            }
//        }
//        this.mCart=newCartItemList;
//        this.mCartItemCount--;
//    }
//

//    * 복구 키워드: 줄이는 부분이여서 갯수 감수부를 넣어 줌.

/// }
/// }
/// return book;
/// }

// 장바구니 비우기,
    public void emptyCart(){
        this.mCart= new CartItem[3];
        this.mCartItemCount=0;
    }

// 장바구니 항목 삭제하기
    public void deleteCart(){
    this.printCart();
    System.out.println("삭제항목의 ISBN입력");
    Scanner s1= new Scanner(System.in);
    String isbn=s1.nextLine();
    CartItem[] newCartItemList=new CartItem[3];
    int number=0;
        if(this.isCartInBook(isbn)){
            // 이렇게 쓰지 말고 오버로딩을 하나 해서
            // 인덱스 받는 것과, 아이디 받는 것 두개를 만들어서 제 위치에서 호출.
            for(int i=0;i<mCartItemCount;i++){
                if(this.mCart[i].getBook().getIsbn().equals(isbn)){
                    for(int j=0;j<mCartItemCount;j++){
                        if(j != i){
                            newCartItemList[number++]=this.mCart[i];
                        }
                    }
                    break;
                }
            }
            this.mCart=newCartItemList;
            this.mCartItemCount--;
        }else{
            System.out.println("틀린 ISBN");
        }
    }
}
