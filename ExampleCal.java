import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.util.Properties;

public class ExampleCal {
    public static void main(String[] args) {


        JFrame frame = new JFrame("Organizer");
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
        frame.setVisible(true);
    }

}
