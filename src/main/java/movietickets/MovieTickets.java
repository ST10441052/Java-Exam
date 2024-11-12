package movietickets;

public class MovieTickets {
    public boolean validateData(MovieTicketData data) {
        return data.getTickets() > 0 && data.getPrice() > 0;
    }

    public double calculateTotalTicketPrice(int tickets, double price) {
        double vatRate = 0.15; // Example VAT rate
        return tickets * price * (1 + vatRate);
    }
} 