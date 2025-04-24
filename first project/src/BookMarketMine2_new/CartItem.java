package BookMarketMine2_new;

public class CartItem {
    Book book;
    int itemCount;

    public CartItem(Book book) {
        this.book=book;
        this.itemCount=1;
    }

    public CartItem(Book book,int itemCount ) {
        this.book=book;
        this.itemCount=itemCount;
    }

    public Book getBook() {
        return book;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }
}
