package practice3.inherit.shape.menu.handler;

import practice3.inherit.shape.constant.ShapeMessage;
import practice3.inherit.shape.controller.TriangleController;
import practice3.inherit.shape.entity.Triangle;
import practice3.inherit.common.utils.InputView;

public record TriangleHandler(TriangleController tc, InputView viewer) implements ShapeHandler {

    @Override
    public void handlePerimeter() {
        Triangle t = Triangle.builder()
                .x(viewer.inputInt(ShapeMessage.PROMPT_X))
                .y(viewer.inputInt(ShapeMessage.PROMPT_Y))
                .width(viewer.inputInt(ShapeMessage.PROMPT_WIDTH))
                .height(viewer.inputInt(ShapeMessage.PROMPT_HEIGHT))
                .build();

        System.out.println(tc.calcPerimeter(t));
    }

    @Override
    public void handleArea() {
        Triangle t = Triangle.builder()
                .x(viewer.inputInt(ShapeMessage.PROMPT_X))
                .y(viewer.inputInt(ShapeMessage.PROMPT_Y))
                .width(viewer.inputInt(ShapeMessage.PROMPT_WIDTH))
                .height(viewer.inputInt(ShapeMessage.PROMPT_HEIGHT))
                .build();

        System.out.println(tc.calcArea(t));
    }
}
