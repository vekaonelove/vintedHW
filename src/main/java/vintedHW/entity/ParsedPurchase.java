package vintedHW.entity;

import java.util.Date;

public class ParsedPurchase {

    private Purchase purchase;

    private String errorMessage;

    public ParsedPurchase(Date date, Size size, Carrier carrier) {
        this.purchase = new Purchase(date, size, carrier);
        this.errorMessage = null;
    }

    public ParsedPurchase(String errorMessage) {
        this.errorMessage = errorMessage;
        this.purchase = null;
    }

    public Purchase getPurchase() {
        return this.purchase;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }
}
