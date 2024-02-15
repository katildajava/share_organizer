import java.time.LocalDate;

public class CreditCard {
    private int creditCardNumber;
    private String creditCardName;
    private int creditCardCVV;
    private LocalDate creditCardExpireDate;
    private String creditCardAddressLine;
    private int creditCardPostcode;

    // Constructor
    public CreditCard(int creditCardNumber, String creditCardName, int creditCardCVV, LocalDate creditCardExpireDate, String creditCardAddressLine, int creditCardPostcode) {
        this.creditCardNumber = creditCardNumber;
        this.creditCardName = creditCardName;
        this.creditCardCVV = creditCardCVV;
        this.creditCardExpireDate = creditCardExpireDate;
        this.creditCardAddressLine = creditCardAddressLine;
        this.creditCardPostcode = creditCardPostcode;
    }

    // Getters and Setters
    public int getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(int creditCardNumber) {
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

    public LocalDate getCreditCardExpireDate() {
        return creditCardExpireDate;
    }

    public void setCreditCardExpireDate(LocalDate creditCardExpireDate) {
        this.creditCardExpireDate = creditCardExpireDate;
    }
    public void setCreditCardExpireDate(int year, int month) {
        creditCardExpireDate = creditCardExpireDate.withYear(year).withMonth(month);
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

    public boolean isExpired() {
        LocalDate currentDate = LocalDate.now();
        return creditCardExpireDate.isBefore(currentDate);
    }
    public String toString(){
        return "Card number: " + this.creditCardNumber + " Name: " + this.creditCardName + " Address: " + this.creditCardAddressLine + " Postcode: " + this.creditCardPostcode + " Expire Date: " + this.creditCardExpireDate + " CVV: " + this.creditCardCVV;
    }
    public static void main(String[] args) {
        CreditCard myCreditCard = new CreditCard(123456, "lalal", 123, LocalDate.now(), "Address 12 - 8", 12345);

        System.out.println(myCreditCard);
    }

}
