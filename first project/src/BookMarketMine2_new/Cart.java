package BookMarketMine2_new;

//작업 키워드
// 1.어펜드 북스 형태 원본 비교
// 1-1. 단순한 형태, 구조적 투영 생각하여 어펜드 북스 작성

public class Cart {
//    Book[] mbookList;
    Book[] mbookList=new Book[3];
    CartItem [] cartList=new CartItem[3];
    int itemCount;
    CartItem mCartItem;



    // 카트 클래스에서 매니저의 객체를 가져와 정보를 받는 방법도 있겠으나, 그냥 북형태로 변수를 만들고 북으로 정보를 건네받으면
    // 그것을 활용하는게 낫다.
    public void appnedBooks(Book book){
        this.cartList[itemCount++]=new CartItem(book);
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
}

