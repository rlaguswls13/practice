package practice3.inherit.student.controller;

import practice3.inherit.student.entity.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentController {
    private final List<Student> students = new ArrayList<>();
    private static final int MAX_CAPACITY = 10;

    public void addStudent(Student student) {
        if (students.size() >= MAX_CAPACITY) {
            throw new IllegalStateException("학생을 더 이상 등록할 수 없습니다. (최대 " + MAX_CAPACITY + "명)");
        }
        students.add(student);
    }

    public List<Student> getStudents() {
        return Collections.unmodifiableList(students);
    }
}
