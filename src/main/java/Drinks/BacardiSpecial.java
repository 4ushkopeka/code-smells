package Drinks;

public class BacardiSpecial extends Drink {

    public BacardiSpecial() {
        super(0, false);
    }

    @Override
    public int getPrice() {
        return ingredients.get("Lime Juice")
                + ingredients.get("Rum")
                + ingredients.get("Grenadine")
                + ingredients.get("Gin")/2;
    }
}
