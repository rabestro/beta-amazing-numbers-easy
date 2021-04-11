package numbers;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Enter a natural number: ");
            final var number = scanner.nextLong();
            if (number == 0) {
                break;
            }
            final var properties = new NumberProperties(number);
            System.out.println(properties);
        }
    }

}
