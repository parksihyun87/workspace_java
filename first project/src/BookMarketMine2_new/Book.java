package BookMarketMine2_new;

public class Book extends Item{
// int로 잡아두기.
    private String writter;
    private String description;
    private String category;
    private String date;

    public Book(String isbn, String title, int price, String writter, String description, String category, String date) {
        super(isbn, title, price);
        this.writter = writter;
        this.description = description;
        this.category = category;
        this.date = date;
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
