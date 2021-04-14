package numbers;

import java.util.Map;
import java.util.function.BooleanSupplier;
import java.util.stream.Collectors;

public class NumberProperties {
    private final long number;
    private final Map<String, BooleanSupplier> PROPERTIES = Map.of(
            "gapful", this::isGapful,
            "harshad", this::isHarshad
    );

    public NumberProperties(long number) {
        this.number = number;
    }

    public boolean isEven() {
        return number % 2 == 0;
    }

    public boolean isGapful() {
        if (number < 100) {
            return false;
        }
        final var lastDigit = number % 10;
        var firstDigit = number / 100;
        while (firstDigit > 10) {
            firstDigit /= 10;
        }
        final var divisor = firstDigit * 10 + lastDigit;
        return number % divisor == 0;
    }

    public boolean isHarshad() {
        long sumOfDigits = 0;
        for (long i = number; i > 0; i /= 10) {
            sumOfDigits += i % 10;
        }
        return number % sumOfDigits == 0;
    }

    public String getShort() {
        return PROPERTIES
                .entrySet()
                .stream()
                .filter(e -> e.getValue().getAsBoolean())
                .map(Map.Entry::getKey)
                .collect(Collectors.joining(", "));
    }
    @Override
    public String toString() {
        return String.format(
                "Properties for number %d%n" +
                        "%20s: %s%n%20s: %b%n%20s: %s%n",
                number,
                "parity", isEven() ? "even" : "odd",
                "is gapgul", isGapful(),
                "is harshad", isHarshad()
        );
    }
}
