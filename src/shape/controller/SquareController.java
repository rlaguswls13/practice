package shape.controller;

import lombok.NoArgsConstructor;
import shape.ShapeConstants;
import shape.entity.Shape;

@NoArgsConstructor
public class SquareController {

    private Shape s = new Shape();

    public double calcPerimeter(double height, double width) {
        s = Shape.builder().type(4).height(height).width(width).build();
        return width * 2 + height * 2;
    }

    public double calcArea(double height, double width) {
        s = Shape.builder().type(4).height(height).width(width).build();
        return width * height;
    }

    public void paintColor(String color) {
        s.setColor(color);
    }

    public String print() {
        return ShapeConstants.PREFIX_SQUARE + s.information();
    }
}
