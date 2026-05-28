package student.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import student.StudentConstants;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    private String name;
    private String subject;
    private int score;

    public String inform() {
        return String.format(StudentConstants.STUDENT_INFORM_FORMAT, name, subject, score);
    }
}
