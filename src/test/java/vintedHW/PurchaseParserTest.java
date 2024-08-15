package vintedHW;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import vintedHW.entity.ParsedPurchase;
import vintedHW.entity.Purchase;
import vintedHW.parser.PurchaseParser;

public class PurchaseParserTest {

    @Test
    public void testParseLineInvalidDate() {
        String purchaseString = "2022-13-01 M DHL";
        ParsedPurchase parsedPurchase = PurchaseParser.parseLine(purchaseString);
        assertNotNull(parsedPurchase);
        assertEquals(purchaseString, parsedPurchase.getErrorMessage());
    }
}