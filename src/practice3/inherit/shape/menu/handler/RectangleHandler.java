package practice3.inherit.shape.menu.handler;

import practice3.inherit.shape.constant.ShapeMessage;
import practice3.inherit.shape.controller.RectangleController;
import practice3.inherit.shape.entity.Rectangle;
import practice3.inherit.common.utils.InputView;

public record RectangleHandler(RectangleController rc, InputView viewer) implements ShapeHandler {

    @Override
    public void handlePerimeter() {
        Rectangle r = Rectangle.builder()
                .x(viewer.inputInt(ShapeMessage.PROMPT_X))
                .y(viewer.inputInt(ShapeMessage.PROMPT_Y))
                .width(viewer.inputInt(ShapeMessage.PROMPT_WIDTH))
                .height(viewer.inputInt(ShapeMessage.PROMPT_HEIGHT))
                .build();

        System.out.println(rc.calcPerimeter(r));
    }

    @Override
    public void handleArea() {
        Rectangle r = Rectangle.builder()
                .x(viewer.inputInt(ShapeMessage.PROMPT_X))
                .y(viewer.inputInt(ShapeMessage.PROMPT_Y))
                .width(viewer.inputInt(ShapeMessage.PROMPT_WIDTH))
                .height(viewer.inputInt(ShapeMessage.PROMPT_HEIGHT))
                .build();

        System.out.println(rc.calcArea(r));
    }
}
