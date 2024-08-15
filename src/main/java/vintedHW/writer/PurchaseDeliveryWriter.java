package vintedHW.writer;

import vintedHW.entity.PurchaseDelivery;
import java.util.List;

public class PurchaseDeliveryWriter {
    public static void saveIgnoredLine(List<String> result, String line) {
        String resultLine = line + " IGNORED";
        result.add(resultLine);
    }

    public static void saveCorrectLine(List<String> result, PurchaseDelivery processedPurchase) {
        result.add(processedPurchase.toString());
    }
}
