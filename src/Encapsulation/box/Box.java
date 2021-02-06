package box;

public class Box {
    private double length;
    private double width;
    private double height;
    
    public Box (double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setWidth(double width) {
        validate(width, "Width");
        this.width = width;
    }

    private void setLength(double length) {
        validate(length, "Length");
        this.length = length;
    }

    private void setHeight(double height) {
        validate(height, "Height");
        this.height = height;
    }

    private void validate(double side, String source) {
        if (side <= 0) {
            throw new IllegalArgumentException(String.format(
                    "%s cannot be zero or negative.", source));
        }
    }

    public double calculateSurfaceArea() {
        return 2 * this.length * this.width +
                2 * this.length * this.height +
                2 * this.width * this.height;
    }

    public double calculateLateralSurfaceArea() {
        return 2 * this.length * this.height +
        2 * this.width * this.height;
    }

    public double calculateVolume() {
        return this.width * this.height * this.length;
    }
}