package aquarium.models.aquariums;

public class  FreshwaterAquarium extends BaseAquarium {

    private static final int CAPACITY = 5;

    public FreshwaterAquarium(String name) {
        super(name, CAPACITY);
    }
}