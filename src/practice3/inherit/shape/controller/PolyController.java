package practice3.inherit.shape.controller;

import practice3.inherit.shape.constant.MarkMessage;
import practice3.inherit.shape.entity.Poly;

public class PolyController extends ShapeController<Poly> {

    @Override
    public String calcArea(Poly shape) {
        double area = (shape.getDegree() * shape.getSideLength() * shape.getSideLength()) 
                / (4.0 * Math.tan(Math.PI / shape.getDegree()));
        return shape + MarkMessage.SEPARATE_MARK + area;
    }

    @Override
    public String calcPerimeter(Poly shape) {
        double perimeter = shape.getDegree() * shape.getSideLength();
        return shape + MarkMessage.SEPARATE_MARK + perimeter;
    }
}
