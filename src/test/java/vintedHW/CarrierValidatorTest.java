package vintedHW;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import vintedHW.validator.CarrierValidator;

public class CarrierValidatorTest {

    @Test
    public void testValidateCarrier() {
        String carrierString = "DHL";
        boolean isValid = CarrierValidator.validateCarrier(carrierString);
        assertTrue(isValid);
    }
}