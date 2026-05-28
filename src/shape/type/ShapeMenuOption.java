package shape.type;

import shape.ShapeConstants;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum ShapeMenuOption {
    INPUT_INFO(1, ShapeConstants.OPTION_INPUT_INFO),
    PAINT_COLOR(2, ShapeConstants.OPTION_PAINT_COLOR),
    EXIT(9, ShapeConstants.OPTION_EXIT);

    private final int code;
    private final String description;

    ShapeMenuOption(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    private static final Map<Integer, ShapeMenuOption> BY_CODE = Arrays.stream(values())
            .collect(Collectors.toMap(ShapeMenuOption::getCode, Function.identity()));

    public static Optional<ShapeMenuOption> fromCode(int code) {
        return Optional.ofNullable(BY_CODE.get(code));
    }

    public static void displayMenu() {
        System.out.println(ShapeConstants.HEADER_SHAPE_MENU);
        Arrays.stream(values())
                .forEach(opt -> System.out.printf("%d. %s%n", opt.code, opt.description));
    }
}
