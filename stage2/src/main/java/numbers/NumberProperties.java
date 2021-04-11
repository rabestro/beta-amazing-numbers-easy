package numbers;

public class NumberProperties {
    private final long number;

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

    @Override
    public String toString() {
        return String.format(
                "Properties for number %d%n" +
                "%20s: %s%n%20s: %b%n",
                number,
                "parity", isEven() ?  "even" : "odd",
                "is gapgul", isGapful()
        );
    }
}
