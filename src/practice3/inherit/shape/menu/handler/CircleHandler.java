package practice3.inherit.shape.menu.handler;

import practice3.inherit.shape.constant.ShapeMessage;
import practice3.inherit.shape.controller.CircleController;
import practice3.inherit.shape.entity.Circle;
import practice3.inherit.common.utils.InputView;

public record CircleHandler(CircleController cc, InputView viewer) implements ShapeHandler {

    @Override
    public void handlePerimeter() {
        Circle c = Circle.builder()
                .x(viewer.inputInt(ShapeMessage.PROMPT_X))
                .y(viewer.inputInt(ShapeMessage.PROMPT_Y))
                .radius(viewer.inputInt(ShapeMessage.PROMPT_RADIUS))
                .build();

        System.out.println(cc.calcPerimeter(c));
    }

    @Override
    public void handleArea() {
        Circle c = Circle.builder()
                .x(viewer.inputInt(ShapeMessage.PROMPT_X))
                .y(viewer.inputInt(ShapeMessage.PROMPT_Y))
                .radius(viewer.inputInt(ShapeMessage.PROMPT_RADIUS))
                .build();

        System.out.println(cc.calcArea(c));
    }
}
