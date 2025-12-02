package DistanceCalculatorTests;

import DistanceCalculator.DistanceCalculator;
import DistanceCalculator.LengthUnit;
import org.junit.Test;
import static org.junit.Assert.*;

public class DistanceCalculatorTest {
     private final DistanceCalculator calculator = new DistanceCalculator();

     @Test
     public void exampleTest(){
         String expression = "10 cm + 1 m - 10 mm";
         LengthUnit outputUnit = LengthUnit.returnUnit("mm");
         double result = calculator.evaluate(expression, outputUnit);
         assertEquals(1090, result, 0.0001);
     }

     @Test
     public void sameUnitAdditionTest(){
         String expression = "5 m + 3 m";
         LengthUnit outputUnit = LengthUnit.returnUnit("m");
         double result = calculator.evaluate(expression, outputUnit);
         assertEquals(8, result, 0.0001);
     }

     @Test
     public void differentUnitAdditionTest(){
         String expression = "50 cm + 1 m";
         LengthUnit outputUnit = LengthUnit.returnUnit("m");
         double result = calculator.evaluate(expression, outputUnit);
         assertEquals(1.5, result, 0.0001);
     }

     @Test
     public void multipleDifferentUnitsTest(){
         String expression = "1 km + 500 m + 20000 cm";
         LengthUnit outputUnit = LengthUnit.returnUnit("m");
         double result = calculator.evaluate(expression, outputUnit);
         assertEquals(1700, result, 0.0001);
     }

     @Test
     public void negativeResultTest(){
         String expression = "5 m - 10 m";
         LengthUnit outputUnit = LengthUnit.returnUnit("m");
         double result = calculator.evaluate(expression, outputUnit);
         assertEquals(-5, result, 0.0001);
     }

     @Test
     public void outputInDifferentUnitTest(){
         String expression = "1000 cm + 5 m";
         LengthUnit outputUnit = LengthUnit.returnUnit("km");
         double result = calculator.evaluate(expression, outputUnit);
         assertEquals(0.015, result, 0.0001);
     }

    @Test
    public void nullExpressionTest(){
        LengthUnit outputUnit = LengthUnit.returnUnit("m");
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.evaluate(null, outputUnit);
        });
    }

    @Test
    public void  nullOutputUnitTest(){
        String expression = "10 m + 5 m";
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.evaluate(expression, null);
        });
    }

    @Test
    public void unknownUnitTest(){
        String expression = "10 m + 5 xyz";
        LengthUnit outputUnit = LengthUnit.returnUnit("m");
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.evaluate(expression, outputUnit);
        });
    }

    @Test
    public void NaNInputTest(){
        String expression = "10 m + abc";
        LengthUnit outputUnit = LengthUnit.returnUnit("m");
        assertThrows(NumberFormatException.class, () -> {
            calculator.evaluate(expression, outputUnit);
        });
    }

    @Test
    public void invalidOperatorTest(){
        String expression = "10 m * 5 m";
        LengthUnit outputUnit = LengthUnit.returnUnit("m");
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.evaluate(expression, outputUnit);
        });
    }
}
