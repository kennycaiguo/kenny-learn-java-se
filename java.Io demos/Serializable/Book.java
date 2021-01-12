import java.io.Serializable;

public class Book implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String title;
    private String author;
    private double price;

    public Book() {
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Book(String title, String author, double price) {
        this.setTitle(title);
        this.setAuthor(author);
        this.setPrice(price);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Book[title:" + this.title + ",author:" + this.author + ",price:" + this.price + "]";
    }
}
