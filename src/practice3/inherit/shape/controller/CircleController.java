package practice3.inherit.shape.controller;

import practice3.inherit.shape.constant.MarkMessage;
import practice3.inherit.shape.entity.Circle;

public class CircleController extends ShapeController<Circle> {

    @Override
    public String calcArea(Circle circle) {
        int radius = circle.getRadius();
        String area = String.valueOf(radius * radius * Math.PI);
        return circle + MarkMessage.SEPARATE_MARK + area;
    }

    @Override
    public String calcPerimeter(Circle circle) {
        int radius = circle.getRadius();
        String perimeter = String.valueOf(Math.PI * radius * 2);
        return circle + MarkMessage.SEPARATE_MARK + perimeter;
    }

}
