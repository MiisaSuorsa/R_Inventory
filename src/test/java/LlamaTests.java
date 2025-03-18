import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Tests generated using Llama
public class LlamaTests {
    @Test
    void testConstructorAndGetters() {
        // Arrange
        int id = 1;
        String name = "Test Product";
        int quantity = 10;
        double price = 9.99;

        // Act
        Product product = new Product(id, name, quantity, price);

        // Assert
        assertEquals(id, product.getId());
        assertEquals(name, product.getName());
        assertEquals(quantity, product.getQuantity());
        assertEquals(price, product.getPrice(), 0.01); // Using delta for double precision
    }

    @Test
    void testFromStringValidInput() {
        // Arrange
        String input = "200,Sample Item,50,24.99";

        // Act
        Product product = Product.fromString(input);

        // Assert
        assertEquals(200, product.getId());
        assertEquals("Sample Item", product.getName());
        assertEquals(50, product.getQuantity());
        assertEquals(24.99, product.getPrice(), 0.01);
    }

    @Test
    void testDisplayMethod() {
        // Arrange
        Product product = new Product(300, "Beverage", 20, 1.99);

        // Act
        String displayResult = product.display();

        // Assert
        String expected = "ID: 300, Name: Beverage, Quantity: 20, Price: 1.99";
        assertEquals(expected, displayResult);
    }
}
