package com.example;

public class MovieTickets implements IMovieTickets {
    @Override
    public int TotalMovieSales(int[] movieTicketSales) {
        int total = 0;
        for (int sales : movieTicketSales) {
            total += sales;
        }
        return total;
    }

    @Override
    public String TopMovie(String[] movies, int[] totalSales) {
        if (totalSales[0] > totalSales[1]) {
            return movies[0];
        }
        return movies[1];
    }
} 