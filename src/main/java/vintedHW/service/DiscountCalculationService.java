package vintedHW.service;

import vintedHW.entity.Purchase;
import vintedHW.entity.PurchaseDelivery;

public interface DiscountCalculationService {
    PurchaseDelivery calculateDiscount(Purchase purchase);
}