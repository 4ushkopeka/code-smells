package nerdschool.bar;

import Drinks.BacardiSpecial;
import Drinks.Drink;
import Drinks.GT;

public class Pub {

    public int computeCost(Drink drink, boolean student, int amount) {

        if (amount > 2 && (drink instanceof GT || drink instanceof BacardiSpecial)) {
            throw new RuntimeException("Too many drinks, max 2.");
        }

        int price = studentDiscount(drink.getPrice(), drink, student);

        return price*amount;
    }

    private int studentDiscount(int rawPrice, Drink drink, boolean student) {
        if (student && drink.isDiscountable()) {
            return rawPrice - rawPrice/10;
        }
        return rawPrice;
    }
}
