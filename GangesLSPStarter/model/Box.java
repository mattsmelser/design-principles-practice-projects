package model;

/**
 * A box for shipping book orders. Boxes come in small, medium, and large sizes.
 */
public class Box {

    private int size;
    private StandardSizedBook standardSizedBookContents;
    private OversizedBook oversizedBookContents;

    private static final String[] SIZES = {"none", "small", "medium", "large"};
    private static final double BASE_SHIPPING = 5.50;

    // REQUIRES size must be one of "small", "medium", "large"
    public Box(String size) {
        // translate the size string into an int, for easier handling
        if (size.equals("small")) {
            this.size = 1;
        } else if (size.equals("medium")) {
            this.size = 2;
        } else {
            this.size = 3;
        }

        // model.Box starts off empty
        oversizedBookContents = null;
        standardSizedBookContents = null;
    }

    public void setContents(StandardSizedBook contents) {
        this.standardSizedBookContents = contents;
    }

    public void setContents(OversizedBook contents) {
        this.oversizedBookContents = contents;
    }

    // EFFECTS: returns the size of this box
    public String getSize() {
        return SIZES[size];
    }

    // EFFECTS: Calculates the shipping cost of this box, based on its size and contents
    public double calculateShipping() {
        double price = BASE_SHIPPING * size;
        if (standardSizedBookContents != null) {
            price = price + standardSizedBookContents.calculateShipping();
        }
        if (oversizedBookContents != null) {
            price = price + oversizedBookContents.calculateShipping();
        }
        return price;
    }
}
