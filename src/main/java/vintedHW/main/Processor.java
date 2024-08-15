package vintedHW.main;

import vintedHW.entity.ParsedPurchase;
import vintedHW.entity.PurchaseDelivery;
import vintedHW.parser.PurchaseParser;
import vintedHW.reader.PurchaseFileReader;
import vintedHW.service.impl.DiscountCalculationServiceImpl;
import vintedHW.writer.PurchaseDeliveryWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Processor {
    public static List<String> process(String filePath) {
        List<String> result = new ArrayList<>();
        DiscountCalculationServiceImpl service = new DiscountCalculationServiceImpl();
        try (Stream<String> lines = Files.lines(Paths.get(PurchaseFileReader.class.getResource(filePath).toURI()))) {
            lines.forEach(line -> {
                    ParsedPurchase parsedPurchase = PurchaseParser.parseLine(line);
                    if(parsedPurchase.getErrorMessage() != null) {
                        PurchaseDeliveryWriter.saveIgnoredLine(result, line);
                        return;
                    }
                    PurchaseDelivery processedPurchase = service.calculateDiscount(parsedPurchase.getPurchase());
                    PurchaseDeliveryWriter.saveCorrectLine(result, processedPurchase);
            });
            return result;
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException("Failed to read file: " + filePath, e);
        }
    }
}
