import java.util.ArrayList;
import java.util.HashMap;

public class Cart implements CartInterface{
    //컨트롤 클래스, 콘트롤 함수 중심이다. 다른 아이템을 파는 확장성을 고려하여
    // 인터페이스를 작성
    private ArrayList<CartItem> mCart = new ArrayList<>(3);
//    private int mCart.size() = 0;

    @Override

    //cartItem안에 아이템이 있는지 확인할때 hashmap을 사용할 수 있음

    public boolean isCartInItem(String bookId){
        for(int i=0; i<this.mCart.size(); i++){
            if(bookId.equals(this.mCart.get(i).getBook().getItemId())){
                return true;
            }
        }
        return false;
    }

    @Override
    public void clearCart(){
        this.mCart = new ArrayList<CartItem>(3);
    }

    @Override
    public void appendItem(Item book){
        this.mCart.add(new CartItem((Book) book));
        // 커서 위치해 보면, 아이템을 북으로 받으려고 오류가 남. 형변환해주면 다운캐스팅이 되어, 부모 클래스의
        // 자료형으로만 보이던 안보이던 부분이 다시 보이게 됨.
        // 필요한 부분만 아이템에서 북으로 자료형 변환을 시켜줌.
//        this.mCart.size()++;
    }

    @Override
    public void inCreaseItemCount(String bookid){
        for(int i=0; i<this.mCart.size(); i++) {
            if(this.mCart.get(i).getBook().getItemId().equals(bookid)) {
                this.mCart.get(i).setCount(this.mCart.get(i).getCount()+1);
                return;
            }
        }
    }

    //진행 키워드: 카트아이템 삭제 참조
    @Override
    public Item deCreaseItemCount(String bookid){
        Book book = null;
        for(int i=0 ; i< this.mCart.size(); i++){
            if(this.mCart.get(i).getBook().getItemId().equals(bookid)){
                book = this.mCart.get(i).getBook();
                this.mCart.get(i).setCount(this.mCart.get(i).getCount() - 1);
                if(this.mCart.get(i).getCount() == 0){
                    System.out.println("수량이 0이 되어 항목을 장바구니에서 삭제합니다.");
                    this.mCart.remove(i);
//                  this.removeCartItem(i);
                    break;
                }
            }
        }
        return book;
    }

    @Override
    public Item removeCartItem(String bookId){
        Book book = null;
        for(CartItem item : this.mCart){
            if(item.getBook().getItemId().equals(bookId)){
                book = item.getBook();
                this.mCart.remove(item);
                // 어레이리스트는 리무브 사용시 해당 배열칸이 자동으로 삭제되고 당겨진다.
                // 향상 for문 돌면서 지우는 것도 가능.
                break;
            }
        }
        return book;
    }

//    public void removeCartItem(int index){
     //    @Override
//    public void removeCartItem(int index){
//        // 퍼블릭 고치기
////        for(int i=index; i<this.mCart.size()-1; i++){
////            this.mCart.get(i) = this.mCart[i+1];
////        }
////
////        this.mCart[this.mCart.size()-1] = null;
////        this.mCart.size()--;
//
////        CartItem[] newCarItemList = new CartItem[3];
//        ArrayList<CartItem> newCarItemList=new ArrayList<>(3);
//        int number = 0;
//        for(int i =0; i<this.mCart.size(); i++){
//            if(i != index){
//                newCarItemList.add(this.mCart.get(i));
//            }
//        }
//        this.mCart=newCarItemList;
//        this.mCart.size()--;
//        }

    @Override
    public void printCart(){
        System.out.println("장바구니 상품 목록 보기 :");
        System.out.println("---------------------------------------------");
        System.out.println("도서ID\t\t|수량\t\t\t\t|총가격");

        for (int i = 0; i < this.mCart.size(); i++) {
            System.out.print((i+1)+" "+this.mCart.get(i).getBook().getItemId() + "\t| ");
            System.out.print(this.mCart.get(i).getCount() + "\t\t\t\t| ");
            System.out.print(this.mCart.get(i).getTotalPrice());
            System.out.println();
        }
        System.out.println("---------------------------------------------");
    }
}


