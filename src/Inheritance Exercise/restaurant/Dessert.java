package restaurant;

import java.math.BigDecimal;

public class Dessert extends Food {
    private String name;
    private BigDecimal price;
    private double grams;
    private double calories;

    public Dessert (String name, BigDecimal price, double grams, double calories) {
        super(name, price, grams);
        this.calories = calories;
    }

    public double getCalories() {
        return calories;
    }
}