package product.type;

import lombok.Getter;
import product.ProductConstants;
import product.menu.ProductMenu;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum SelectConditionType {
    ALL(1, "전체", ProductMenu::handleSelectAll),
    BY_BRAND(2, "브랜드별", ProductMenu::handleSelectByBrand),
    BY_PRICE(3, "가격별", ProductMenu::handleSelectByPrice);

    @Getter
    private final int code;
    private final String description;
    private final Consumer<ProductMenu> action;

    SelectConditionType(int code, String description, Consumer<ProductMenu> action) {
        this.code = code;
        this.description = description;
        this.action = action;
    }

    public void execute(ProductMenu menu) {
        this.action.accept(menu);
    }

    private static final Map<Integer, SelectConditionType> BY_CODE = Arrays.stream(values())
            .collect(Collectors.toMap(SelectConditionType::getCode, Function.identity()));

    public static Optional<SelectConditionType> fromCode(int code) {
        return Optional.ofNullable(BY_CODE.get(code));
    }

    public static void displayMenu() {
        System.out.println(ProductConstants.SUB_MENU_HEADER);
        Arrays.stream(values())
                .forEach(opt -> System.out.printf("%d. %s%n", opt.code, opt.description));
    }
}
