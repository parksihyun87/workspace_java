import java.util.ArrayList;
import java.util.Iterator;

public class Cart implements CartInterface{
    private ArrayList<CartItem> mCart = new ArrayList<>(3);
//    private int mCartItemCount = 0;

    @Override
    public boolean isCartInItem(String bookId){
        for(CartItem cartItem : this.mCart){
            if(bookId.equals(cartItem.getBook().getItemId())){
                return true;
            }
        }
        return false;
    }

    @Override
    public void clearCart(){
        this.mCart.clear();
//        this.mCartItemCount = 0;
    }

    @Override
    public Item removeCartItem(String bookId){
        Book book = null;
//        this.mCart.removeIf(e->e.getBook().getItemId().equals(bookId));
//        for(CartItem cartItem : this.mCart){
//            if(cartItem.getBook().getItemId().equals(bookId)){
//                book = cartItem.getBook();
//                this.mCart.remove(cartItem);
//                break;
//            }
//        }
        Iterator<CartItem> iter = this.mCart.iterator();
        while(iter.hasNext()){
            CartItem item = iter.next();
            if(item.getBook().getItemId().equals(bookId)){
                book = item.getBook();
                iter.remove();
            }
        }
        return book;
    }

    @Override
    public void appendItem(Item book){
        this.mCart.add(new CartItem((Book)book));
//        this.mCartItemCount++;
    }

    @Override
    public void increaseItemCount(String bookid){
        for(CartItem cartItem : this.mCart) {
            if(cartItem.getBook().getItemId().equals(bookid)) {
                cartItem.setCount(cartItem.getCount()+1);
                return;
            }
        }
    }

    @Override
    public Item decreaseItemCount(String bookid){
        Book book = null;
        for(CartItem cartItem : this.mCart){
            if(cartItem.getBook().getItemId().equals(bookid)){
                book = cartItem.getBook();
                cartItem.setCount(cartItem.getCount() - 1);
                if(cartItem.getCount() == 0){
                    System.out.println("수량이 0이 되어 항목을 장바구니에서 삭제합니다.");
                    this.mCart.remove(cartItem);
                    break;
                }
            }
        }
        return book;
    }

//    @Override
//    public void removeCartItem(int index){
////        for(int i=index; i<this.mCartItemCount-1; i++){
////            this.mCart[i] = this.mCart[i+1];
////        }
////
////        this.mCart[this.mCartItemCount-1] = null;
////        this.mCartItemCount--;
//
//        CartItem[] newCarItemList = new CartItem[3];
//        int number = 0;
//        for(int i =0; i<this.mCartItemCount; i++){
//            if(i != index){
//                newCarItemList[number++] = this.mCart[i];
//            }
//        }
//        this.mCart=newCarItemList;
//        this.mCartItemCount--;
//    }

    @Override
    public void printCart(){
        System.out.println("장바구니 상품 목록 보기 :");
        System.out.println("---------------------------------------------");
        System.out.println("도서ID\t\t|수량\t\t\t\t|총가격");

        for (CartItem cartItem : this.mCart) {
            System.out.print((this.mCart.indexOf(cartItem)+1)+" "+cartItem.getBook().getItemId() + "\t| ");
            System.out.print(cartItem.getCount() + "\t\t\t\t| ");
            System.out.print(cartItem.getTotalPrice());
            System.out.println();
        }
        System.out.println("---------------------------------------------");
    }
}
