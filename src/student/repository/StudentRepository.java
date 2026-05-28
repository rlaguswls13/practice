package student.repository;

import student.entity.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class StudentRepository {
    private final Map<Long, Student> store = new ConcurrentHashMap<>();
    private final AtomicLong sequence = new AtomicLong(1L);

    public Student save(Student student) {
        if (student.getId() == null) {
            student.setId(sequence.getAndIncrement());
        }
        store.put(student.getId(), student);
        return student;
    }

    public Optional<Student> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    public List<Student> findByName(String name) {
        return store.values().stream()
                .filter(s -> s.getName().contains(name.trim()))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Student> findAll() {
        return Collections.unmodifiableList(new ArrayList<>(store.values()));
    }

    public void delete(Long id) {
        store.remove(id);
    }

    public void clear() {
        store.clear();
    }
}
