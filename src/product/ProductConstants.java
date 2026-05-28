package product;

public class ProductConstants {
    // 시스템 설정 제어 (이 값만 바꾸면 아래 메시지도 자동 변경됩니다)
    public static final int MAX_INVENTORY = 10;

    // UI 헤더 및 포맷
    public static final String MENU_HEADER = "====== 상품/스낵 관리 메뉴 ======";
    public static final String MSG_REGISTRATION_INTRO = "--- 등록할 종류 선택 ---";
    public static final String MSG_UPDATE_INTRO = "--- 수정할 정보 입력 ---";

    // 시스템 메시지
    public static final String MSG_EXIT = "상품/스낵 관리 프로그램을 종료합니다.";
    public static final String MSG_INVALID_INPUT = "잘못 입력하셨습니다. 다시 입력해주세요.\n";
    public static final String MSG_FULL_INVENTORY = "죄송합니다. 재고 관리 공간(" + MAX_INVENTORY + "칸)이 모두 가득 찼습니다.";
    public static final String MSG_INVALID_PRICE = "가격은 0원 이상이어야 하며, 숫자만 입력 가능합니다.";
    public static final String MSG_INVALID_NUM_OF = "개수는 0개 이상이어야 하며, 숫자만 입력 가능합니다.";

    // 알림 메시지
    public static final String MSG_REG_SUCCESS = "등록 완료되었습니다.";
    public static final String MSG_UPDATE_SUCCESS = "성공적으로 변경되었습니다.";
    public static final String MSG_DELETE_SUCCESS = "성공적으로 삭제되었습니다.";
    public static final String MSG_NOT_FOUND = "존재하지 않는 상품 번호입니다.";
    public static final String MSG_EMPTY_LIST = "등록된 상품/스낵이 없습니다.";

    // 프롬프트
    public static final String PROMPT_MENU_CHOICE = "메뉴 번호 선택 : ";
    public static final String PROMPT_REG_TYPE = "1. 일반 상품  2. 스낵  9. 이전으로 : ";
    public static final String PROMPT_ID = "상품 번호 입력 : ";
    public static final String PROMPT_KIND = "종류(과일/빵/가전 등) : ";
    public static final String PROMPT_NAME = "이름 : ";
    public static final String PROMPT_DETAIL = "브랜드(GENERAL)/맛(SNACK) : ";
    public static final String PROMPT_NUM_OF = "개수 : ";
    public static final String PROMPT_PRICE = "가격 : ";
}
