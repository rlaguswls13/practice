package practice2.student.menu;

import practice2.student.StudentConstants;
import practice2.student.controller.StudentController;
import practice2.student.entity.Student;

import java.util.List;
import java.util.Scanner;

public class StudentMenu {
    private final StudentController controller = new StudentController();
    private final Scanner scanner = new Scanner(System.in);
    private boolean isRunning = true;

    public StudentMenu() {
        mainMenu();
    }

    private void mainMenu() {
        this.isRunning = true;
        while (isRunning) {
            System.out.println(StudentConstants.MENU_HEADER);
            System.out.println("1. 학생 등록");
            System.out.println("2. 학생 성적 등록/변경");
            System.out.println("3. 학생 성적 삭제");
            System.out.println("4. 학생 성적 조회");
            System.out.println("5. 학생 정보 삭제");
            System.out.println("9. 메인으로");
            System.out.print(StudentConstants.PROMPT_MENU_CHOICE);

            int choice = readIntegerInput();
            System.out.println();
            processCommand(choice);
        }
    }

    private int readIntegerInput() {
        try {
            int value = scanner.nextInt();
            scanner.nextLine(); // 버퍼 비우기
            return value;
        } catch (Exception e) {
            scanner.nextLine(); // 버퍼 비우기
            return -1;
        }
    }

    private Long readLongInput() {
        try {
            Long value = scanner.nextLong();
            scanner.nextLine(); // 버퍼 비우기
            return value;
        } catch (Exception e) {
            scanner.nextLine(); // 버퍼 비우기
            return -1L;
        }
    }

    private int readValidScore(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int score = scanner.nextInt();
                scanner.nextLine(); // 버퍼 비우기
                if (score < 0 || score > 100) {
                    System.out.println(StudentConstants.MSG_INVALID_SCORE);
                    continue;
                }
                return score;
            } catch (Exception e) {
                System.out.println(StudentConstants.MSG_INVALID_SCORE);
                scanner.nextLine(); // 버퍼 비우기
            }
        }
    }

    private void processCommand(int choice) {
        if (choice == 1) {
            handleRegisterStudent();
        } else if (choice == 2) {
            handleRegisterScore();
        } else if (choice == 3) {
            handleDeleteScore();
        } else if (choice == 4) {
            handleSelectScore();
        } else if (choice == 5) {
            handleDeleteStudent();
        } else if (choice == 9) {
            this.isRunning = false;
        } else {
            System.out.println(StudentConstants.MSG_INVALID_INPUT);
        }
    }

    private void handleRegisterStudent() {
        System.out.println(StudentConstants.MSG_REGISTRATION_INTRO);
        System.out.print(StudentConstants.PROMPT_NAME);
        String name = scanner.nextLine();

        controller.registerStudent(name);
        System.out.println(StudentConstants.MSG_REG_SUCCESS + "\n");
    }

    private void handleRegisterScore() {
        System.out.println(StudentConstants.MSG_SCORE_REGISTRATION_INTRO);
        System.out.print(StudentConstants.PROMPT_STUDENT_ID);
        Long id = readLongInput();

        try {
            // 학생이 존재하는지 먼저 확인
            controller.selectStudentById(id);

            System.out.print(StudentConstants.PROMPT_SUBJECT);
            String subject = scanner.nextLine();

            int score = readValidScore(StudentConstants.PROMPT_SCORE);

            controller.registerScore(id, subject, score);
            System.out.println(StudentConstants.MSG_SCORE_REG_SUCCESS + "\n");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "\n");
        }
    }

    private void handleDeleteScore() {
        System.out.print(StudentConstants.PROMPT_STUDENT_ID);
        Long id = readLongInput();

        try {
            controller.deleteScore(id);
            System.out.println(StudentConstants.MSG_SCORE_DEL_SUCCESS + "\n");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "\n");
        }
    }

    private void handleDeleteStudent() {
        System.out.print(StudentConstants.PROMPT_STUDENT_ID);
        Long id = readLongInput();

        try {
            controller.deleteStudent(id);
            System.out.println(StudentConstants.MSG_DEL_SUCCESS + "\n");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "\n");
        }
    }

    private void handleSelectScore() {
        while (true) {
            System.out.print(StudentConstants.PROMPT_QUERY_CHOICE);
            int choice = readIntegerInput();
            System.out.println();

            if (choice == 9) {
                break;
            }

            if (choice == 1) {
                List<Student> students = controller.selectStudentAll();
                displayStudents(students);
                break;
            } else if (choice == 2) {
                System.out.print(StudentConstants.PROMPT_NAME);
                String name = scanner.nextLine();
                List<Student> students = controller.selectStudentByName(name);
                displayStudents(students);
                break;
            } else if (choice == 3) {
                System.out.print(StudentConstants.PROMPT_STUDENT_ID);
                Long id = readLongInput();
                try {
                    Student student = controller.selectStudentById(id);
                    System.out.println(student.inform());
                    System.out.println();
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage() + "\n");
                }
                break;
            } else {
                System.out.println(StudentConstants.MSG_INVALID_INPUT);
            }
        }
    }

    private void displayStudents(List<Student> students) {
        if (students.isEmpty()) {
            System.out.println(StudentConstants.MSG_EMPTY_LIST + "\n");
            return;
        }
        System.out.println("--- 조회된 학생 목록 ---");
        students.forEach(s -> System.out.println(s.inform()));
        System.out.println();
    }
}
