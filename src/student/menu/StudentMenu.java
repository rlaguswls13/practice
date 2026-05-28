package student.menu;

import student.StudentConstants;
import student.controller.StudentController;
import student.entity.Student;

import java.util.Arrays;

public class StudentMenu {
    private final StudentController ssm = new StudentController();

    public StudentMenu() {
        printStudentInfo();
        printStudentPerformance();
        printPassFailResults();
    }

    private void printStudentInfo() {
        System.out.println(StudentConstants.MENU_HEADER_STUDENT_INFO);
        Arrays.stream(ssm.printStudent())
                .map(Student::inform)
                .forEach(System.out::println);
        System.out.println();
    }

    private void printStudentPerformance() {
        System.out.println(StudentConstants.MENU_HEADER_STUDENT_SCORE);
        double[] scores = ssm.avgScore();
        System.out.printf(StudentConstants.FORMAT_SUM, (int) scores[0]);
        System.out.printf(StudentConstants.FORMAT_AVG, scores[1]);
        System.out.println();
    }

    private void printPassFailResults() {
        System.out.println(StudentConstants.MENU_HEADER_PASS_FAIL);
        Arrays.stream(ssm.printStudent())
                .forEach(student -> {
                    String result = student.getScore() < StudentController.CUT_LINE
                            ? StudentConstants.RESULT_FAIL
                            : StudentConstants.RESULT_PASS;
                    System.out.printf(StudentConstants.FORMAT_RESULT, student.getName(), result);
                });
        System.out.println();
    }
}
