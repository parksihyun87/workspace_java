package BookMarketMine2_new;

public class Item {
    private String isbn;
    private String title;
    private int price;

    public Item(String isbn, String title, int price) {
        this.isbn = isbn;
        this.title = title;
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }
}

