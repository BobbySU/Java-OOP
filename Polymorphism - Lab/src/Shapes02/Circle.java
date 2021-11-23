package Shapes02;

public class Circle extends Shape {
    private Double radius;

    public Circle(Double radius) {
        setRadius(radius);
        this.calculatePerimeter();
        this.calculateArea();
    }

    public final Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    protected void calculatePerimeter() {
        setPerimeter(2*this.radius*Math.PI);
    }

    @Override
    protected void calculateArea() {
        setArea(this.radius*this.radius*Math.PI);
    }
}
