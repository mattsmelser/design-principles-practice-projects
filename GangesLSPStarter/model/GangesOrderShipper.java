package model;

import java.util.ArrayList;
import java.util.List;

/**
 * The system that packages and ships book orders for Ganges.com, Inc.
 */
public class GangesOrderShipper {

    private static final double MAX_STANDARD_EXPECTED_SHIPPING = 13.00;
    private static final double MAX_OVERSIZED_EXPECTED_SHIPPING = 27.00;

    public static void main(String[] args) {
        // Some books that need to be shipped
        StandardSizedBook b1 = new StandardSizedBook("The Unbearable Lightness of Being John Malkovich", 19.95);
        OversizedBook b2 = new OversizedBook("The Princess Brideshead Revisited", 29.15);

        // Add them to a list so it's easy to iterate through them
        List<StandardSizedBook> standardSizedBooksToShip = new ArrayList<>();
        standardSizedBooksToShip.add(b1);
        List<OversizedBook> oversizedBooksToShip= new ArrayList<>();
        oversizedBooksToShip.add(b2);

        for (StandardSizedBook b : standardSizedBooksToShip) {
            String thisTitle = b.getTitle();
            System.out.printf("Packaging and shipping %s.\n", thisTitle);

            // Package the book in a medium sized box
            Box box = b.packageBook(new Box("medium"));
            double shipping = box.calculateShipping();
            System.out.printf("The book %s is being shipped for %.2f in a %s-sized box.\n",
                    thisTitle, shipping, "medium");

            // model.StandardSizedBook is successfully boxed up, so calculate the shipping cost and make sure it's not too expensive
            if (shipping > MAX_STANDARD_EXPECTED_SHIPPING) {
                System.out.printf("WARNING: The shipping for %s is too expensive!\n", thisTitle);
            } else {
                System.out.printf("SUCCESS: %s shipped successfully!\n", thisTitle);
            }

            System.out.println();
        }
        for (OversizedBook b : oversizedBooksToShip) {
            String thisTitle = b.getTitle();
            System.out.printf("Packaging and shipping %s.\n", thisTitle);

            // Package the book in a large sized box
            Box box = b.packageBook(new Box("large"));
            double shipping = box.calculateShipping();
            System.out.printf("The book %s is being shipped for %.2f in a %s-sized box.\n",
                    thisTitle, shipping, "large");

            // model.StandardSizedBook is successfully boxed up, so calculate the shipping cost and make sure it's not too expensive
            if (shipping > MAX_OVERSIZED_EXPECTED_SHIPPING) {
                System.out.printf("WARNING: The shipping for %s is too expensive!\n", thisTitle);
            } else {
                System.out.printf("SUCCESS: %s shipped successfully!\n", thisTitle);
            }

            System.out.println();
        }
    }
}
