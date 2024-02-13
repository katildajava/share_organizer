import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.io.*;
class MyActionListener implements ActionListener{
    JLabel nameLabel, usernameLabel, passwordLabel, phoneNumberLabel, messageLabel;
    JTextField nameField, usernameField, phoneNumberField;
    JPasswordField passwordField;
    JButton registerButton, resetButton;
    String name, phoneNumber, username, password;
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            name = nameField.getText();
            phoneNumber = phoneNumberField.getText();
            username = usernameField.getText();
            password = passwordField.getText();

            if (name.isEmpty() || phoneNumber.isEmpty() || username.isEmpty() || password.isEmpty()) {
                // If any field is empty, show an error message
                messageLabel.setText("Please fill all the fields.");
            } else {
                // If all fields are filled, create a new user object
                Customer newCustomer = new Customer(name, phoneNumber, username, password);
                // Write the user object to a file
                File customerStorage = new File("customers.txt");
                try {
                    FileWriter writer = new FileWriter(customerStorage);
                    writer.write("");

                    // Create a file output stream and an object output stream

/*                    FileOutputStream fos = new FileOutputStream("customers.txt", true);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);*/

                    // Write the user object to the file
//                    oos.writeObject(newCustomer);

                    // Close the streams
/*                    oos.close();
                    fos.close();*/

                    // Show a success message
                    messageLabel.setText("User registered successfully.");

                } catch (IOException ex) {
                    messageLabel.setText("Error: " + ex.getMessage());
                }
            }

        }
        if (e.getSource() == resetButton) {
            // Clear the text fields and the message label
            nameField.setText("");
            phoneNumberField.setText("");
            usernameField.setText("");
            passwordField.setText("");
            messageLabel.setText("");
        }
    }
}
public class Registration extends JFrame{
    JLabel nameLabel, usernameLabel, passwordLabel, phoneNumberLabel, messageLabel;
    JTextField nameField, usernameField, phoneNumberField;
    JPasswordField passwordField;
    JButton registerButton, resetButton;
    String name, username, password;

    public Registration(){
// Set the title, size, layout, and location of the frame
        setTitle("User Registration Form");
        setSize(500,300);
        setLayout(new GridLayout(6,2));
        setLocationRelativeTo(null);

// Initialize the components
        nameLabel = new JLabel("Name: ");
        phoneNumberLabel = new JLabel("Phone number: ");
        usernameLabel = new JLabel("Username: ");
        passwordLabel = new JLabel("Password: ");
        messageLabel = new JLabel();

        nameField = new JTextField();
        phoneNumberField = new JTextField();
        usernameField = new JTextField();
        passwordField = new JPasswordField();

        registerButton = new JButton("Register");
        resetButton = new JButton("Reset");

//add the components to the frame
        add(nameLabel);
        add(nameField);
        add(phoneNumberLabel);
        add(phoneNumberField);
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(registerButton);
        add(resetButton);
        add(messageLabel);

        ActionListener actionListener = new MyActionListener();
//add action listeners to the buttons
        registerButton.addActionListener(actionListener);
        registerButton.addActionListener(actionListener);

        setVisible(true);//make frame visible

/*

//define the method that handles the button events
        public void actionPerformed() {
// If the register button is clicked
            if (e.getSource() == registerButton) {
// Get the user input from the text fields
                name = nameField.getText();
                username = usernameField.getText();
                password = passwordField.getText();

// Validate the user input
                if (name.isEmpty() || username.isEmpty() || password.isEmpty()) {
                    // If any field is empty, show an error message
                    messageLabel.setText("Please fill all the fields.");
                } else {
                    // If all fields are filled, create a new user object
                    Customer newCustomer = new Customer(name, username, password);
                    // Write the user object to a file
                    try {
                        // Create a file output stream and an object output stream
                        FileOutputStream fos = new FileOutputStream("customers.txt", true);
                        ObjectOutputStream oos = new ObjectOutputStream(fos);

                        // Write the user object to the file
                        oos.writeObject(newCustomer);

                        // Close the streams
                        oos.close();
                        fos.close();

                        // Show a success message
                        messageLabel.setText("User registered successfully.");

                    } catch (IOException ex) {
                        messageLabel.setText("Error: " + ex.getMessage());
                    }
                }
            }

            // If the reset button is clicked
            if (e.getSource() == resetButton) {
                // Clear the text fields and the message label
                nameField.setText("");
                usernameField.setText("");
                passwordField.setText("");
                messageLabel.setText("");
            }
        }*/

    }


}

