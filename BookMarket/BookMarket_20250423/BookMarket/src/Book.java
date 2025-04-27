public class Book extends Item{
    String author;
    String description;
    String category;
    String publishDate;

    public Book(String isbn, String title, int price, String author, String description, String category, String publishDate) {
        super(isbn, title, price);
        this.author = author;
        this.description = description;
        this.category = category;
        this.publishDate = publishDate;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }
}
