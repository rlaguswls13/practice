package practice3.inherit.shape.controller;

import practice3.inherit.shape.constant.MarkMessage;
import practice3.inherit.shape.entity.Triangle;

public class TriangleController extends ShapeController<Triangle> {

    @Override
    public String calcArea(Triangle shape) {
        double area = (shape.getWidth() * shape.getHeight()) / 2.0;
        return shape + MarkMessage.SEPARATE_MARK + area;
    }

    @Override
    public String calcPerimeter(Triangle shape) {
        double hypotenuse = Math.sqrt(shape.getWidth() * shape.getWidth() + shape.getHeight() * shape.getHeight());
        double perimeter = shape.getWidth() + shape.getHeight() + hypotenuse;
        return shape + MarkMessage.SEPARATE_MARK + perimeter;
    }
}
