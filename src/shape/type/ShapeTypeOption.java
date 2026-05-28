package shape.type;

import shape.ShapeConstants;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum ShapeTypeOption {
    TRIANGLE(1, ShapeConstants.OPTION_MAIN_TRIANGLE),
    SQUARE(2, ShapeConstants.OPTION_MAIN_SQUARE),
    EXIT(9, ShapeConstants.OPTION_MAIN_EXIT);

    private final int code;
    private final String description;

    ShapeTypeOption(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    private static final Map<Integer, ShapeTypeOption> BY_CODE = Arrays.stream(values())
            .collect(Collectors.toMap(ShapeTypeOption::getCode, Function.identity()));

    public static Optional<ShapeTypeOption> fromCode(int code) {
        return Optional.ofNullable(BY_CODE.get(code));
    }

    public static void displayMenu() {
        System.out.println(ShapeConstants.HEADER_MAIN_MENU);
        Arrays.stream(values())
                .forEach(opt -> System.out.println(opt.getDescription()));
    }
}
