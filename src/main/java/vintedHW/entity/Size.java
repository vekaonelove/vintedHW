package vintedHW.entity;

public enum Size {
    S("small"),
    M("medium"),
    L("large");

    private final String size;

    Size(String size) {
        this.size = size;
    }

    public static Size getByValue(String s) {
        for (Size size : Size.values()) {
            if (size.getSize().equals(s)) {
                return size;
            }
        }
        throw new IllegalArgumentException("There is no size with value " + s ) ;
    }

    public String getSize() {
        return size;
    }
}
