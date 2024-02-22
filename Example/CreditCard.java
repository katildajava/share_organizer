package Example;

import java.time.ZonedDateTime;

public class CreditCard {
    private long creditCardNumber;
    private String creditCardName;
    private int creditCardCVV;
    private ZonedDateTime creditCardExpireDate;
    private String creditCardAddressLine;
    private int creditCardPostcode;

    public CreditCard(long creditCardNumber, String creditCardName, int creditCardCVV, ZonedDateTime creditCardExpireDate, String creditCardAddressLine, int creditCardPostcode) {
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

    private boolean isValidCardNumber(long creditCardNumber) {
        return String.valueOf(creditCardNumber).length() == 16;
    }

    private boolean isValidCVV(int creditCardCVV) {
        return String.valueOf(creditCardCVV).length() == 3;
    }

    private boolean isValidExpireDate(ZonedDateTime creditCardExpireDate) {
        ZonedDateTime currentDateTime = ZonedDateTime.now();
        return creditCardExpireDate.isAfter(currentDateTime);
    }
}