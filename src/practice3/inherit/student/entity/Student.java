package practice3.inherit.student.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class Student {
    private final String name;
    private final int age;
    private final String grade;
}
