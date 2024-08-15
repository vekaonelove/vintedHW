package vintedHW;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import vintedHW.validator.DateValidator;

public class DateValidatorTest {

    @Test
    public void testValidateDate() {
        String dateString = "2022-12-01";
        boolean isValid = DateValidator.validateDate(dateString);
        assertTrue(isValid);
    }
}