package pointinrectangle;

public class Rectangle {
    private Point bottomLeft;
    private Point topRight;

    public Rectangle(int bottomLeftX, int bottomLeftY, int topRightX, int topRightY) {
        this.bottomLeft = new Point(bottomLeftX, bottomLeftY);
        this.topRight = new Point(topRightX, topRightY);
    }
    public boolean contains(Point point) {
        if (point.getX() >= this.bottomLeft.getX() &&
                point.getX() <= this.topRight.getX() &&
                point.getY() >= this.bottomLeft.getY() &&
                point.getY() <= this.topRight.getY()) {
                return true;
            }
        return false;
    }
}