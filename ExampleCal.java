import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Properties;
import java.util.Scanner;

public class ExampleCal {

    protected static ZonedDateTime customerInputDateTime() throws IOException {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");

        while (true) {
            try {
                System.out.println("Please enter the date and time (dd/MM/yy HH:mm):");
                String customerInput = scanner.nextLine();
                ZonedDateTime zonedDateTime = ZonedDateTime.parse(customerInput, formatter);

                if (zonedDateTime.isBefore(ZonedDateTime.now())) {
                    System.out.println("Please enter a future date and time.");
                } else {
                    return zonedDateTime;
                }
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date and time format. Please try again.");
            }
        }
    }
    public static void main(String[] args) throws IOException {
        try {
            ZonedDateTime bookingDateTime = customerInputDateTime();
            System.out.println("Booking date and time: " + bookingDateTime);
        } catch (IOException e) {
            System.out.println("Error reading input.");
        }
        /*JFrame frame = new JFrame("Organizer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);

        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");

        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new JFormattedTextField().getFormatter());

        frame.add(datePicker);

        JButton okButton = new JButton("OK");
        okButton.addActionListener(e -> {
            System.out.println("Selected date: " + datePicker.getJFormattedTextField().getText());
        });

        frame.add(okButton, BorderLayout.SOUTH);
        frame.setVisible(true);*/
    }

}
