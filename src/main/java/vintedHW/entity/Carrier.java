package vintedHW.entity;

public enum Carrier {
    MR("mr"),
    LP("lp");

    private final String alias;
    Carrier(String alias) {
        this.alias = alias;
    }

    public String getCarrier() {
        return alias;
    }
}
