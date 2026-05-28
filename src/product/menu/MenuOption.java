package product.menu;

import lombok.Getter;
import product.ProductConstants;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum MenuOption {
    INSERT(1, "상품 추가", ProductMenu::handleInsertProduct),
    SELECT(2, "상품 전체 조회", ProductMenu::handleSelectAllProducts),
    EXIT(9, "프로그램 종료", ProductMenu::handleExit);

    @Getter
    private final int code;
    private final String description;
    private final Consumer<ProductMenu> action;

    MenuOption(int code, String description, Consumer<ProductMenu> action) {
        this.code = code;
        this.description = description;
        this.action = action;
    }

    public void execute(ProductMenu menu) {
        this.action.accept(menu);
    }

    private static final Map<Integer, MenuOption> BY_CODE = Arrays.stream(values())
            .collect(Collectors.toMap(MenuOption::getCode, Function.identity()));

    public static Optional<MenuOption> fromCode(int code) {
        return Optional.ofNullable(BY_CODE.get(code));
    }

    public static void displayMenu() {
        System.out.println(ProductConstants.MENU_HEADER);
        Arrays.stream(values())
                .forEach(opt -> System.out.printf("%d. %s%n", opt.code, opt.description));
    }
}
