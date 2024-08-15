package vintedHW;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import vintedHW.validator.SizeValidator;

public class SizeValidatorTest {

    @Test
    public void testValidateSize() {
        String sizeString = "M";
        boolean isValid = SizeValidator.validateSize(sizeString);
        assertTrue(isValid);
    }
}