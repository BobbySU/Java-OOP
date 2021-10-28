package PointInRectangle02;

public class Rectangle {
    private Point pointA;
    private Point pointC;

    public Rectangle(Point pointA, Point pointC) {
        this.pointA = pointA;
        this.pointC = pointC;
    }

    public boolean contains(Point point) {
        return point.getA() >= this.pointA.getA()
                && point.getA() <= this.pointC.getA()
                && point.getB() >= this.pointA.getB()
                && point.getB() <= this.pointC.getB();
    }
}
