import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Tests generated using DeepSeek
public class DeepSeeksTests {

    // Test case 1: Test the constructor and all getters (covers id, name, quantity, price)
    @Test
    void testConstructorAndGetters() {
        Product product = new Product(1, "Laptop", 10, 999.99);

        assertEquals(1, product.getId(), "ID should match the constructor input");
        assertEquals("Laptop", product.getName(), "Name should match the constructor input");
        assertEquals(10, product.getQuantity(), "Quantity should match the constructor input");
        assertEquals(999.99, product.getPrice(), "Price should match the constructor input");
    }

    // Test case 2: Test the fromString method with valid input
    @Test
    void testFromStringWithValidInput() {
        String data = "2,Smartphone,5,499.99";
        Product product = Product.fromString(data);

        assertEquals(2, product.getId(), "ID should match the input string");
        assertEquals("Smartphone", product.getName(), "Name should match the input string");
        assertEquals(5, product.getQuantity(), "Quantity should match the input string");
        assertEquals(499.99, product.getPrice(), "Price should match the input string");
    }

    // Test case 3: Test the display method
    @Test
    void testDisplayMethod() {
        Product product = new Product(3, "Tablet", 7, 299.99);
        String expectedDisplay = "ID: 3, Name: Tablet, Quantity: 7, Price: 299.99";

        assertEquals(expectedDisplay, product.display(), "Display output should match the expected format");
    }
}

