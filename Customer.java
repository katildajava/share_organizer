import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.sql.SQLOutput;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Customer {
    private static final String CUSTOMERS_FILE = "Customers.json";
    private static int nextCustomerID = 1;
    private int customerID;
    private String customerUsername;
    private String customerPassword;
    private String customerName;
    private int customerPhoneNumber;
    private CreditCard customerCreditCard;

    public Customer(String customerUsername, String customerPassword, String customerName,
                    int customerPhoneNumber, CreditCard customerCreditCard) {
        this.customerID = nextCustomerID++;
        this.customerUsername = customerUsername;
        this.customerPassword = customerPassword;
        this.customerName = customerName;
        this.customerPhoneNumber = customerPhoneNumber;
        this.customerCreditCard = customerCreditCard;
    }
    // Getters and setters for the properties

    public int getCustomerID() {
        return customerID;
    }
    public String getCustomerUsername() {
        return customerUsername;
    }
    public void setCustomerUsername(String customerUsername) {
        this.customerUsername = customerUsername;
    }
    public String getCustomerPassword() {
        return customerPassword;
    }
    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public int getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }
    public void setCustomerPhoneNumber(int customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }
    public CreditCard getCustomerCreditCard() {
        return customerCreditCard;
    }
    public void setCustomerCreditCard(CreditCard customerCreditCard) {
        this.customerCreditCard = customerCreditCard;
    }

    private static ArrayList<JsonObject> readCustomersFromFile() throws IOException{
        ArrayList<JsonObject> customersArray = new ArrayList<>(); // create ArrayList to store customers data
        File file = new File(CUSTOMERS_FILE); // create file object for the customers file
        if (file.exists()){ // check if the file exists
            try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
                JsonArray jsonArray = JsonParser.parseReader(bufferedReader).getAsJsonArray(); // parse file content to a JSON array
                for (var jasonElement : jsonArray){ // iterate through JSON array
                    customersArray.add(jasonElement.getAsJsonObject()); // add each JSON object to the ArrayList
                }
            }
        }
        return customersArray; // return the ArrayList of customer data
    }

    private static void writeCustomerToFile(ArrayList<JsonObject> customersArray) throws IOException{
        try(FileWriter writer = new FileWriter(CUSTOMERS_FILE)){ // Create a FileWriter for the customers file
            writer.write(new Gson().toJson(customersArray)); // Write the ArrayList of customer data to the file as JSON
        }
    }

    public static void login(Scanner scanner) throws IOException {
        try {
            System.out.println("Enter username:");
            String username = scanner.nextLine();
            System.out.println("Enter password");
            String password = scanner.nextLine();

            ArrayList<JsonObject> customersArray = readCustomersFromFile(); // read existing customers from the file if it exists

            boolean userExists = false;
            for (JsonObject customer : customersArray) {
                if (customer.has("username") && customer.get("username").getAsString().equals(username)) {// check if the username exists
                    userExists = true;
                    if (customer.has("password") && customer.get("password").getAsString().equals(password)) {// check password matching
                        System.out.println("Logged in successfully!");
                    } else {
                        System.out.println("Incorrect password.");
                    }
                    break;
                }
            }
            if (!userExists) {
                System.out.println("User not found.");
                chooseAnOption();
                System.out.println("1. Log in \n2. Create an Account");
                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option){
                    case 1:
                        login(scanner);
                        break;
                    case 2:
                        createCustomer(scanner);
                        break;
                    default:
                        System.out.println("Invalid option");
                        break;
                }
                scanner.close();

            }
        } catch (IOException e) {
            System.out.println("Error reading customers file.");
        }
    }


    public static void createCustomer(Scanner scanner) throws IOException {
        System.out.println("Enter username:");
        String username = scanner.nextLine();

        System.out.println("Enter password:");
        String password = scanner.nextLine();

        System.out.println("Enter your name:");
        String name = scanner.nextLine();

        System.out.println("Enter phone number:");
        int phoneNumber = scanner.nextInt();

        long cardNumber = Long.parseLong(CreditCard.customerInputCardNumber());
        String fullName = CreditCard.customerInputString("Enter full name from your credit card: ");
        ZonedDateTime expiryDate = CreditCard.customerInputZonedDateTime();
        int cvv = CreditCard.customerInputCVVCode();
        String address = CreditCard.customerInputString("Enter your Address: ");
        int postcode = Integer.parseInt(CreditCard.customerInputString("Enter your postcode: "));

        CreditCard creditCard = new CreditCard(cardNumber, fullName, cvv, expiryDate, address, postcode);
        Customer customer = new Customer(username, password, name, phoneNumber, creditCard);// Create a Customer object

        ArrayList<JsonObject> customersArray = readCustomersFromFile();//read existing customers from the file if it exists

        JsonObject newCustomer = new JsonObject();// create Json object for the new customer
        newCustomer.addProperty("username", username); // add username as a property with the specified value
        newCustomer.addProperty("password", password); // add password as a property with the specified value
        newCustomer.addProperty("phoneNumber", phoneNumber);
        newCustomer.addProperty("creditCard", String.valueOf(creditCard));

        customersArray.add(newCustomer); //add new customer to the array

        writeCustomerToFile(customersArray);
        System.out.println("New customer " + customer.getCustomerName() + ". We glad to see in our app.");


    }
    private static void chooseAnOption(){
        System.out.println("Choose an option:");
    }

    public static void customerMenu(Scanner scanner) throws IOException {
        chooseAnOption();
        System.out.println("1. Create a new appointment");
//        System.out.println("2. Make changes to your reservation");
        System.out.println("3. Delete an appointment \n 4. Exit");
        int option = scanner.nextInt();
        scanner.nextLine(); // consume the newline character
        switch (option) {
            case 1:
                Appointment.createAppointment(scanner);
                break;
//            case 2:
//                Appointment.makeChanges(scanner);
//                break;
//            case 3:
//                Appointment.deleteAppointment(scanner);
//                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
    }



}
