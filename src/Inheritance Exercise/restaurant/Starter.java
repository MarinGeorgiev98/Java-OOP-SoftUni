package restaurant;

import java.math.BigDecimal;

public class Starter extends Food {
    private String name;
    private BigDecimal price;
    private double grams;

    public Starter (String name, BigDecimal price, double grams) {
        super(name, price, grams);
    }
}