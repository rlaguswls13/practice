package practice2.student.controller;

import practice2.student.StudentConstants;
import practice2.student.entity.Student;
import practice2.student.repository.StudentRepository;

import java.util.List;

public class StudentController {
    private final StudentRepository repository = new StudentRepository();

    public StudentController() {
        // 샘플 데이터 초기화 (Lombok 빌더 활용)
        repository.save(Student.builder().name("김길동").subject("자바").score(100).build());
        repository.save(Student.builder().name("박길동").subject("디비").score(50).build());
        repository.save(Student.builder().name("이길동").subject("화면").score(85).build());
        repository.save(Student.builder().name("정길동").subject("서버").score(60).build());
        repository.save(Student.builder().name("홍길동").subject("자바").score(20).build());
    }

    public void registerStudent(String name) {
        Student student = Student.builder()
                .name(name)
                .subject("없음")
                .score(-1)
                .build();
        repository.save(student);
    }

    public void registerScore(Long id, String subject, int score) {
        Student student = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(StudentConstants.MSG_NOT_FOUND));

        student.setSubject(subject);
        student.setScore(score);
        repository.save(student);
    }

    public void deleteScore(Long id) {
        Student student = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(StudentConstants.MSG_NOT_FOUND));

        student.setSubject("없음");
        student.setScore(-1);
        repository.save(student);
    }

    public void deleteStudent(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(StudentConstants.MSG_NOT_FOUND));
        repository.delete(id);
    }

    public List<Student> selectStudentAll() {
        return repository.findAll();
    }

    public List<Student> selectStudentByName(String name) {
        return repository.findByName(name);
    }

    public Student selectStudentById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(StudentConstants.MSG_NOT_FOUND));
    }
}
