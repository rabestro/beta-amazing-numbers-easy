package numbers;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Enter a natural number: ");
            final var data = scanner.nextLine().split("[,\\s]+");
            final var first = Long.parseLong(data[0]);
            if (first == 0) {
                break;
            }
            if (data.length == 1) {
                final var properties = new NumberProperties(first);
                System.out.println(properties);
                continue;
            }
            final var second = Long.parseLong(data[1]);
            for (long number = first; number <= second; ++number) {
                final var properties = new NumberProperties(number);
                final var shortReport = properties.getShort();
                if (!shortReport.isBlank()) {
                    System.out.printf("%18d - %s%n", number, shortReport);
                }
            }
        }
    }

}
