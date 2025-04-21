package BookMarketMine2_new;

public class Book {
    private String isbn;
    private String title;
    private int price;// int로 잡아두기.
    private String writter;
    private String description;
    private String category;
    private String date;

    public Book(String isbn, String title, int price, String writter, String description, String category, String date) {
        this.isbn = isbn;
        this.title = title;
        this.price = price;
        this.writter = writter;
        this.description = description;
        this.category = category;
        this.date = date;
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

    public String getWritter() {
        return writter;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getDate() {
        return date;
    }
}
