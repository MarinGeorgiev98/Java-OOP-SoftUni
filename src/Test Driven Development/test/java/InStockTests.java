import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class InStockTests {

    Product product;
    Instock stock;
    private static final String DEFAULT_PRODUCT_LABEL = "Label";
    private final int DEFAULT_PRODUCT_QUANTITY = 200;

    @Before
    public void setup() {
        this.product = new Product(DEFAULT_PRODUCT_LABEL, 2.5,
                DEFAULT_PRODUCT_QUANTITY);
        this.stock = new Instock();
    }

    @Test
    public void shouldAddProduct() {
        stock.add(product);
        assertTrue(this.stock.contains(product));
    }

    @Test
    public void shouldHaveNonZeroCountAfterAddProduct() {
        stock.add(product);
        assertEquals(this.stock.getCount(), 1);
    }

    @Test
    public void shouldHaveCountAqualstoProductAddded() {
        stock.add(product);
        stock.add(product);
        stock.add(product);
        assertEquals(this.stock.getCount(), 3);
    }

    @Test
    public void containsShouldReturnTrueIfProductsLabelsMatch() {
        Product second = new Product(DEFAULT_PRODUCT_LABEL, 10, 10);
        this.stock.add(second);
        assertTrue(this.stock.contains(product));
    }

    @Test
    public void shouldReturnCorrectProductByInsertionOrder() {
        Product second = new Product(DEFAULT_PRODUCT_LABEL + "2",
                10, 10);
        Product third = new Product(DEFAULT_PRODUCT_LABEL + "3",
                10, 10);
        this.stock.add(this.product);
        this.stock.add(second);
        this.stock.add(third);

        Product actual = this.stock.find(1);
        assertEquals(product,actual);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExWhenIndexOutOfBounds() {
        this.stock.find(0);
    }

    @Test
    public void shouldChangeQuantityWithAGivenAmount() {
        this.stock.add(product);
        this.stock.changeQuantity(product.getLabel(), DEFAULT_PRODUCT_QUANTITY);
        Product actual = this.stock.find(1);
        assertEquals(DEFAULT_PRODUCT_QUANTITY * 2, actual.getQuantity());
    }

    @Test
    public void shouldChangeQuantityWithAGivenAmountMultipleTimes() {
        this.stock.add(product);
        this.stock.changeQuantity(product.getLabel(), DEFAULT_PRODUCT_QUANTITY);
        this.stock.changeQuantity(product.getLabel(), DEFAULT_PRODUCT_QUANTITY);
        this.stock.changeQuantity(product.getLabel(), DEFAULT_PRODUCT_QUANTITY);
        this.stock.changeQuantity(product.getLabel(), DEFAULT_PRODUCT_QUANTITY);

        Product actual = this.stock.find(1);
        assertEquals(DEFAULT_PRODUCT_QUANTITY * 4, actual.getQuantity());
    }

    @Test
    public void shouldFindProductByLabel() {
        this.stock.add(product);
        Product actual = this.stock.findByLabel(product.getLabel());
        assertEquals(product, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnFirstProductSortedByLabel() {
        Product second = new Product(DEFAULT_PRODUCT_LABEL + "2",
                10, 10);
        Product third = new Product(DEFAULT_PRODUCT_LABEL + "3",
                10, 10);
        this.stock.add(this.product);
        this.stock.add(second);
        this.stock.add(third);
        Iterable<Product> actual = this.stock.findFirstByAlphabeticalOrder(1);

        assertFalse(actual.iterator().hasNext());
    }

    @Test
    public void findAllPriceInRange() {
        Iterable<Product> actual = this.stock.findAllInRange(5, 15);
        assertFalse(actual.iterator().hasNext());
    }
}