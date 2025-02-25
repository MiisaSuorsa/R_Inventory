import org.junit.jupiter.api.Test;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class FilterByPriceRangeTest {

    // Integration test
    @Test
    void filterProductsByPriceRange() {
        // Create a products
        Product product1 = new Product(10, "Test product 1", 10, 19);
        Product product2 = new Product(11, "Test product 2", 10, 190);
        Product product3 = new Product(12, "Test product 3", 10, 200);
        Product product4 = new Product(13, "Test product 4", 10, 1900);

        // Add the products
        InventoryManager inventoryManager = new InventoryManager();
        inventoryManager.addProduct(product1);
        inventoryManager.addProduct(product2);
        inventoryManager.addProduct(product3);
        inventoryManager.addProduct(product4);

        // FilterByPriceRange functionality
        FilterByPriceRange filter = new FilterByPriceRange(inventoryManager);

        // Simulate user input (min price: 100, max price: 500)
        // Mock the user input for this test
        InputStream sysInBackup = System.in; // Backup the original System.in
        try {
            // Simulating user input via ByteArrayInputStream
            String simulatedInput = "100\n500\n"; // Simulating input: minPrice = 100, maxPrice = 500
            System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

            // Execute the filter
            ByteArrayOutputStream sysOutBackup = new ByteArrayOutputStream();
            System.setOut(new PrintStream(sysOutBackup)); // Capture the output

            filter.execute();  // Run the filtering

            // Verify that only products within the price range are printed
            String output = sysOutBackup.toString();
            assertFalse(output.contains("Test product 1"), "Test product 1 should NOT be in the output");
            assertTrue(output.contains("Test product 2"), "Test product 2 should be in the output");
            assertTrue(output.contains("Test product 3"), "Test product 3 should be in the output");
            assertFalse(output.contains("Test product 4"), "Test product 4 should NOT be in the output");
        } finally {
            System.setIn(sysInBackup); // Restore original System.in
        }
    }
}
