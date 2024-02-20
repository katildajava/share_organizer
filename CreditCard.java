import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class CreditCard {
    private String creditCardNumber;
    private String creditCardName;
    private int creditCardCVV;
    private ZonedDateTime creditCardExpireDate;
    private String creditCardAddressLine;
    private int creditCardPostcode;
    private static Scanner scanner = new Scanner(System.in);

    // Constructor
    public CreditCard(String creditCardNumber, String creditCardName, int creditCardCVV, ZonedDateTime creditCardExpireDate, String creditCardAddressLine, int creditCardPostcode) {
        this.creditCardNumber = creditCardNumber;
        this.creditCardName = creditCardName;
        this.creditCardCVV = creditCardCVV;
        this.creditCardExpireDate = creditCardExpireDate;
        this.creditCardAddressLine = creditCardAddressLine;
        this.creditCardPostcode = creditCardPostcode;
    }

    // Getters and Setters
    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
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

    public int getCreditCardPostcode() {
        return creditCardPostcode;
    }

    public void setCreditCardPostcode(int creditCardPostcode) {
        this.creditCardPostcode = creditCardPostcode;
    }
    public enum CardType{
        VISA, MASTERCARD, DISCOVER, AMERICANEXPRESS
    }
/*    public static int get16CreditCardNumbers(Scanner input){
        int number;
        do {
            System.out.println("Enter credit card number: ");
            number = input.nextInt();
        }while (!isValidCreditCardNumber(number));
        return number;
    }*/
    public boolean isValidCreditCardNumber(CardType cardType){
        String number = scanner.nextLine();
        int digitNum = number.length();  // Calculate the number of digits in the input number
        if (cardType == CardType.VISA || cardType == CardType.MASTERCARD || cardType == CardType.DISCOVER){
            return digitNum == 16;  // Check if the number of digits is equal to 16
        }else if (cardType == CardType.AMERICANEXPRESS){
            return  digitNum == 15;
        }else {
        System.out.println("Unknown type of card. Please contact manager."); //If unknown card type, display an error message and return false
        return false;
        }
    }

    public static boolean isValidExpiryDate(){
        String expiryDate = scanner.nextLine();
        if (expiryDate == null || expiryDate.isEmpty()){
            return false;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");
        try{
            YearMonth parsedExpiryDate = YearMonth.parse(expiryDate,formatter);
            YearMonth currentMonth = YearMonth.now();
            return parsedExpiryDate.isAfter(currentMonth);
        }catch (DateTimeParseException e){
            return false;
        }
    }
    public boolean isValidCVV(String cardType){
//        System.out.println("Enter the credit card CVV: "); // method with scanner, don't forget to delete obj from ()
        int creditCardCVV = scanner.nextInt();
        String cvvString = String.valueOf(creditCardCVV); //Convert the integer CVV value to a string
        if (cardType.equals("Visa") || cardType.equals("MasterCard") || cardType.equals("Discover")){ //Check the type of card and the corresponding CVV format
            return  cvvString.matches("^\\d{3}$"); //Check if the CVV string matches the three-digit format
        }else if (cardType.equals("AmericanExpress")){
            return cvvString.matches("^\\d{4}$"); //Check if the CVV string matches the four-digit format
        }else {
            System.out.println("Unknown type of card. Please contact manager."); //If unknown card type, display an error message and return false
            return false;
        }
    }
    private static String customerInputString (String askCustomer){
        System.out.println(askCustomer);
        return scanner.nextLine();
    }
    private static ZonedDateTime customerInputZonedDateTime(String askCustomer){
        System.out.println(askCustomer);
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
                "\nCard number: " + creditCardNumber +
                "\nName: " + creditCardName +
                "\nExpire Date: " + creditCardExpireDate.format(DateTimeFormatter.ofPattern("MM/yy")) +
                "\nAddress: " + creditCardAddressLine +
                "\nPostcode: " + creditCardPostcode;
    }


    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);

        String cardNumber = customerInputString("Enter your credit card number: ");
        String name = customerInputString("Enter full name from your credit card: ");
        ZonedDateTime expiryDate = customerInputZonedDateTime("Please enter the expiration date (MM/yy) of the credit card: ");
        String cardType = customerInputString("Enter your card type (Visa, MasterCard, Discover, or AmericanExpress): ");
        int cvv = Integer.parseInt(customerInputString("Enter CVV: "));
        String address = customerInputString("Enter your Address: ");
        int postcode = Integer.parseInt(customerInputString("Enter your postcode: "));

        CreditCard newCreditCard = new CreditCard(cardNumber, name, cvv, expiryDate, address, postcode);
        System.out.println("Is valid credit card number: " + newCreditCard.isValidCreditCardNumber(CardType.valueOf(cardType)) +
                "\nIs valid expiry date: " + isValidExpiryDate() +
                "\nIs valid CVV: " + newCreditCard.isValidCVV(cardType));
        System.out.println(newCreditCard.toString());

    }

}
