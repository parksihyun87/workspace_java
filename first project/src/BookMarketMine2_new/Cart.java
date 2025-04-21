package BookMarketMine2_new;

public class Cart {
    CartItem [] cartList=new CartItem[3];
    int itemCount;
    CartItem mCartItem;


    // 카트 클래스에서 매니저의 객체를 가져와 정보를 받는 방법도 있겠으나, 그냥 북형태로 변수를 만들고 북으로 정보를 건네받으면
    // 그것을 활용하는게 낫다.
    public void appnedBooks(Book book){
        this.cartList[0]=new CartItem(book);
        mCartItem=new CartItem(book);
        itemCount++;
    }
    //모든 것은 담아오면서 시작함.
    public void cartCheck(Book book){
        for(int i=0;i<itemCount;i++){
            System.out.println(book.getIsbn());
            System.out.println(book.getTitle());
            System.out.println(book.getPrice());
        }
    }



}
