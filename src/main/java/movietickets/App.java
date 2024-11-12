package movietickets;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class App extends JFrame {
    private JComboBox<String> movieCombo;
    private JTextField priceField;
    private JTextField ticketsField;
    private JTextArea reportArea;
    private MovieTickets movieTickets;

    public App() {
        movieTickets = new MovieTickets();
        setupUI();
    }

    private void setupUI() {
        setTitle("Movie Tickets");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Setup components
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        String[] movies = {"Napoleon", "Oppenheimer", "Damsel"};
        movieCombo = new JComboBox<>(movies);
        priceField = new JTextField();
        ticketsField = new JTextField();
        reportArea = new JTextArea();
        reportArea.setEditable(false);

        inputPanel.add(new JLabel("Movie:"));
        inputPanel.add(movieCombo);
        inputPanel.add(new JLabel("Price:"));
        inputPanel.add(priceField);
        inputPanel.add(new JLabel("Tickets:"));
        inputPanel.add(ticketsField);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(reportArea), BorderLayout.CENTER);

        // Setup menu
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu toolsMenu = new JMenu("Tools");

        JMenuItem exitItem = new JMenuItem("Exit");
        JMenuItem processItem = new JMenuItem("Process");
        JMenuItem clearItem = new JMenuItem("Clear");

        exitItem.addActionListener(e -> System.exit(0));
        processItem.addActionListener(e -> processTickets());
        clearItem.addActionListener(e -> clearFields());

        fileMenu.add(exitItem);
        toolsMenu.add(processItem);
        toolsMenu.add(clearItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);
    }

    private void processTickets() {
        try {
            String movie = (String) movieCombo.getSelectedItem();
            double price = Double.parseDouble(priceField.getText());
            int tickets = Integer.parseInt(ticketsField.getText());

            MovieTicketData data = new MovieTicketData(movie, tickets, price);

            if (!movieTickets.validateData(data)) {
                JOptionPane.showMessageDialog(this, "Please enter valid data!");
                return;
            }

            double total = movieTickets.calculateTotalTicketPrice(tickets, price);
            double vat = total - (tickets * price);

            String report = String.format("""
                Movie Ticket Sales Report
                ------------------------
                Movie: %s
                Number of Tickets: %d
                Price per Ticket: R%.2f
                VAT Amount: R%.2f
                Total Amount: R%.2f
                """, movie, tickets, price, vat, total);

            reportArea.setText(report);
            saveReport(report);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers!");
        }
    }

    private void saveReport(String report) {
        try (FileWriter writer = new FileWriter("report.txt")) {
            writer.write(report);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving report: " + e.getMessage());
        }
    }

    private void clearFields() {
        movieCombo.setSelectedIndex(0);
        priceField.setText("");
        ticketsField.setText("");
        reportArea.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new App().setVisible(true);
        });
    }
} 