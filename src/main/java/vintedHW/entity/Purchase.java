package vintedHW.entity;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Purchase {
    private Date date;
    private Size size;
    private Carrier carrier;
    //private BigDecimal deliveryCost;



   // private String content;


    public Purchase() {
    }

    public Purchase(Date date, Size size, Carrier carrier) {
        this.date = date;
        this.size = size;
        this.carrier = carrier;
       // this.deliveryCost = Price.valueOf(carrier.name()).getCost(size);

    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Carrier getCarrier() {
        return carrier;
    }

    public void setCarrier(Carrier carrier) {
        this.carrier = carrier;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Purchase purchase = (Purchase) o;

        if (date != null ? !date.equals(purchase.date) : purchase.date != null) return false;
        if (size != purchase.size) return false;
        return carrier == purchase.carrier;
    }

    @Override
    public int hashCode() {
        int result = date != null ? date.hashCode() : 0;
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (carrier != null ? carrier.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = formatter.format(date);

        return formattedDate + " " + size + " " + carrier + " ";    }
}
