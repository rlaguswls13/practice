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
public enum ProductQueryOption {
    ALL(1, "전체 조회"),
    BY_ID(2, "개별 조회 (상품 번호)"),
    BY_CATEGORY(3, "카테고리별 조회"),
    BY_BRAND(4, "브랜드/맛/품종별 조회"),
    BY_PRICE(5, "가격 기준 조회 (이하)"),
    EXIT(9, "이전으로");

    private final int code;
    private final String description;

    private static final Map<Integer, ProductQueryOption> BY_CODE = Arrays.stream(values())
            .collect(Collectors.toMap(ProductQueryOption::getCode, Function.identity()));

    public static Optional<ProductQueryOption> fromCode(int code) {
        return Optional.ofNullable(BY_CODE.get(code));
    }

    public static void displayMenu() {
        System.out.println("====== 상품 조회 설정 ======");
        Arrays.stream(values())
                .forEach(opt -> System.out.printf("%d. %s%n", opt.getCode(), opt.getDescription()));
    }
}

