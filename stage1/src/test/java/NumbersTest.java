import org.hyperskill.hstest.dynamic.DynamicTest;
import org.hyperskill.hstest.exception.outcomes.WrongAnswer;
import org.hyperskill.hstest.stage.StageTest;
import org.hyperskill.hstest.testcase.CheckResult;
import org.hyperskill.hstest.testing.TestedProgram;

import java.text.MessageFormat;

public class NumbersTest extends StageTest {

    final long[] number = {1, 2, 3, 4, 5};

    @DynamicTest(data = "number")
    CheckResult simpleTest(final long number) {
        final var program = new TestedProgram();

        assertTrue(program.start().toLowerCase().contains("natural number"),
                "The program should ask for a natural number");

        final var expected = number % 2 == 0 ? "even" : "odd";
        final var actual = program.execute(String.valueOf(number)).toLowerCase();

        assertTrue(actual.contains(expected), "Number {0} should be {1}.", number, expected);

        return CheckResult.correct();
    }

    private static void assertTrue(final boolean condition, final String error, final Object... args) {
        if (!condition) {
            final var feedback = MessageFormat.format(error, args);
            throw new WrongAnswer(feedback);
        }
    }

}
