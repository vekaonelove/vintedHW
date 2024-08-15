package vintedHW.parser;

import vintedHW.entity.Carrier;
import vintedHW.entity.ParsedPurchase;
import vintedHW.entity.Size;
import vintedHW.validator.CarrierValidator;
import vintedHW.validator.DateValidator;
import vintedHW.validator.SizeValidator;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PurchaseParser {

    private static final int NUMBER_OF_PARAMETERS = 3; // we are able to add more parameters such as estimated delivery time or constant employee discount

    public static ParsedPurchase parseLine(String purchaseString) {
        String[] purchaseParts = purchaseString.split(" ");
        if (purchaseParts.length == NUMBER_OF_PARAMETERS) {
            try {
                String dateString = purchaseParts[0];
                String sizeString = purchaseParts[1];
                String carrierString = purchaseParts[2];

                if (!DateValidator.validateDate(dateString) || !SizeValidator.validateSize(sizeString) || !CarrierValidator.validateCarrier(carrierString)) {
                    return new ParsedPurchase(purchaseString);
                }

                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date date = formatter.parse(dateString);
                Size size = Size.valueOf(sizeString.toUpperCase());
                Carrier carrier = Carrier.valueOf(carrierString.toUpperCase());

                return new ParsedPurchase(date, size, carrier);

            } catch (ParseException | IllegalArgumentException e) {
                return new ParsedPurchase(purchaseString);
            }
        } else {
            return new ParsedPurchase(purchaseString);
        }
    }
}
