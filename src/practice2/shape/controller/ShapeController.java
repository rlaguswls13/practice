package practice2.shape.controller;

import practice2.shape.ShapeConstants;
import practice2.shape.entity.Shape;

public class ShapeController {
    private Shape s = new Shape();

    public double calcPerimeter(int numSides, double sideLength) {
        s = Shape.builder()
                .numSides(numSides)
                .sideLength(sideLength)
                .color(s.getColor()) // 기존 색상 유지
                .build();
        return numSides * sideLength;
    }

    public double calcArea(int numSides, double sideLength) {
        s = Shape.builder()
                .numSides(numSides)
                .sideLength(sideLength)
                .color(s.getColor()) // 기존 색상 유지
                .build();
        return (numSides * sideLength * sideLength) / (4.0 * Math.tan(Math.PI / numSides));
    }

    public void paintColor(String color) {
        s.setColor(color);
    }

    public String print() {
        return String.format(ShapeConstants.MSG_SHAPE_INFO, s.getNumSides(), s.getNumSides(), s.getSideLength(), s.getColor());
    }
}
