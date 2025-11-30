package DistanceCalculator;

public enum LengthUnit {
    milimeter(1),
    centimeter(10),
    decimeter(100),
    meter(1000),
    kilometer(1000000);

    final long inMilimeters;

    LengthUnit(long inMilimeters) {
        this.inMilimeters = inMilimeters;
    }

    public static LengthUnit returnUnit(String s){
        String lowerS = s.toLowerCase();
        return switch (lowerS) {
            case "mm" -> milimeter;
            case "cm" -> centimeter;
            case "dm" -> decimeter;
            case "m" -> meter;
            case "km" -> kilometer;
            default -> throw new IllegalArgumentException("Unknown length unit: " + s);
        };
    }
}
