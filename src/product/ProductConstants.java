package product;

public class ProductConstants {
    // 시스템 설정 제어 (이 값만 바꾸면 아래 메시지도 자동 변경됩니다)
    public static final int MAX_INVENTORY = 10;

    // UI 헤더 및 포맷
    public static final String MENU_HEADER = "====== 상품 관리 메뉴 ======";
    public static final String SUB_MENU_HEADER = "====== 상품 조회 설정 ======";
    public static final String PRODUCT_INFORM_FORMAT = "상품명 : %s / 가격 : %d / 브랜드 : %s";

    // 시스템 메시지
    public static final String MSG_EXIT = "상품 관리 프로그램을 종료합니다.";
    public static final String MSG_INVALID_INPUT = "잘못 입력하셨습니다. 다시 입력해주세요.\n";

    // 리팩토링: MAX_INVENTORY 상수를 직접 결합하여 변경에 동적으로 대응
    public static final String MSG_FULL_INVENTORY = "죄송합니다. 재고 관리 공간(" + MAX_INVENTORY + "칸)이 모두 가득 찼습니다.";
    public static final String MSG_INVALID_PRICE = "가격은 0원 이상이어야 하며, 숫자만 입력 가능합니다.";
}
