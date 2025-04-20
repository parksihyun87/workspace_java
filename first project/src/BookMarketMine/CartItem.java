package BookMarketMine;

public class CartItem {
    //북 객체를 담아내는 함수의 역할을 한다.
    private Book book;
    private int count;
    private int totalPrice;

    public CartItem(Book book, int count){
        this.book = book;
        this.count = count;
        this.updateTotalPrice();
    }

    public CartItem(Book book){
        this.book = book;
        this.count = 1;
        this.updateTotalPrice();
    }
    //메서드 오버로딩

    public void updateTotalPrice(){
        this.totalPrice = this.book.getPrice() * this.count;
    }

    public Book getBook(){
        return this.book;
    }

    public int getCount(){
        return this.count;
    }

    public int getTotalPrice(){
        return this.totalPrice;
    }

    public void setCount(int count){
        this.count = count;
        this.updateTotalPrice();
    }
}
