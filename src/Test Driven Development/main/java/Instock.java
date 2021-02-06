import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Instock implements ProductStock {

    private List<Product> products;

    public Instock () {
        this.products = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return this.products.size();
    }

    @Override
    public boolean contains(Product product) {
        return this.products.contains(product);
    }

    @Override
    public void add(Product product) {
        if (product == null) {
            throw new UnsupportedOperationException();
        }
        this.products.add(product);
    }

    @Override
    public void changeQuantity(String product, int quantity) {
        this.products.replaceAll(p -> {
            if (p.getLabel().equals(product)) {
                int newQuantity = p.getQuantity() + quantity;
                p.setQuantity(newQuantity);
            }
            return p;
        });
    }

    @Override
    public Product find(int index) {
        return this.products.get(index - 1);
    }

    @Override
    public Product findByLabel(String label) {
        return this.products
                .stream()
                .filter(f -> f.getLabel().equals(label))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {
        ArrayList<Product> result = new ArrayList<>();

        if (count > 0 || count <= getCount()) {
            this.products
                    .stream()
                    .sorted(Product::compareTo) // Equal to (f, s) -> f.compareTo(s)
                    .limit(count)
                    .forEach(result::add); // Equal to e -> result.add(e)
        }
        return result;
    }

    @Override
    public Iterable<Product> findAllInRange(double lo, double hi) {
        return this.products
                .stream()
                .filter(p -> p.getPrice() > lo && p.getPrice() <= hi)
                .sorted((f, s) -> Double.compare(s.getPrice(), f.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllByPrice(double price) {
        return this.findAllInRange(price - 0.00001, price);
    }

    @Override
    public Iterable<Product> findFirstMostExpensiveProducts(int count) {
        if (count < this.getCount()) {
            throw new IllegalArgumentException();
        }
        Stream<Product> allInRange = this.products
                .stream()
                .filter(p -> p.getPrice() > 5 && p.getPrice() <= 5)
                .sorted((f, s) -> Double.compare(s.getPrice(), f.getPrice()));
        return allInRange.limit(count).collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllByQuantity(int quantity) {
        return this.products
                .stream()
                .filter(p -> p.getQuantity() == quantity)
                .collect(Collectors.toList());
    }

    @Override
    public Iterator<Product> iterator() {
        return this.products.iterator();
    }
}