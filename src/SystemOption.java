import product.menu.ProductMenu;
import student.menu.StudentMenu;
import snack.menu.SnackMenu;
import shape.menu.ShapeMenu;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum SystemOption {
    PRODUCT(1, "상품 재고 관리 시스템", () -> {
        ProductMenu productMenu = new ProductMenu();
        productMenu.mainMenu();
    }),
    STUDENT(2, "학생 성적 관리 시스템", StudentMenu::new),
    SNACK(3, "스낵 관리 시스템", () -> {
        SnackMenu snackMenu = new SnackMenu();
        snackMenu.menu();
    }),
    SHAPE(4, "도형 구현 시스템", () -> {
        ShapeMenu shapeMenu = new ShapeMenu();
        shapeMenu.inputMenu();
    }),
    EXIT(9, "종료", () -> System.out.println(SystemConstants.MSG_EXIT));

    private final int code;
    private final String description;
    private final Runnable action;

    SystemOption(int code, String description, Runnable action) {
        this.code = code;
        this.description = description;
        this.action = action;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public void execute() {
        this.action.run();
    }

    private static final Map<Integer, SystemOption> BY_CODE = Arrays.stream(values())
            .collect(Collectors.toMap(SystemOption::getCode, Function.identity()));

    public static Optional<SystemOption> fromCode(int code) {
        return Optional.ofNullable(BY_CODE.get(code));
    }

    public static void displayMenu() {
        System.out.println(SystemConstants.HEADER_SYSTEM);
        Arrays.stream(values())
                .forEach(opt -> System.out.printf("%d. %s%n", opt.code, opt.description));
    }
}
