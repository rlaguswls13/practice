package practice3.inherit.shape.controller;

import practice3.inherit.shape.constant.MarkMessage;
import practice3.inherit.shape.entity.Rectangle;

public class RectangleController extends ShapeController<Rectangle> {

    @Override
    public String calcArea(Rectangle r) {
        int width = r.getWidth();
        int height = r.getHeight();
        String area = String.valueOf(width * height);
        return r + MarkMessage.SEPARATE_MARK + area;
    }

    @Override
    public String calcPerimeter(Rectangle r) {
        int width = r.getWidth();
        int height = r.getHeight();
        String perimeter = String.valueOf((width + height) * 2);
        return r + MarkMessage.SEPARATE_MARK + perimeter;
    }
}
