package com.example;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MovieTicketsTest {
    private MovieTickets movieTickets;
    private String[] movieNames;
    private int[][] ticketSales;

    @BeforeEach
    public void setUp() {
        movieTickets = new MovieTickets();
        movieNames = new String[]{"Napoleon", "Oppenheimer"};
        ticketSales = new int[][]{
            {3000, 1500, 1700}, // Napoleon
            {3500, 1200, 1600}  // Oppenheimer
        };
    }
        //Return total sales unit test
    @Test
    void CalculateTotalSales_ReturnExpectedTotalSales() {
        // Test Napoleon's total sales (3000 + 1500 + 1700 = 6200)
        assertEquals(6200, movieTickets.TotalMovieSales(ticketSales[0]), 
            "Should calculate correct total sales for Napoleon");

        // Test Oppenheimer's total sales (3500 + 1200 + 1600 = 6300)
        assertEquals(6300, movieTickets.TotalMovieSales(ticketSales[1]), 
            "Should calculate correct total sales for Oppenheimer");

        // Test empty array case
        assertEquals(0, movieTickets.TotalMovieSales(new int[]{}), 
            "Should return 0 for empty sales array");
    }


    //Topp movie sales unit test
    @Test
    void TopMovieSales_ReturnsTopMovie() {
        // Calculate total sales for each movie
        int[] totalSales = {
            movieTickets.TotalMovieSales(ticketSales[0]),  // Napoleon: 6200
            movieTickets.TotalMovieSales(ticketSales[1])   // Oppenheimer: 6300
        };

        // Test when Oppenheimer has higher sales
        assertEquals("Oppenheimer", movieTickets.TopMovie(movieNames, totalSales), 
            "Should return Oppenheimer as top movie when it has higher sales");

        // Test when sales are equal (should return second movie)
        int[] equalSales = {6300, 6300};
        assertEquals("Oppenheimer", movieTickets.TopMovie(movieNames, equalSales), 
            "Should return second movie when sales are equal");
    }
} 