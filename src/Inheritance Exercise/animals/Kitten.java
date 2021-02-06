package animals;

public class Kitten extends Animal{
    public Kitten (String name, int age) {
        super(name, age, "Female");
    }

    @Override
    public String produceSound() {
        return "Meow";
    }
}