package student.controller;

import student.entity.Student;

import java.util.Arrays;

public class StudentController {
    private final Student[] sArr = new Student[5];
    public static final int CUT_LINE = 60;

    public StudentController() {
        sArr[0] = Student.builder().name("김길동").subject("자바").score(100).build();
        sArr[1] = Student.builder().name("박길동").subject("디비").score(50).build();
        sArr[2] = Student.builder().name("이길동").subject("화면").score(85).build();
        sArr[3] = Student.builder().name("정길동").subject("서버").score(60).build();
        sArr[4] = Student.builder().name("홍길동").subject("자바").score(20).build();
    }

    public Student[] printStudent() {
        return sArr.clone();
    }

    public int sumScore() {
        return Arrays.stream(sArr)
                .mapToInt(Student::getScore)
                .sum();
    }

    public double[] avgScore() {
        double sum = sumScore();
        double avg = sum / sArr.length;
        return new double[]{sum, avg};
    }
}
