package practice3.inherit.application.config;

import practice3.inherit.application.menu.ProgramSelector;
import practice3.inherit.application.menu.program.ShapeMenu;
import practice3.inherit.application.menu.program.StudentMenu;
import practice3.inherit.common.menu.MenuRunner;
import practice3.inherit.common.utils.InputView;
import practice3.inherit.shape.controller.CircleController;
import practice3.inherit.shape.controller.PolyController;
import practice3.inherit.shape.controller.RectangleController;
import practice3.inherit.shape.controller.TriangleController;
import practice3.inherit.shape.menu.handler.CircleHandler;
import practice3.inherit.shape.menu.handler.PolyHandler;
import practice3.inherit.shape.menu.handler.RectangleHandler;
import practice3.inherit.shape.menu.handler.TriangleHandler;
import practice3.inherit.student.controller.StudentController;
import practice3.inherit.student.menu.handler.StudentHandler;

import java.util.Scanner;

/**
 * Spring 컨테이너를 대체하는 순수 자바 DI(의존성 주입) 설정 클래스
 */
public class AppConfig {

    public ProgramSelector programSelector() {
        return new ProgramSelector(menuRunner(), shapeMenu(), studentMenu());
    }

    public ShapeMenu shapeMenu() {
        return new ShapeMenu(
                menuRunner(),
                circleHandler(),
                rectangleHandler(),
                triangleHandler(),
                polyHandler()
        );
    }

    public StudentMenu studentMenu() {
        return new StudentMenu(menuRunner(), studentHandler());
    }

    // ==========================================
    // Student Domain
    // ==========================================
    public StudentHandler studentHandler() {
        return new StudentHandler(studentController(), inputView());
    }

    public StudentController studentController() {
        return new StudentController();
    }

    // ==========================================
    // Shape Domain
    // ==========================================
    public CircleHandler circleHandler() {
        return new CircleHandler(circleController(), inputView());
    }

    public CircleController circleController() {
        return new CircleController();
    }

    public RectangleHandler rectangleHandler() {
        return new RectangleHandler(rectangleController(), inputView());
    }

    public RectangleController rectangleController() {
        return new RectangleController();
    }

    public TriangleHandler triangleHandler() {
        return new TriangleHandler(triangleController(), inputView());
    }

    public TriangleController triangleController() {
        return new TriangleController();
    }

    public PolyHandler polyHandler() {
        return new PolyHandler(polyController(), inputView());
    }

    public PolyController polyController() {
        return new PolyController();
    }

    // ==========================================
    // Common Infrastructure
    // ==========================================
    public MenuRunner menuRunner() {
        return new MenuRunner(inputView());
    }

    public InputView inputView() {
        return new InputView(scanner());
    }

    public Scanner scanner() {
        return new Scanner(System.in);
    }
}
