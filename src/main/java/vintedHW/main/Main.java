package vintedHW.main;

import vintedHW.entity.Purchase;
import vintedHW.reader.PurchaseFileReader;
import vintedHW.service.DiscountService;
import vintedHW.service.impl.DiscountServiceImpl;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Purchase> purchases = PurchaseFileReader.parsePurchases("/input.txt");
        DiscountService discountService = new DiscountServiceImpl();
        discountService.calculateDiscounts(purchases);

        List<String> input = readfromfile();
        List<String> output;
        State currentState = new State();
        input.foreach()
/*
       while() {
           Purchase purchase = parser.parseLine();
           if(purchase == null) {
               writer.saveIgnoredLine(purchaseString);
           }
           PurchaseDelivery purchaseWithDiscount = service.calculate(purchase, currentState;

              currentState.addPurchase(purchaseWithDiscount);
 ArrayList<Purchase> purchasesWithDiscount
           writer.saveLine(purchaseWithDiscount);
       }
        output()*/
    }
}