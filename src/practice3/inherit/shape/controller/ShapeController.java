package practice3.inherit.shape.controller;

import practice3.inherit.shape.entity.Point;

public abstract class ShapeController<T extends Point> {
    public abstract String calcArea(T shape);
    public abstract String calcPerimeter(T shape);
}
