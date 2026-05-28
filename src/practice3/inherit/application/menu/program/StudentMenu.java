package practice3.inherit.application.menu.program;

import lombok.RequiredArgsConstructor;
import practice3.inherit.common.menu.MenuRunner;
import practice3.inherit.student.menu.handler.StudentHandler;
import practice3.inherit.student.menu.options.StudentMenuOption;

@RequiredArgsConstructor
public class StudentMenu {

    private final MenuRunner menuRunner;
    private final StudentHandler studentHandler;

    public void runStudentMenu() {
        while (true) {
            StudentMenuOption menu = menuRunner.runMenu(
                    "===== 학생 관리 시스템 =====",
                    StudentMenuOption.class,
                    StudentMenuOption::fromCode);

            if (menu == StudentMenuOption.MAIN) {
                return;
            }

            handleStudentSelection(menu);
        }
    }

    private void handleStudentSelection(StudentMenuOption menu) {
        switch (menu) {
            case REGISTER:
                studentHandler.handleRegister();
                break;
            case LIST:
                studentHandler.handleList();
                break;
            default:
                break;
        }
    }
}
