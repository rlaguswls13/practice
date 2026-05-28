package shape;

public class ShapeConstants {
    // 도형 명칭 및 구분
    public static final String PREFIX_SQUARE = "사각형 ";
    public static final String PREFIX_TRIANGLE = "삼각형 ";

    // 메뉴 헤더
    public static final String HEADER_MAIN_MENU = "===== 도형 프로그램 =====";
    public static final String HEADER_TRIANGLE_MENU = "===== 삼각형 =====";
    public static final String HEADER_SQUARE_MENU = "===== 사각형 =====";

    // 메뉴 옵션 문구
    public static final String OPTION_MAIN_TRIANGLE = "1. 삼각형";
    public static final String OPTION_MAIN_SQUARE = "2. 사각형";
    public static final String OPTION_MAIN_EXIT = "9. 메인으로";

    public static final String OPTION_SUB_TRIANGLE_AREA = "1. 삼각형 면적 계산";
    public static final String OPTION_SUB_TRIANGLE_PAINT = "2. 삼각형 색칠";
    public static final String OPTION_SUB_TRIANGLE_INFO = "3. 삼각형 정보 보기";
    public static final String OPTION_SUB_RETURN = "9. 메인으로";

    public static final String OPTION_SUB_SQUARE_PERIMETER = "1. 사각형 둘레 계산";
    public static final String OPTION_SUB_SQUARE_AREA = "2. 사각형 면적 계산";
    public static final String OPTION_SUB_SQUARE_PAINT = "3. 사각형 색칠";
    public static final String OPTION_SUB_SQUARE_INFO = "4. 사각형 정보 보기";

    // 결과 출력 템플릿
    public static final String MSG_TRIANGLE_AREA_RESULT = "삼각형 면적 : %.1f%n";
    public static final String MSG_SQUARE_PERIMETER_RESULT = "사각형 둘레 : %.1f%n";
    public static final String MSG_SQUARE_AREA_RESULT = "사각형 면적 : %.1f%n";
    public static final String MSG_PAINT_SUCCESS = "색칠 완료되었습니다.";

    // 프롬프트
    public static final String PROMPT_SHAPE_CHOICE = "도형 번호 선택 : ";
    public static final String PROMPT_MENU_CHOICE = "메뉴 번호 선택 : ";
    public static final String PROMPT_HEIGHT = "높이 : ";
    public static final String PROMPT_WIDTH = "너비 : ";
    public static final String PROMPT_COLOR = "색칠할 색상 : ";

    // 에러 메시지
    public static final String MSG_INVALID_CHOICE = "잘못 선택하셨습니다. 다시 선택해주세요.\n";
    public static final String MSG_PARSE_ERROR = "잘못 입력하셨습니다. 숫자만 입력해주세요.";
    public static final String MSG_NEGATIVE_ERROR = "0보다 커야 합니다. 다시 입력해주세요.";
}
