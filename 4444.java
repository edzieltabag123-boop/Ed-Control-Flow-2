
import java.util.Scanner;

public class WarehouseInventoryScanner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // -1 represents a damaged shelf.
        int[][] inventory = {
            {10, 5, 8},
            {7, -1, 12},
            {3, 2, 9}
        };

        System.out.println("=== Warehouse Inventory Scanner ===");

        // 1. Display inventory using a do-while loop.
        int choice;
        do {
            System.out.println("\n1. View inventory");
            System.out.println("2. Calculate total inventory");
            System.out.println("3. Find first critically low shelf");
            System.out.println("4. Restock a shelf");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nInventory:");
                    for (int row = 0; row < inventory.length; row++) {
                        for (int col = 0; col < inventory[row].length; col++) {
                            if (inventory[row][col] == -1) {
                                System.out.print("[DAMAGED] ");
                            } else {
                                System.out.print(inventory[row][col] + " ");
                            }
                        }
                        System.out.println();
                    }
                    break;

                case 2:
                    // 2. Use continue to skip damaged shelves.
                    int total = 0;

                    for (int row = 0; row < inventory.length; row++) {
                        for (int col = 0; col < inventory[row].length; col++) {
                            if (inventory[row][col] == -1) {
                                continue;
                            }
                            total += inventory[row][col];
                        }
                    }

                    System.out.println("Total inventory: " + total);
                    break;

                case 3:
                    // 3. Use nested loops and break to find the first
                    // shelf with fewer than 5 items.
                    boolean found = false;

                    for (int row = 0; row < inventory.length; row++) {
                        for (int col = 0; col < inventory[row].length; col++) {
                            if (inventory[row][col] != -1
                                    && inventory[row][col] < 5) {
                                System.out.println(
                                    "Critical shelf found at row " + row
                                    + ", column " + col
                                    + ", quantity: " + inventory[row][col]
                                );
                                found = true;
                                break;
                            }
                        }

                        if (found) {
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("No critically low shelf found.");
                    }
                    break;

                case 4:
                    // 4. Restock with input validation using a while loop.
                    System.out.print("Enter row (0-2): ");
                    int row = input.nextInt();

                    System.out.print("Enter column (0-2): ");
                    int col = input.nextInt();

                    if (row < 0 || row >= inventory.length
                            || col < 0 || col >= inventory[row].length) {
                        System.out.println("Invalid shelf position.");
                        break;
                    }

                    if (inventory[row][col] == -1) {
                        System.out.println("Cannot restock a damaged shelf.");
                        break;
                    }

                    System.out.print("Enter quantity to add (positive number): ");
                    int amount = input.nextInt();

                    while (amount <= 0) {
                        System.out.print(
                            "Invalid amount. Enter a positive quantity: "
                        );
                        amount = input.nextInt();
                    }

                    inventory[row][col] += amount;
                    System.out.println("Restocking successful!");
                    System.out.println(
                        "Updated quantity: " + inventory[row][col]
                    );
                    break;

                case 0:
                    System.out.println("Exiting inventory scanner.");
                    break;

                default:
                    System.out.println("Invalid menu choice.");
            }

        } while (choice != 0);

        input.close();
        return;
    }
}
