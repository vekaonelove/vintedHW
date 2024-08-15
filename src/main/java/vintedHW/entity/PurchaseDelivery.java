package vintedHW.entity;

import java.math.BigDecimal;

public class PurchaseDelivery {

    private Purchase purchase;
    private BigDecimal deliveryCost;
    private BigDecimal discount;

    public PurchaseDelivery(Purchase purchase, BigDecimal deliveryCost, BigDecimal discount) {
        this.purchase = purchase;
        this.deliveryCost = deliveryCost;
        this.discount = discount;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public BigDecimal getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(BigDecimal deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        String discountString = discount.compareTo(BigDecimal.ZERO) == 0 ? "-" : discount.toString();
        return purchase + " " + deliveryCost + " " + discountString;
    }
}
