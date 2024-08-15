package vintedHW.service.impl;

import vintedHW.entity.*;
import vintedHW.main.PricesConfig;
import vintedHW.service.CalculationState;
import vintedHW.service.DiscountCalculationService;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DiscountCalculationServiceImpl implements DiscountCalculationService {

    private final BigDecimal MAX_MONTH_DISCOUNT = new BigDecimal(10); //our constant, max sum that the Vinted employee can spend on delivery discounts

    private CalculationState state;
    private PricesConfig prices;

    public DiscountCalculationServiceImpl() {
        state = new CalculationState();
        prices = new PricesConfig();
    }

    @Override
    public PurchaseDelivery calculateDiscount(Purchase purchase) {

        BigDecimal discount = BigDecimal.ZERO;
        BigDecimal resultCost = BigDecimal.ZERO;


        ZonedDateTime zdt = purchase.getDate().toInstant().atZone(ZoneId.systemDefault());
        YearMonth currentYearMonth  = YearMonth.from(zdt);

        BigDecimal leftDiscount = MAX_MONTH_DISCOUNT.subtract(state.getCurrentMonthDiscount(currentYearMonth));
        if (leftDiscount.compareTo(BigDecimal.ZERO) == 0) {
            return new PurchaseDelivery(purchase, prices.getPrice(purchase.getSize(), purchase.getCarrier()), BigDecimal.ZERO);
        }

        if (purchase.getSize().equals(Size.S)) {
            BigDecimal cost = prices.getPrice(purchase.getSize(), purchase.getCarrier());
            BigDecimal minCost = prices.getMinCost(purchase.getSize());
            discount = cost.subtract(minCost);
            if (discount.compareTo(leftDiscount) > 0) {
                discount = leftDiscount;
            }
            resultCost = cost.subtract(discount);

        } else if (purchase.getSize().equals(Size.L) && purchase.getCarrier().equals(Carrier.LP)) {
            int countLPDeliveriesInCurrentMonth = state.getLPDeliveriesCount();
            if (countLPDeliveriesInCurrentMonth % 3 == 2 && !state.isLPFree(currentYearMonth)) {
                resultCost = prices.getPrice(purchase.getSize(), purchase.getCarrier());
                discount = resultCost;
                if (discount.compareTo(leftDiscount) > 0) {
                    discount = leftDiscount;
                }
                resultCost = resultCost.subtract(discount);
                state.setLPFreeDelivered(currentYearMonth);
            } else {
                resultCost = prices.getPrice(purchase.getSize(), purchase.getCarrier());
                discount = BigDecimal.ZERO;
            }
            state.increaseLPDeliveriesCount();
        } else {
            resultCost = prices.getPrice(purchase.getSize(), purchase.getCarrier());
            discount = BigDecimal.ZERO;
        }
        state.addDiscount(currentYearMonth, discount);
         return new PurchaseDelivery(purchase, resultCost, discount);

    }
}

