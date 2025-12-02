package DistanceCalculatorTests;

import DistanceCalculator.DistanceCalculator;
import DistanceCalculator.LengthUnit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParametrizedTest {

    private final DistanceCalculator calculator = new DistanceCalculator();

    private final String expression;
    private final String unitText;
    private final double expected;

    public ParametrizedTest(String expression, String unitText, double expected) {
        this.expression = expression;
        this.unitText = unitText;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: {0} -> {2} {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"10 cm + 1 m - 10 mm", "mm", 1090},
                {"50 cm + 50 cm", "m", 1},
                {"2 m + 3 dm", "cm", 230},
                {"1 km - 500 m", "m", 500},
                {"100 mm + 10 cm", "mm", 200}
        });
    }

    @Test
    public void exampleParameterizedTest() {
        LengthUnit outputUnit = LengthUnit.returnUnit(unitText);
        double actual = calculator.evaluate(expression, outputUnit);
        assertEquals(expected, actual, 0.0001);
    }
}
