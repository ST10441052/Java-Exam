package com.example;

public class App {
    public static void main(String[] args) {
        // Initialize 2D array with movie data
        int[][] ticketSales = {
            {3000, 1500, 1700}, // Napoleon
            {3500, 1200, 1600}  // Oppenheimer
        };
        String[] movieNames = {"Napoleon", "Oppenheimer"};
        String[] months = {"January", "February", "March"};

        MovieTickets movieTickets = new MovieTickets();
        
        // Print header
        System.out.println("Movie Ticket Sales Report 2024");
        System.out.println("------------------------------");

        // Calculate and print monthly sales for each movie
        int[] totalSales = new int[2];
        for (int i = 0; i < movieNames.length; i++) {
            System.out.println("\n" + movieNames[i] + ":");
            totalSales[i] = movieTickets.TotalMovieSales(ticketSales[i]);
            
            for (int j = 0; j < months.length; j++) {
                System.out.printf("%s: %d tickets\n", months[j], ticketSales[i][j]);
            }
            System.out.println("Total sales: " + totalSales[i] + " tickets");
        }

        // Get and print top performing movie
        String topMovie = movieTickets.TopMovie(movieNames, totalSales);
        int topSales = Math.max(totalSales[0], totalSales[1]);

        System.out.println("\nTop Performing Movie:");
        System.out.printf("%s with %d tickets sold", topMovie, topSales);
    }
}
