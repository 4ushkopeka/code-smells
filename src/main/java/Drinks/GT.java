package Drinks;

public class GT extends Drink {
    public GT() {
        super(0, false);
    }

    @Override
    public int getPrice() {
        return ingredients.get("Green Stuff")
                + ingredients.get("Tonic Water")
                + ingredients.get("Gin");
    }
}
