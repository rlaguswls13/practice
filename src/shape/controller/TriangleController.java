package shape.controller;

import shape.ShapeConstants;
import shape.entity.Shape;

public class TriangleController {
    private Shape s = new Shape();

    public TriangleController() {
    }

    public double calcArea(double height, double width) {
        s = Shape.builder().type(3).height(height).width(width).build();
        return width * height / 2;
    }

    public void paintColor(String color) {
        s.setColor(color);
    }

    public String print() {
        return ShapeConstants.PREFIX_TRIANGLE + s.information();
    }
}
