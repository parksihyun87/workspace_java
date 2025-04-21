package BookMarketMine1_edited;

public class Cart {
    private CartItem[] mCart = new CartItem[3];
    private int mCartItemCount = 0;

    // bookid로 카트에 해당 책이 있는지 확인하는 boolean
    public boolean isCartInBook(String bookId){
        for(int i=0; i<mCartItemCount; i++){
            if(bookId.equals(mCart[i].getBook().getIsbn())){
                return true;
            }
        }
        return false;
    }

    // 장바구니 비우기,
    public void emptyCart(){
        this.mCart= new CartItem[3];
        this.mCartItemCount=0;
    }


    //카트에 책 담는 메서드 관련
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

    public void decreaseCartItem(String bookId){
        for(int i=0;i<mCartItemCount;i++){
            if(mCart[i].getBook().getIsbn().equals(bookId)){
                mCart[i].setCount(mCart[i].getCount()-1);
                if (mCart[i].getCount() == 0) {
                    String title=this.mCart[i].getBook().getTitle();
                    this.removeCartItem(i);
                    System.out.println(title+"삭제");
                }
                break;
            }
        }
    }
////   갯수 감소부분을 따로 함수 추가하여 작성.이것은 그냥 기록용
//// 더 로우 레벨의 배열 삭제해서 당기는 공식
////        for(int i=index; i<this.mCartItemCount-1;i++){
////            this.mCart[i]=this.mCart[i+1];
////        }
////        this.mCart[this.mCartItemCount-1]=null;
////        this.mCartItemCount--;
////    }
////

////        *필터와 유사한 방식으로 배열 재구성하는 방법1. 인덱스 받음
   private void removeCartItem(int index){
        CartItem[] newCartItemList=new CartItem[3];
        int number=0;
        for(int i=0; i<this.mCartItemCount;i++){
            if(i != index){
                newCartItemList[number++]=this.mCart[i];
            }
        }
        this.mCart=newCartItemList;
        this.mCartItemCount--;
   }
////        *필터와 유사한 방식으로 배열 재구성하는 방법2. ISBN 받음
    public String removeCartItem(String isbn){
        Book book=null;
            for(int i=0;i<mCartItemCount;i++){
            if(mCart[i].getBook().getIsbn().equals(isbn)){
                book= this.mCart[i].getBook();
                this.removeCartItem(i);
                break;
            }
        }
        return book.getTitle();
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

}


