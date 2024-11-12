package movietickets;

public class MovieTicketData {
    private final String movieName;
    private final int quantity;
    private final double price;

    public MovieTicketData(String movieName, int quantity, double price) {
        this.movieName = movieName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getMovieName() { return movieName; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }
} 