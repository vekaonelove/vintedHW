package vintedHW;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vintedHW.entity.*;
import vintedHW.service.impl.DiscountCalculationServiceImpl;
import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class DiscountCalculationServiceTest {

    private DiscountCalculationServiceImpl discountCalculationService;


    @BeforeEach
    public void setup() {
        discountCalculationService = new DiscountCalculationServiceImpl();
    }

    @Test
    public void testCalculateDiscount() {
        Purchase purchase = new Purchase(new Date(), Size.S, Carrier.MR);
        PurchaseDelivery result = discountCalculationService.calculateDiscount(purchase);

        assertNotNull(result);
        assertEquals(new BigDecimal("0.50"), result.getDiscount());
    }
}