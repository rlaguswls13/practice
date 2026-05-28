package product.menu;

import lombok.AllArgsConstructor;
import lombok.Getter;
import product.ProductConstants;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public enum MenuOption {
    CREATE(1, "상품/스낵 등록", ProductMenu::handleCreate),
    READ(2, "상품/스낵 전체 조회", ProductMenu::handleRead),
    UPDATE(3, "상품/스낵 정보 수정", ProductMenu::handleUpdate),
    DELETE(4, "상품/스낵 정보 삭제", ProductMenu::handleDelete),
    EXIT(9, "메인으로", ProductMenu::handleExit);

    private final int code;
    private final String description;
    private final Consumer<ProductMenu> action;

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
                .forEach(opt -> System.out.printf("%d. %s%n", opt.getCode(), opt.getDescription()));
    }
}

