import java.io.Serializable;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class CreditCard {
    private long creditCardNumber;
    private String creditCardName;
    private int creditCardCVV;
    private ZonedDateTime creditCardExpireDate;
    private String creditCardAddressLine;
    private String creditCardPostcode;
    private static Scanner scanner = new Scanner(System.in);

    // Constructor
    public CreditCard(long creditCardNumber, String creditCardName, int creditCardCVV, ZonedDateTime creditCardExpireDate, String creditCardAddressLine, String creditCardPostcode) {
        if (isValidCardNumber(creditCardNumber) && isValidCVV(creditCardCVV) && isValidExpireDate(creditCardExpireDate)) {
            this.creditCardNumber = creditCardNumber;
            this.creditCardName = creditCardName;
            this.creditCardCVV = creditCardCVV;
            this.creditCardExpireDate = creditCardExpireDate;
            this.creditCardAddressLine = creditCardAddressLine;
            this.creditCardPostcode = creditCardPostcode;
        } else {
            throw new IllegalArgumentException("Invalid credit card details");
        }
    }

    // Getters and Setters
    public long getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(long creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCreditCardName() {
        return creditCardName;
    }

    public void setCreditCardName(String creditCardName) {
        this.creditCardName = creditCardName;
    }

    public int getCreditCardCVV() {
        return creditCardCVV;
    }

    public void setCreditCardCVV(int creditCardCVV) {
        this.creditCardCVV = creditCardCVV;
    }

    public ZonedDateTime getCreditCardExpireDate() {
        return creditCardExpireDate;
    }

    public void setCreditCardExpireDate(ZonedDateTime creditCardExpireDate) {
        this.creditCardExpireDate = creditCardExpireDate;
    }
    public void setCreditCardExpireDate(int year, int month) {
        if(year < 100){
            this.creditCardExpireDate = ZonedDateTime.of(2000+year, month, 1, 0, 0, 0, 0, ZoneId.systemDefault());
        }else{
            this.creditCardExpireDate = ZonedDateTime.of(year, month, 1, 0, 0, 0, 0, ZoneId.systemDefault());
        }

    }

    public String getCreditCardAddressLine() {
        return creditCardAddressLine;
    }

    public void setCreditCardAddressLine(String creditCardAddressLine) {
        this.creditCardAddressLine = creditCardAddressLine;
    }

    public String getCreditCardPostcode() {
        return creditCardPostcode;
    }

    public void setCreditCardPostcode(String creditCardPostcode) {
        this.creditCardPostcode = creditCardPostcode;
    }
    protected static boolean isValidCardNumber(long creditCardNumber) {
        return (String.valueOf(creditCardNumber).length() == 15 || String.valueOf(creditCardNumber).length() == 16);
    }

    protected static boolean isValidCVV(int creditCardCVV) {
        return (String.valueOf(creditCardCVV).length() == 3 || String.valueOf(creditCardCVV).length() == 4);
    }

    protected boolean isValidExpireDate(ZonedDateTime creditCardExpireDate) {
        ZonedDateTime currentDateTime = ZonedDateTime.now();
        return creditCardExpireDate.isAfter(currentDateTime);
    }
    protected static String customerInputCardNumber() {
        System.out.println("Enter your credit card number: ");
        String number = scanner.nextLine().trim(); // remove leading/trailing spaces

        try {
            long cardNumber = Long.parseLong(number); // convert input to a long
            if (isValidCardNumber(cardNumber)) {
                return String.valueOf(cardNumber); // valid card number length
            } else {
                System.out.println("Unknown type of card. Please check your card number or contact the manager.");
                return customerInputCardNumber(); // recurse to get a valid card number
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid numeric card number.");
            return customerInputCardNumber(); // recurse to get a valid card number
        }
    }
                        /* Warning---------------Attention------------------Warning */
    protected static int customerInputCVVCode(){
        System.out.println("Enter CVV code: ");
        int numberCVV = Integer.parseInt(scanner.nextLine()); //remove spaces
        try{
            if (isValidCVV(numberCVV)){                             /*"does not work with 4 symbols"*/
                return numberCVV; //valid number length
            } else {
                System.out.println("Code is not correct, please check your card and try again!");
                return customerInputCVVCode(); // recurse to get a valid number

            }
        }catch (NumberFormatException e){
            System.out.println("Invalid input. Please enter a valid numeric number.");
            return customerInputCVVCode(); // recurse to get a valid number
        }
    }
    protected static String customerInputString (String askCustomer){
        System.out.println(askCustomer);
        return scanner.nextLine();
    }
    protected static ZonedDateTime customerInputZonedDateTime(){
        System.out.println("Please enter the expiration date (MM/yy) of the credit card: ");
        ZonedDateTime zonedDateTime;
        while (true) {
            try {
                String customerInput = scanner.nextLine().replaceAll("[^0-9/]", ""); // remove non-numeric and non-slash characters
                String[] inputParts = customerInput.split("/"); // split the input by "/"
                if (inputParts.length != 2) {
                    System.out.println("Invalid date format. Please enter the expiration date in MM/yy format.");
                    continue; // restart the loop to prompt for input again
                }
                int month = Integer.parseInt(inputParts[0]), year = 2000 + Integer.parseInt(inputParts[1]);
                zonedDateTime = ZonedDateTime.of(year, month, 1, 0, 0, 0, 0, ZoneId.systemDefault());
                if (zonedDateTime.compareTo(ZonedDateTime.now()) < 0) {
                    System.out.println("Please enter a date not from the past.");
                } else {
                    break; // exit the loop if the input is valid
                }
            } catch (DateTimeParseException e) {
                System.out.println("This is not a correct date, please try again");
            }
        }
        return zonedDateTime;
    }
    public String toString(){
        return "Credit Card Details:" +
                "\nCard number: " + getCreditCardNumber() +
                "\nName: " + getCreditCardName() +
                "\nExpire Date: " + getCreditCardExpireDate().format(DateTimeFormatter.ofPattern("MM/yy")) +
                "\nAddress: " + getCreditCardAddressLine() +
                "\nPostcode: " + getCreditCardPostcode();
    }

}
