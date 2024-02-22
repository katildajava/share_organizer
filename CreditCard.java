import java.io.Serializable;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class CreditCard {
    private Serializable creditCardNumber;
    private String creditCardName;
    private Serializable creditCardCVV;
    private ZonedDateTime creditCardExpireDate;
    private String creditCardAddressLine;
    private int creditCardPostcode;
    private static Scanner scanner = new Scanner(System.in);

    // Constructor
    public CreditCard(Serializable creditCardNumber, String creditCardName, Serializable creditCardCVV, ZonedDateTime creditCardExpireDate, String creditCardAddressLine, int creditCardPostcode) {
        this.creditCardNumber = creditCardNumber;
        this.creditCardName = creditCardName;
        this.creditCardCVV = creditCardCVV;
        this.creditCardExpireDate = creditCardExpireDate;
        this.creditCardAddressLine = creditCardAddressLine;
        this.creditCardPostcode = creditCardPostcode;
    }

    // Getters and Setters
    public Serializable getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(Serializable creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCreditCardName() {
        return creditCardName;
    }

    public void setCreditCardName(String creditCardName) {
        this.creditCardName = creditCardName;
    }

    public Serializable getCreditCardCVV() {
        return creditCardCVV;
    }

    public void setCreditCardCVV(Serializable creditCardCVV) {
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

    public int getCreditCardPostcode() {
        return creditCardPostcode;
    }

    public void setCreditCardPostcode(int creditCardPostcode) {
        this.creditCardPostcode = creditCardPostcode;
    }

    private static String customerInputCardNumber() {
        System.out.println("Enter your credit card number: ");
        String number = scanner.nextLine().trim(); // remove leading/trailing spaces

        try {
            long cardNumber = Long.parseLong(number); // convert input to a long
            int digitNum = String.valueOf(cardNumber).length(); // calculate the number of digits

            if (digitNum == 16 || digitNum == 15) {
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
    private static Serializable customerInputCVVCode(){
        System.out.println("Enter CVV code: ");
        String numberCVV = scanner.nextLine().trim(); //remove spaces
        try{
            byte cvvNumber = Byte.parseByte(numberCVV); // convert input to a byte
            int digitNum = String.valueOf(cvvNumber).length(); //calculate the number of digits

            if (digitNum == 3 || digitNum == 4){                             /*"does not work with 4 symbols"*/
                return String.valueOf(cvvNumber); //valid number length
            } else {
                System.out.println("Code is not correct, please check your card and try again!");
                return customerInputCVVCode(); // recurse to get a valid number

            }
        }catch (NumberFormatException e){
            System.out.println("Invalid input. Please enter a valid numeric number.");
            return customerInputCVVCode(); // recurse to get a valid number
        }
    }
    private static String customerInputString (String askCustomer){
        System.out.println(askCustomer);
        return scanner.nextLine();
    }
    private static ZonedDateTime customerInputZonedDateTime(){
        System.out.println("Please enter the expiration date (MM/yy) of the credit card: ");
        ZonedDateTime zonedDateTime;
        while (true) {
            try {
                String customerInput = scanner.nextLine().replaceAll("[^1-9/]", "");
                zonedDateTime = ZonedDateTime.of(2000+Integer.parseInt(customerInput.split("/")[1]), Integer.parseInt(customerInput.split("/")[0]), 1, 0, 0, 0, 0, ZoneId.systemDefault());
                if (zonedDateTime.compareTo(ZonedDateTime.now()) < 0) {
                    System.out.println("Please enter date not from the past.");
                }
                else {
                    break;
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


    public static void main(String[] args) {

        Serializable cardNumber = customerInputCardNumber();
        String name = customerInputString("Enter full name from your credit card: ");
        ZonedDateTime expiryDate = customerInputZonedDateTime();
        Serializable cvv = customerInputCVVCode();
        String address = customerInputString("Enter your Address: ");
        int postcode = Integer.parseInt(customerInputString("Enter your postcode: "));

        CreditCard otherCreditCard = new CreditCard(cardNumber, name, cvv, expiryDate, address, postcode);
        otherCreditCard.toString();


    }

}
