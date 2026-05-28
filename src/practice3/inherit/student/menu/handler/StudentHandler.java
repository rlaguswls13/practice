package practice3.inherit.student.menu.handler;

import practice3.inherit.common.utils.InputView;
import practice3.inherit.student.controller.StudentController;
import practice3.inherit.student.entity.Student;

import java.util.List;

public record StudentHandler(StudentController sc, InputView viewer) {

    public void handleRegister() {
        try {
            String name = viewer.inputString("이름 : ");
            int age = viewer.inputInt("나이 : ");
            String grade = viewer.inputString("학년 : ");

            Student s = Student.builder()
                    .name(name)
                    .age(age)
                    .grade(grade)
                    .build();

            sc.addStudent(s);
            System.out.println("학생 등록 성공!");
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    public void handleList() {
        List<Student> students = sc.getStudents();
        if (students.isEmpty()) {
            System.out.println("등록된 학생이 없습니다.");
            return;
        }

        System.out.println("===== 학생 목록 =====");
        students.forEach(s -> System.out.printf("이름: %s, 나이: %d, 학년: %s%n", s.getName(), s.getAge(), s.getGrade()));
    }
}
