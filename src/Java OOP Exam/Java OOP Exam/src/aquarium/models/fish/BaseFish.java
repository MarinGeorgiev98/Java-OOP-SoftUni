package aquarium.models.fish;

public abstract class BaseFish implements Fish {
    private String name;
    private String species;
    private int size;
    private double price;

    public BaseFish(String name, String species, double price) {
        this.setName(name);
        this.setSpecies(species);
        this.setPrice(price);
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().length() < 1) {
            throw new NullPointerException("Fish name cannot be null");
        }
        this.name = name;
    }

    public void setSpecies(String species) {
        if (species == null || species.isEmpty()) {
            throw new NullPointerException("Species cannot be null");
        }
        this.species = species;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price cannot be 0 or below");
        }
        this.price = price;
    }

    @Override
    public abstract void eat();

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}