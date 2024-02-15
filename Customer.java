import java.util.Scanner;

public class Customer {
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

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Edit username?");
        String customerUsername = reader.nextLine();
        System.out.println("Please edit password?");
        String customerPassword = reader.nextLine();
        System.out.println("What's your name?");
        String customerName = reader.nextLine();
        System.out.println("What's your phone number?");
        int customerPhoneNumber = Integer.valueOf(reader.nextLine());


//        Customer c0 = new Customer(customerUsername, customerPassword, customerName, customerPhoneNumber, new CreditCard(1,",122,"));
//        System.out.println(c0);
    }
}
