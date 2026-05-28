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
    private Long id;
    private String name;
    private String subject;
    private Integer score; // -1 또는 null이면 미등록 상태로 취급

    public String inform() {
        String subjectStr = (subject == null || "없음".equals(subject)) ? "미등록" : subject;
        String scoreStr = (score == null || score == -1) ? "미등록" : String.valueOf(score) + "점";
        return String.format(StudentConstants.STUDENT_INFORM_FORMAT, id, name, subjectStr, scoreStr);
    }
}
