import java.util.Scanner;

public class FilterByQuantityRange {
    private final InventoryManager inventoryManager;

    public FilterByQuantityRange(InventoryManager inventoryManager) {
        this.inventoryManager = inventoryManager;
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Minimum Quantity: ");
        double minQuantity = scanner.nextDouble();
        System.out.print("Enter Maximum Quantity: ");
        double maxQuantity = scanner.nextDouble();

        boolean found = false;
        System.out.println("Products within Quantity Range (" + minQuantity + " - " + maxQuantity + "):");
        for (Product product : inventoryManager.getInventory()) {
            if (product.getPrice() >= minQuantity && product.getPrice() <= maxQuantity) {
                System.out.println(product.display());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No products within the specified quantity range.");
        }
    }
}
