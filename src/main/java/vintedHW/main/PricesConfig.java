package vintedHW.main;

import vintedHW.entity.Carrier;
import vintedHW.entity.Size;
import vintedHW.reader.PurchaseFileReader;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PricesConfig {

    private final static String PRICES_CONFIG_FILE = "prices.properties";

    private Map<Size, Map<Carrier, BigDecimal>> prices = new HashMap<>();

    public PricesConfig() {
        Properties properties = new Properties();
        ClassLoader classLoader = PurchaseFileReader.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(PRICES_CONFIG_FILE);
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("File with prices was not read");
        }
        for (Size size : Size.values()) {
            prices.put(size, new HashMap<>());
            for (Carrier carrier : Carrier.values()) {
                prices.get(size).put(carrier, new BigDecimal(properties.getProperty("price." + carrier.getCarrier() + "." + size.getSize()  )));

            }
        }
    }

    public BigDecimal getPrice(Size size, Carrier carrier) {
        return prices.get(size).get(carrier);
    }

    public BigDecimal getMinCost(Size size) {
        return prices.get(size).values().stream().min(BigDecimal::compareTo).get();
    }
}