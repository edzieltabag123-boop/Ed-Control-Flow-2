
public class PatternGeneratorWithEarlyExit {
    public static void main(String[] args) {
        int size = 5;

        System.out.println("=== Pattern Generator ===");

        for (int row = 1; row <= size; row++) {

            // BREAK: Stop the inner loop when column reaches 4.
            for (int col = 1; col <= size; col++) {
                if (col == 4) {
                    break;
                }

                System.out.print("* ");
            }

            System.out.println();

            // CONTINUE: Skip row 3 entirely.
            if (row == 3) {
                continue;
            }

            System.out.println("Completed row: " + row);
        }
    }
}
