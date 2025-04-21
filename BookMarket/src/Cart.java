public class Cart implements CartInterface{
    //컨트롤 클래스, 콘트롤 함수 중심이다. 다른 아이템을 파는 확장성을 고려하여
    // 인터페이스를 작성
    private CartItem[]  mCart = new CartItem[3];
    private int mCartItemCount = 0;

    @Override
    public boolean isCartInItem(String bookId){
        for(int i=0; i<this.mCartItemCount; i++){
            if(bookId.equals(this.mCart[i].getBook().getItemId())){
                return true;
            }
        }
        return false;
    }

    @Override
    public void clearCart(){
        this.mCart = new CartItem[3];
        this.mCartItemCount = 0;
    }

    @Override
    public Item removeCartItem(String bookId){
        Book book = null;
        for(int i=0; i<this.mCartItemCount; i++){
            if(this.mCart[i].getBook().getItemId().equals(bookId)){
                book = this.mCart[i].getBook();
                this.removeCartItem(i);
                break;
            }
        }
        return book;
    }

    @Override
    public void appendItem(Item book){
        this.mCart[this.mCartItemCount] = new CartItem((Book) book);
        // 커서 위치해 보면, 아이템을 북으로 받으려고 오류가 남. 형변환해주면 다운캐스팅이 되어, 부모 클래스의
        // 자료형으로만 보이던 안보이던 부분이 다시 보이게 됨.
        // 필요한 부분만 아이템에서 북으로 자료형 변환을 시켜줌.
        this.mCartItemCount++;
    }

    @Override
    public void inCreaseItemCount(String bookid){
        for(int i=0; i<this.mCartItemCount; i++) {
            if(this.mCart[i].getBook().getItemId().equals(bookid)) {
                this.mCart[i].setCount(this.mCart[i].getCount()+1);
                return;
            }
        }
    }

    @Override
    public Item deCreaseItemCount(String bookid){
        Book book = null;
        for(int i=0 ; i< this.mCartItemCount; i++){
            if(this.mCart[i].getBook().getItemId().equals(bookid)){
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
    @Override
    public void removeCartItem(int index){
        // 퍼블릭 고치기
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

    @Override
    public void printCart(){
        System.out.println("장바구니 상품 목록 보기 :");
        System.out.println("---------------------------------------------");
        System.out.println("도서ID\t\t|수량\t\t\t\t|총가격");

        for (int i = 0; i < this.mCartItemCount; i++) {
            System.out.print((i+1)+" "+this.mCart[i].getBook().getItemId() + "\t| ");
            System.out.print(this.mCart[i].getCount() + "\t\t\t\t| ");
            System.out.print(this.mCart[i].getTotalPrice());
            System.out.println();
        }
        System.out.println("---------------------------------------------");
    }
}


