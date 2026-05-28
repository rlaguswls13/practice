package practice2.student;

public class StudentConstants {
    // UI 헤더 및 구분
    public static final String MENU_HEADER = "====== 학생 성적 관리 메뉴 ======";
    public static final String MSG_REGISTRATION_INTRO = "--- 학생 등록 ---";
    public static final String MSG_SCORE_REGISTRATION_INTRO = "--- 성적 등록/변경 ---";

    // 포맷 문자열
    public static final String STUDENT_INFORM_FORMAT = "학번 : %d / 이름 : %s / 과목 : %s / 점수 : %s";
    public static final String FORMAT_RESULT = "학번 : %d / 이름 : %s / 점수 : %d / 결과 : %s%n";

    // 결과 및 에러 문구
    public static final String RESULT_PASS = "통과";
    public static final String RESULT_FAIL = "재시험 대상";
    public static final String MSG_REG_SUCCESS = "학생이 성공적으로 등록되었습니다.";
    public static final String MSG_SCORE_REG_SUCCESS = "성적이 성공적으로 등록/변경되었습니다.";
    public static final String MSG_SCORE_DEL_SUCCESS = "성적이 성공적으로 삭제되었습니다.";
    public static final String MSG_DEL_SUCCESS = "학생 정보가 삭제되었습니다.";
    public static final String MSG_NOT_FOUND = "존재하지 않는 학생 번호(학번)입니다.";
    public static final String MSG_EMPTY_LIST = "등록된 학생 정보가 없습니다.";
    public static final String MSG_INVALID_INPUT = "잘못 입력하셨습니다. 다시 입력해주세요.\n";
    public static final String MSG_INVALID_SCORE = "점수는 0점 이상 100점 이하로만 입력 가능합니다.";

    // 프롬프트
    public static final String PROMPT_MENU_CHOICE = "메뉴 번호 선택 : ";
    public static final String PROMPT_QUERY_CHOICE = "1. 전체 조회  2. 이름 검색  3. 학번 검색  9. 이전으로 : ";
    public static final String PROMPT_STUDENT_ID = "학생 번호(학번) 입력 : ";
    public static final String PROMPT_NAME = "이름 : ";
    public static final String PROMPT_SUBJECT = "과목명 : ";
    public static final String PROMPT_SCORE = "점수 : ";
}
