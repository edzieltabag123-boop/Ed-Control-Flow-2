
import java.util.Scanner;

public class SumUntilSentinelValue {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int number;
        int sum = 0;

        System.out.println("Enter integers to add (-1 to stop):");

        number = input.nextInt();

        while (number != -1) {
            sum += number;
            number = input.nextInt();
        }

        System.out.println("Final total: " + sum);

        input.close();
    }
}
