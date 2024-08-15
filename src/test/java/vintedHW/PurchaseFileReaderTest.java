package vintedHW;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import vintedHW.entity.Purchase;
import vintedHW.reader.PurchaseFileReader;

import java.util.ArrayList;

public class PurchaseFileReaderTest {

    @Test
    public void testParsePurchasesNotNull() {
        String filePath = "/input.txt";
        ArrayList<Purchase> parsedPurchases = PurchaseFileReader.parsePurchases(filePath);
        assertNotNull(parsedPurchases);
    }

    @Test
    public void testParsePurchasesSize() {
        String filePath = "/input.txt";
        ArrayList<Purchase> parsedPurchases = PurchaseFileReader.parsePurchases(filePath);
        assertEquals(20, parsedPurchases.size());
    }

    @Test
    public void testParsePurchasesFirstElement() {
        String filePath = "/input.txt";
        ArrayList<Purchase> parsedPurchases = PurchaseFileReader.parsePurchases(filePath);
        assertEquals("2015-02-01 S MR ", parsedPurchases.get(0).toString());
    }
}