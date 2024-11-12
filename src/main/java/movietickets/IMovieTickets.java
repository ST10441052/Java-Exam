package movietickets;

public interface IMovieTickets {
    double calculateTotalTicketPrice(int numberOfTickets, double ticketPrice);
    boolean validateData(MovieTicketData movieTicketData);
} 