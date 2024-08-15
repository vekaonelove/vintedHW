package vintedHW.service;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.HashMap;
import java.util.Map;

public class CalculationState {

    Map<YearMonth, MonthState> currentMonth = new HashMap<>();
    int countLPDeliveries;


    public BigDecimal getCurrentMonthDiscount(YearMonth currentYearMonth) {
        return currentMonth.get(currentYearMonth) == null ? BigDecimal.ZERO : currentMonth.get(currentYearMonth).totalDiscountForCurrentMonth;
    }

    public int getLPDeliveriesCount() {
        return countLPDeliveries;
    }

    public void increaseLPDeliveriesCount() {
        countLPDeliveries++;
    }

    public void addDiscount(YearMonth currentYearMonth, BigDecimal discount) {
        if (currentMonth.get(currentYearMonth) == null) {
            currentMonth.put(currentYearMonth, new MonthState(discount, false));
        } else {
            currentMonth.get(currentYearMonth).totalDiscountForCurrentMonth = currentMonth.get(currentYearMonth).totalDiscountForCurrentMonth.add(discount);
        }
    }

    public boolean isLPFree(YearMonth currentYearMonth) {
        return currentMonth.get(currentYearMonth) == null ? false : currentMonth.get(currentYearMonth).isFreeLP;
    }

    public void setLPFreeDelivered(YearMonth currentYearMonth) {
        if (currentMonth.get(currentYearMonth) == null) {
            currentMonth.put(currentYearMonth, new MonthState(BigDecimal.ZERO, false));
        } else {
            currentMonth.get(currentYearMonth).isFreeLP = true;
        }
    }


    public static class MonthState {
        BigDecimal totalDiscountForCurrentMonth;
        boolean isFreeLP;

        public MonthState(BigDecimal discount, boolean isFreeLP) {
            this.totalDiscountForCurrentMonth = discount;
            this.isFreeLP = isFreeLP;
        }
    }
}
