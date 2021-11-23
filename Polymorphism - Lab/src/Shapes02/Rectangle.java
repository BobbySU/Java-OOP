package Shapes02;

public class Rectangle extends Shape {
    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        setHeight(height);
        setWidth(width);
        this.calculatePerimeter();
        this.calculateArea();
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public Double getWidth() {
        return width;
    }

    @Override
    protected void calculatePerimeter() {
        setPerimeter(this.height*2+this.width*2);
    }

    @Override
    protected void calculateArea() {
        setArea(this.height*this.width);
    }
}
