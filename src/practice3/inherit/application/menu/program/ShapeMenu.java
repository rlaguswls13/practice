package practice3.inherit.application.menu.program;

import lombok.RequiredArgsConstructor;
import practice3.inherit.application.constant.MainMessage;
import practice3.inherit.common.menu.MenuRunner;
import practice3.inherit.shape.constant.ShapeMessage;
import practice3.inherit.shape.menu.handler.*;
import practice3.inherit.shape.menu.options.*;

@RequiredArgsConstructor
public class ShapeMenu {

    private final MenuRunner menuRunner;
    private final CircleHandler circleHandler;
    private final RectangleHandler rectangleHandler;
    private final TriangleHandler triangleHandler;
    private final PolyHandler polyHandler;

    public void runShapeMenu() {
        while (true) {
            ShapeMenuOption menu = menuRunner.runMenu(
                    MainMessage.MENU_SHAPE,
                    ShapeMenuOption.class,
                    ShapeMenuOption::fromCode);

            if (menu == ShapeMenuOption.MAIN) {
                return;
            }

            handleShapeSelection(menu);
        }
    }

    private void handleShapeSelection(ShapeMenuOption menu) {
        switch (menu) {
            case CIRCLE:
                circleMenu();
                break;
            case RECTANGLE:
                rectangleMenu();
                break;
            case TRIANGLE:
                triangleMenu();
                break;
            case POLY:
                polyMenu();
                break;
            default:
                break;
        }
    }

    private void circleMenu() {
        while (true) {
            CircleMenuOption menu = menuRunner.runMenu(
                    ShapeMessage.HEADER_CIRCLE,
                    CircleMenuOption.class,
                    CircleMenuOption::fromCode);

            if (menu == CircleMenuOption.MAIN) {
                return;
            }

            executeCircleAction(menu);
        }
    }

    private void executeCircleAction(CircleMenuOption menu) {
        switch (menu) {
            case CIRCUM:
                circleHandler.handlePerimeter();
                break;
            case AREA:
                circleHandler.handleArea();
                break;
            default:
                break;
        }
    }

    private void rectangleMenu() {
        while (true) {
            RectangleMenuOption menu = menuRunner.runMenu(
                    ShapeMessage.HEADER_RECTANGLE,
                    RectangleMenuOption.class,
                    RectangleMenuOption::fromCode);

            if (menu == RectangleMenuOption.MAIN) {
                return;
            }

            executeRectangleAction(menu);
        }
    }

    private void executeRectangleAction(RectangleMenuOption menu) {
        switch (menu) {
            case PERIMETER:
                rectangleHandler.handlePerimeter();
                break;
            case AREA:
                rectangleHandler.handleArea();
                break;
            default:
                break;
        }
    }

    private void triangleMenu() {
        while (true) {
            TriangleMenuOption menu = menuRunner.runMenu(
                    ShapeMessage.HEADER_TRIANGLE,
                    TriangleMenuOption.class,
                    TriangleMenuOption::fromCode);

            if (menu == TriangleMenuOption.MAIN) {
                return;
            }

            executeTriangleAction(menu);
        }
    }

    private void executeTriangleAction(TriangleMenuOption menu) {
        switch (menu) {
            case CIRCUM:
                triangleHandler.handlePerimeter();
                break;
            case AREA:
                triangleHandler.handleArea();
                break;
            default:
                break;
        }
    }

    private void polyMenu() {
        while (true) {
            PolyMenuOption menu = menuRunner.runMenu(
                    ShapeMessage.HEADER_POLY,
                    PolyMenuOption.class,
                    PolyMenuOption::fromCode);

            if (menu == PolyMenuOption.MAIN) {
                return;
            }

            executePolyAction(menu);
        }
    }

    private void executePolyAction(PolyMenuOption menu) {
        switch (menu) {
            case CIRCUM:
                polyHandler.handlePerimeter();
                break;
            case AREA:
                polyHandler.handleArea();
                break;
            default:
                break;
        }
    }
}
