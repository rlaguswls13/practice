package practice2.shape;

public class ShapeConstants {
    // 메뉴 헤더
    public static final String HEADER_SHAPE_MENU = "===== 도형 프로그램 =====";

    // 메뉴 옵션
    public static final String OPTION_INPUT_INFO = "정각형 정보 입력 및 출력";
    public static final String OPTION_PAINT_COLOR = "도형 색상 변경";
    public static final String OPTION_EXIT = "메인으로";

    // 결과 출력 템플릿
    public static final String MSG_PERIMETER_RESULT = "정%d각형 둘레 : %.2f%n";
    public static final String MSG_AREA_RESULT = "정%d각형 넓이 : %.2f%n";
    public static final String MSG_PAINT_SUCCESS = "색칠 완료되었습니다.";
    public static final String MSG_SHAPE_INFO = "정%d각형 [변의 개수: %d, 한 변의 길이: %.2f, 색상: %s]";

    // 프롬프트
    public static final String PROMPT_MENU_CHOICE = "도형 번호 선택 : ";
    public static final String PROMPT_NUM_SIDES = "몇각형 정보를 확인하시겠습니까? (3 이상) : ";
    public static final String PROMPT_SIDE_LENGTH = "한 변의 길이 입력 (0보다 큰 수) : ";
    public static final String PROMPT_COLOR = "색칠할 색상 : ";

    // 에러 메시지
    public static final String MSG_INVALID_CHOICE = "잘못 선택하셨습니다. 다시 선택해주세요.\n";
    public static final String MSG_PARSE_ERROR = "잘못 입력하셨습니다. 숫자만 입력해주세요.";
    public static final String MSG_NUM_SIDES_ERROR = "도형은 최소 3각형(3) 이상이어야 합니다.";
    public static final String MSG_SIDE_LENGTH_ERROR = "변의 길이는 0보다 커야 합니다.";
}
