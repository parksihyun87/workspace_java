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

    public void menuCartItemList() {
        System.out.println("장바구니 상품 목록 보기");
        // mcart[i]에는 ()3가지가 담긴 카트아이템 자료형의 객체가 생성된다.
        // 카트아이템 클래스의 객체는 북객체 자체와, 카운트, 토탈프라이스가 주 구성원
        System.out.println("도서ID|상품개수|총 가격");
        for(int i=0;i<mCartItemCount;i++){
            System.out.println(mCart[i].getBook().getIsbn()+"|"
                    +mCart[i].getCount()+"|"
                    +mCart[i].getTotalPrice()+"|");
        }
    }

    public void menuCartRemoveItem(){
        System.out.println("장바구니 항목 줄이기");
        for(int i=0;i<mCartItemCount;i++){
            System.out.println(mCart[i].getBook().getIsbn()+"|"
                    +mCart[i].getCount()+"|"
                    +mCart[i].getTotalPrice()+"|");
        }

        System.out.println("줄일 ISBN ID 선택");
        Scanner s1= new Scanner(System.in);
        String inputIsbn=s1.nextLine();
        //포문
        for(int i=0;i<mCartItemCount;i++){
            if(mCart[i].getBook().getIsbn().equals(inputIsbn)){
                mCart[i].setCount(mCart[i].getCount()-1);
            }else{
                System.out.println("잘못된 ISBN입니다.");
            }
        }
    }


}
