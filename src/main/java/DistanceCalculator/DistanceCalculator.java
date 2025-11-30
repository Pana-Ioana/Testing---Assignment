package DistanceCalculator;

public class DistanceCalculator {
    public double evaluate(String expression, LengthUnit unit) {
        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException("Expression cannot be null or empty");
        }

        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }

        String tokens[] = expression.split(" ");
        if ((tokens.length < 2) || (((tokens.length - 2) % 3) != 0)) {
            throw new NumberFormatException("Invalid expression format");
        }

        double firstValue = Double.parseDouble(tokens[0]);
        LengthUnit firstUnit = LengthUnit.returnUnit(tokens[1]);
        double convertedValue = (firstValue * firstUnit.inMilimeters) / unit.inMilimeters;

        for (int i = 2; i < tokens.length; i += 3) {
            String operator = tokens[i];
            double number = Double.parseDouble(tokens[i + 1]);
            LengthUnit lengthUnit = LengthUnit.returnUnit(tokens[i + 2]);
            double valueInTargetUnit = (number * lengthUnit.inMilimeters) / unit.inMilimeters;

            switch (operator) {
                case "+" -> convertedValue += valueInTargetUnit;
                case "-" -> convertedValue -= valueInTargetUnit;
                default -> throw new IllegalArgumentException("Only addition and subtraction are supported");
            }
        }

        return convertedValue;
    }
}
