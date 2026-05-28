package practice3.inherit.application.menu;

import lombok.RequiredArgsConstructor;
import practice3.inherit.application.constant.MainMessage;
import practice3.inherit.application.menu.options.MainMenuOption;
import practice3.inherit.application.menu.program.ShapeMenu;
import practice3.inherit.application.menu.program.StudentMenu;
import practice3.inherit.common.menu.MenuRunner;

@RequiredArgsConstructor
public class ProgramSelector {

    private final MenuRunner menuRunner;
    private final ShapeMenu shapeMenu;
    private final StudentMenu studentMenu;

    public void mainMenu() {
        while (true) {
            MainMenuOption menu = menuRunner.runMenu(
                    MainMessage.HEADER_MAIN,
                    MainMenuOption.class,
                    MainMenuOption::fromCode);

            if (menu == MainMenuOption.EXIT) {
                System.out.println(MainMessage.MSG_EXIT);
                return;
            }

            if (menu == MainMenuOption.SHAPE) {
                shapeMenu.runShapeMenu();
            } else if (menu == MainMenuOption.STUDENT) {
                studentMenu.runStudentMenu();
            }
        }
    }
}
