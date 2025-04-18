public class Cart {
    private CartItem[]  mCart = new CartItem[3];
    private int mCartItemCount = 0;

    public boolean isCartInBook(String bookId){
        for(int i=0; i<this.mCartItemCount; i++){
            if(bookId.equals(this.mCart[i].getBook().getIsbn())){
                return true;
            }
        }
        return false;
    }

    public void clearCart(){
        this.mCart = new CartItem[3];
        this.mCartItemCount = 0;
    }

    public Book removeCartItem(String bookId){
        Book book = null;
        for(int i=0; i<this.mCartItemCount; i++){
            if(this.mCart[i].getBook().getIsbn().equals(bookId)){
                book = this.mCart[i].getBook();
                this.removeCartItem(i);
                break;
            }
        }
        return book;
    }

    public void appendBook(Book book){
        this.mCart[this.mCartItemCount] = new CartItem(book);
        this.mCartItemCount++;
    }

    public void inCreaseBookCount(String bookid){
        for(int i=0; i<this.mCartItemCount; i++) {
            if(this.mCart[i].getBook().getIsbn().equals(bookid)) {
                this.mCart[i].setCount(this.mCart[i].getCount()+1);
                return;
            }
        }
    }

    public Book deCreaseBookCount(String bookid){
        Book book = null;
        for(int i=0 ; i< this.mCartItemCount; i++){
            if(this.mCart[i].getBook().getIsbn().equals(bookid)){
                book = this.mCart[i].getBook();
                this.mCart[i].setCount(this.mCart[i].getCount() - 1);
                if(this.mCart[i].getCount() == 0){
                    System.out.println("수량이 0이 되어 항목을 장바구니에서 삭제합니다.");
                    this.removeCartItem(i);
                    break;
                }
            }
        }
        return book;
    }

    private void removeCartItem(int index){
//        for(int i=index; i<this.mCartItemCount-1; i++){
//            this.mCart[i] = this.mCart[i+1];
//        }
//
//        this.mCart[this.mCartItemCount-1] = null;
//        this.mCartItemCount--;

        CartItem[] newCarItemList = new CartItem[3];
        int number = 0;
        for(int i =0; i<this.mCartItemCount; i++){
            if(i != index){
                newCarItemList[number++] = this.mCart[i];
            }
        }
        this.mCart=newCarItemList;
        this.mCartItemCount--;
    }

    public void printCart(){
        System.out.println("장바구니 상품 목록 보기 :");
        System.out.println("---------------------------------------------");
        System.out.println("도서ID\t\t|수량\t\t\t\t|총가격");

        for (int i = 0; i < this.mCartItemCount; i++) {
            System.out.print((i+1)+" "+this.mCart[i].getBook().getIsbn() + "\t| ");
            System.out.print(this.mCart[i].getCount() + "\t\t\t\t| ");
            System.out.print(this.mCart[i].getTotalPrice());
            System.out.println();
        }
        System.out.println("---------------------------------------------");
    }

}
