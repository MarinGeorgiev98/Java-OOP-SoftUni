package restaurant;

import java.math.BigDecimal;

public class Cake extends Dessert {
    private static final double CAKE_GRAMS = 250;
    private static final double CAKE_CALORIES = 1000;
    private static final double CAKE_PRICES = 5;
    public Cake (String name) {
        super(name, new BigDecimal(CAKE_PRICES), CAKE_GRAMS, CAKE_CALORIES);
    }
}