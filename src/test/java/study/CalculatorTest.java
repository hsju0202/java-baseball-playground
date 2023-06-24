package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Scanner;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10"}, delimiter = ':')
    void calculator(String input, String expected) {
        Scanner scanner = new Scanner(input);
        String value = scanner.nextLine();
        String[] values = value.split(" ");

        int actual = Integer.parseInt(values[0]);
        for (int i = 0; i < values.length - 2; i += 2) {
            String operator = values[i + 1];
            int number = Integer.parseInt(values[i + 2]);

            if ("+".equals(operator)) {
                actual += number;
                continue;
            }

            if ("*".equals(operator)) {
                actual *= number;
                continue;
            }

            if ("-".equals(operator)) {
                actual -= number;
                continue;
            }

            if ("/".equals(operator)) {
                actual /= number;
                continue;
            }
        }

        int expect = Integer.parseInt(expected);
        assertThat(actual).isEqualTo(expect);
    }
}
