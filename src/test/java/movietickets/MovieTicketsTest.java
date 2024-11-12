package movietickets;

import org.junit.Test;
import static org.junit.Assert.*;

public class MovieTicketsTest {
    private MovieTickets movieTickets = new MovieTickets();


    //these are the tests to calculate the total ticket price
    @Test
    public void calculateTotalTicketPrice_CalculatedSuccessfully() {
        double result = movieTickets.calculateTotalTicketPrice(2, 100);
        assertEquals(228.0, result, 0.01); // 2 tickets * 100 + 14% VAT
    }
// these sre the tests to validate the data 
    @Test
    public void validateData_WithValidData_ReturnsTrue() {
        MovieTicketData data = new MovieTicketData("Napoleon", 2, 100);
        assertTrue(movieTickets.validateData(data));
    }

    @Test
    public void validateData_WithInvalidData_ReturnsFalse() {
        MovieTicketData data = new MovieTicketData("", 0, 0);
        assertFalse(movieTickets.validateData(data));
    }
} 