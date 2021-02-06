package aquarium.models.fish;

public class SaltwaterFish extends BaseFish {
    private static final int INITIAL_SIZE = 5;
    private static final int INCREASES = 3;


    public SaltwaterFish(String name, String species, double price) {
        super(name, species, price);
    }

    @Override
    public void eat() {
        int oldSize = super.getSize();
        super.setSize(oldSize + INCREASES);
    }
}