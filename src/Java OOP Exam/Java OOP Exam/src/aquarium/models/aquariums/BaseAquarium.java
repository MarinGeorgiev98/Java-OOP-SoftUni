package aquarium.models.aquariums;

import aquarium.models.decorations.Decoration;
import aquarium.models.fish.Fish;

import java.util.Collection;
import java.util.Collections;

public abstract class BaseAquarium implements Aquarium {
    private String name;
    private int capacity;
    private Collection<Decoration> decorations;
    private Collection<Fish> fish;

    public BaseAquarium(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public void setName(String name) {
        if (name == null || name.trim().length() < 1) {
            throw new NullPointerException("Name cannot be null");
        }
        this.name = name;
    }

    @Override
    public int calculateComfort() {
        return this.decorations
                .stream()
                .mapToInt(d -> d.getComfort()).sum();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addFish(Fish fish) {
        if (this.capacity >= this.fish.size()) {
           throw new IllegalArgumentException("Not enough capacity.");
        }
        this.fish.add(fish);
    }

    @Override
    public void removeFish(Fish fish) {
        this.fish.remove(fish);
    }

    @Override
    public void addDecoration(Decoration decoration) {
        this.decorations.add(decoration);
    }

    @Override
    public void feed() {
        this.fish
                .forEach(f -> f.eat());
//        for (Fish fish1 : fish) { - another way
//            fish1.eat();
//        }
    }

    @Override
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb
                .append(String.format ("%s %s:", this.getName(),
                        this.getClass().getSimpleName()))
                .append(System.lineSeparator())
                .append(String.format("Fish: %s", this.fish.isEmpty()
                        ? "none"
                        : printFish()))
                .append(System.lineSeparator())
                .append(String.format("Decorations: %d", this.decorations.size()))
                .append(System.lineSeparator())
                .append(String.format("Comfort: %d", this.calculateComfort()));
        return sb.toString().trim();
    }

    protected  String printFish() {
        StringBuilder sb = new StringBuilder();
        this.fish
                .forEach(f -> sb.append(f.getName()).append(" "));
        return sb.toString().trim();
    }

    @Override
    public Collection<Fish> getFish() {
        return Collections.unmodifiableCollection(this.fish);
    }

    @Override
    public Collection<Decoration> getDecorations() {
        return Collections.unmodifiableCollection(this.decorations);
    }
}