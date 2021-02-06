package aquarium.core;

import aquarium.models.aquariums.Aquarium;
import aquarium.models.aquariums.FreshwaterAquarium;
import aquarium.models.aquariums.SaltwaterAquarium;
import aquarium.models.decorations.Decoration;
import aquarium.models.decorations.Ornament;
import aquarium.models.decorations.Plant;
import aquarium.models.fish.Fish;
import aquarium.models.fish.FreshwaterFish;
import aquarium.models.fish.SaltwaterFish;
import aquarium.repositories.DecorationRepository;
import aquarium.repositories.Repository;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {
    private Repository decorations;
    private Collection<Aquarium> aquariums;

    public ControllerImpl(Repository decorations, Collection<Aquarium> aquariums) {
        this.decorations = new DecorationRepository();
        this.aquariums = new ArrayList<>();
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {
        Aquarium aquarium;
        if (aquariumType.equals("FreshwaterAquarium")) {
            aquarium = new FreshwaterAquarium(aquariumName);
        } else if (aquariumType.equals("SaltwaterAquarium")) {
            aquarium = new SaltwaterAquarium(aquariumName);
        } else {
            throw new IllegalArgumentException("Invalid Aquarium type");
        }
        this.aquariums.add(aquarium);
        return String.format("Successfully added %s", aquariumType);
    }

    @Override
    public String addDecoration(String type) {
        Decoration decoration;
        if (type.equals("Ornament")) {
            decoration = new Ornament();
        } else if (type.equals("Plant")) {
            decoration = new Plant();
        } else {
            throw new IllegalArgumentException("Invalid Decoration type");
        }
        this.decorations.add(decoration);
        return String.format("Successfully added %s", type);
    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {
        Decoration decoration = this.decorations.findByType(decorationType);
        if (decoration == null) {
            throw new IllegalArgumentException(String.format
                    ("No decoration found %s", decorationType));
        }
        Aquarium aquarium = this.aquariums
                .stream()
                .filter(a -> a.getName().equals(aquariumName))
                .findFirst()
                .orElse(null);
        aquarium.addDecoration(decoration);
        this.decorations.remove(decoration);
        return String.format("Successfully added %s", decorationType);
    }

    @Override
    public String addFish(String aquariumName, String fishType,
                          String fishName, String fishSpecies, double price) {
        Fish fish;
        if("FreshwaterFish".equals(fishType)) {
            fish = new FreshwaterFish(fishName, fishSpecies, price);
        }
        else if("Saltwater".equals(fishType)) {
            fish = new SaltwaterFish(fishName, fishSpecies, price);
        }
        else {
            throw new IllegalArgumentException("Invalid fish type");
        }

        Aquarium aquarium = this.aquariums
                .stream()
                .filter(a -> a.getName().equals(aquariumName))
                .findFirst()
                .orElse(null);
        if (!aquarium.getClass().getSimpleName().substring(0, 5)
                .equals(fishType.substring(0,5))) {
            return "Water not suitable";
        }
        aquarium.addFish(fish);
        return String.format("Successfully added %s in %s", fishType, aquariumName);
    }

    @Override
    public String feedFish(String aquariumName) {
        Aquarium aquarium = this.aquariums
                .stream()
                .filter(a -> a.getName().equals(aquariumName))
                .findFirst()
                .orElse(null);
        aquarium.feed();
        return String.format("Fish fed:", aquarium.getFish().size());
    }

    @Override
    public String calculateValue(String aquariumName) {
        Aquarium aquarium = this.aquariums
                .stream()
                .filter(a -> a.getName().equals(aquariumName))
                .findFirst()
                .orElse(null);
        double value = 0;
        for (Fish fish : aquarium.getFish()) {
            value += fish.getPrice();
        }
        for (Decoration decoration : aquarium.getDecorations()) {
            value += decoration.getPrice();
        }
        return String.format("The value of Aquarium %s is %.2f",
                aquariumName, value);
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        for (Aquarium aquarium : aquariums) {
            sb
                    .append(aquarium.getInfo())
                    .append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}