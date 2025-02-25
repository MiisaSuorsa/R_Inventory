import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

class AddProductTest {

    // Integration test
    @Test
    void addAndStoreProduct() {


        // Step 1: Create an InventoryManager
        InventoryManager inventoryManager = new InventoryManager();
        AddProduct addProductCommand = new AddProduct(inventoryManager);


        // Simulate user input: Product ID, Name, Quantity, and Price
        String simulatedInput = "100\nTest product\n10\n19\n";
        InputStream stdin = System.in;  // Save original System.in
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));  // Redirect System.in for test

        // Execute the AddProduct command
        addProductCommand.execute();

        // Verify that the product was added to the inventory
        Product addedProduct = inventoryManager.findProductById(100);
        assertNotNull(addedProduct, "Product should be added to the inventory.");
        assertEquals("Test product", addedProduct.getName(), "Product name should match.");
        assertEquals(10, addedProduct.getQuantity(), "Product quantity should match.");
        assertEquals(19, addedProduct.getPrice(), "Product price should match.");

        // Restore original System.in
        System.setIn(stdin);
    }

}
