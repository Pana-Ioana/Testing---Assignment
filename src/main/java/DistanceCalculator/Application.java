package DistanceCalculator;

import java.util.Scanner;

public class Application {
    public void run() {
        Scanner scanner = new Scanner(System.in);
        DistanceCalculator calculator = new DistanceCalculator();

        System.out.print("Enter expression (ex: 10 cm + 1 m - 10 mm): ");
        String expression = scanner.nextLine();

        System.out.print("Enter output unit (mm, cm, dm, m, km): ");
        String unitText = scanner.nextLine();

        LengthUnit outputUnit = LengthUnit.returnUnit(unitText);

        double result = calculator.evaluate(expression, outputUnit);

        System.out.println("Result: " + result + " " + outputUnit);
    }
}
