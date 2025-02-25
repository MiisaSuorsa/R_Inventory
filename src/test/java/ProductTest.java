import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    // Unit test
    @Test
    void testCreateProduct() {
        // test data
        int expectedId = 100;
        String expectedName = "Test product";
        int expectedQuantity = 10;
        double expectedPrice = 19;

        // Create a product function
        Product product = new Product(expectedId, expectedName, expectedQuantity, expectedPrice);

        // Validate that values are correctly set
        assertEquals(expectedId, product.getId(), "Product ID should match");
        assertEquals(expectedName, product.getName(), "Product name should match");
        assertEquals(expectedQuantity, product.getQuantity(), "Product quantity should match");
        assertEquals(expectedPrice, product.getPrice(), "Product price should match");
    }

    // Unit test
    @Test
    void  testFailToCreateProduct() {
        Exception e = assertThrows(NumberFormatException.class, () -> {
            // user entering "10.5" for quantity when expecting an integer
            int invalidQuantity = Integer.parseInt("10.5");
            new Product(100, "Test product", invalidQuantity, 19);
        });

        assertTrue(e.getMessage().contains("For input string"));
    }
}
