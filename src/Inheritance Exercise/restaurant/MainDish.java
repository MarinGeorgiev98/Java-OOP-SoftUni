package restaurant;

import java.math.BigDecimal;

public class MainDish extends Food {
    private String name;
    private BigDecimal price;
    private double grams;

    public MainDish (String name, BigDecimal price, double grams) {
        super(name, price, grams);
    }
}