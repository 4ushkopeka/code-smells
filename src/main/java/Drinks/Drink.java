package Drinks;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Map.entry;

public abstract class Drink {
    protected int price;

    protected boolean discountable;

    protected Map<String, Integer> ingredients = Map.ofEntries(
            entry("Rum", 65),
            entry("Grenadine", 10),
            entry("Lime Juice", 10),
            entry("Green Stuff", 10),
            entry("Tonic Water", 20),
            entry("Gin", 85)
    );

    public Drink(int price, boolean discountable) {
        this.price = price;
        this.discountable = discountable;
    }

    public boolean isDiscountable() {
        return discountable;
    }

    public int getPrice() {
        return price;
    }
}
