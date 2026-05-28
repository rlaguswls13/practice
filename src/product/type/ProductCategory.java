package product.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public enum ProductCategory {
    GENERAL(1, "일반상품 (GENERAL)"),
    SNACK(2, "스낵류 (SNACK)"),
    FRUIT(3, "과일류 (FRUIT)");

    private final int code;
    private final String description;

    private static final Map<Integer, ProductCategory> BY_CODE = Arrays.stream(values())
            .collect(Collectors.toMap(ProductCategory::getCode, Function.identity()));

    public static Optional<ProductCategory> fromCode(int code) {
        return Optional.ofNullable(BY_CODE.get(code));
    }

    public static void displayMenu() {
        System.out.println("--- 등록할 카테고리 선택 ---");
        Arrays.stream(values())
                .forEach(opt -> System.out.printf("%d. %s%n", opt.getCode(), opt.getDescription()));
        System.out.println("9. 이전으로");
    }
}
