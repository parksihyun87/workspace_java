package BookMarketMine2_new;

//작업 키워드
// 1.어펜드 북스 형태 원본 비교
// 1-1. 단순한 형태, 구조적 투영 생각하여 어펜드 북스 작성

public class Cart implements ItemFunction {
    CartItem[] cartList = new CartItem[3];
    int itemCount;
    // 카트 클래스에서 매니저의 객체를 가져와 정보를 받는 방법도 있겠으나, 그냥 북형태로 변수를 만들고 북으로 정보를 건네받으면
    // 그것을 활용하는게 낫다.

    @Override
    public void appendItem(Item book) {
        this.cartList[itemCount++] = new CartItem((Book) book);
    }

    //카트내용 확인
    public void cartCheck() {

        for (int i = 0; i < itemCount; i++) {
            System.out.println(this.cartList[i].getBook().getIsbn());
            System.out.println(this.cartList[i].getBook().getTitle());
            System.out.println(this.cartList[i].getBook().getPrice());
            System.out.println(this.cartList[i].getItemCount());
        }
    }

    public Book deleteItem(int index) {
        int newInnerIndex=0;
        Book returnBook=this.cartList[index].getBook();
        CartItem [] newCartList= new CartItem[3];
        for(int i=0 ; i<this.itemCount; i++){
            if(i!=index){
                newCartList[newInnerIndex++]=cartList[i];
            }
        }
        this.cartList=newCartList;
        itemCount--;
        return returnBook;
    }// deleteItem 끝

    public void decreaseItem(int index){
        this.cartList[index].setItemCount(this.cartList[index].getItemCount()-1);
    }
}//카트 클래스 끝



