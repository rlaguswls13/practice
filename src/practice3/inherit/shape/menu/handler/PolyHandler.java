package practice3.inherit.shape.menu.handler;

import practice3.inherit.shape.constant.ShapeMessage;
import practice3.inherit.shape.controller.PolyController;
import practice3.inherit.shape.entity.Poly;
import practice3.inherit.common.utils.InputView;

public record PolyHandler(PolyController pc, InputView viewer) implements ShapeHandler {

    @Override
    public void handlePerimeter() {
        Poly p = Poly.builder()
                .x(viewer.inputInt(ShapeMessage.PROMPT_X))
                .y(viewer.inputInt(ShapeMessage.PROMPT_Y))
                .degree(viewer.inputInt(ShapeMessage.PROMPT_DEGREE))
                .sideLength(viewer.inputInt(ShapeMessage.PROMPT_SIDE_LENGTH))
                .build();

        System.out.println(pc.calcPerimeter(p));
    }

    @Override
    public void handleArea() {
        Poly p = Poly.builder()
                .x(viewer.inputInt(ShapeMessage.PROMPT_X))
                .y(viewer.inputInt(ShapeMessage.PROMPT_Y))
                .degree(viewer.inputInt(ShapeMessage.PROMPT_DEGREE))
                .sideLength(viewer.inputInt(ShapeMessage.PROMPT_SIDE_LENGTH))
                .build();

        System.out.println(pc.calcArea(p));
    }
}
