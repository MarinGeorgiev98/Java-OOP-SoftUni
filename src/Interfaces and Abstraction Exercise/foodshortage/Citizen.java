package foodshortage;

public class Citizen implements Identifiable, Birthable, Buyer {

    private String name;
    private int age;
    private String id;
    private String birthDate;
    private int food;


    public Citizen(String name, int age, String id, String birthDate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthDate = birthDate;
    }

    @Override
    public String getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String getBirthDate() {
        return this.birthDate;
    }

    @Override
    public void buyFood() {

    }

    @Override
    public int getFood() {
        return this.food;
    }
}