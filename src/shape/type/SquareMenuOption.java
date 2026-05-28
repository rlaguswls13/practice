package shape.type;

import shape.ShapeConstants;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum SquareMenuOption {
    PERIMETER(1, ShapeConstants.OPTION_SUB_SQUARE_PERIMETER),
    AREA(2, ShapeConstants.OPTION_SUB_SQUARE_AREA),
    PAINT(3, ShapeConstants.OPTION_SUB_SQUARE_PAINT),
    INFO(4, ShapeConstants.OPTION_SUB_SQUARE_INFO),
    EXIT(9, ShapeConstants.OPTION_SUB_RETURN);

    private final int code;
    private final String description;

    SquareMenuOption(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    private static final Map<Integer, SquareMenuOption> BY_CODE = Arrays.stream(values())
            .collect(Collectors.toMap(SquareMenuOption::getCode, Function.identity()));

    public static Optional<SquareMenuOption> fromCode(int code) {
        return Optional.ofNullable(BY_CODE.get(code));
    }

    public static void displayMenu() {
        System.out.println(ShapeConstants.HEADER_SQUARE_MENU);
        Arrays.stream(values())
                .forEach(opt -> System.out.println(opt.getDescription()));
    }
}
