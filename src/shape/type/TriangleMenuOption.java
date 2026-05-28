package shape.type;

import shape.ShapeConstants;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum TriangleMenuOption {
    AREA(1, ShapeConstants.OPTION_SUB_TRIANGLE_AREA),
    PAINT(2, ShapeConstants.OPTION_SUB_TRIANGLE_PAINT),
    INFO(3, ShapeConstants.OPTION_SUB_TRIANGLE_INFO),
    EXIT(9, ShapeConstants.OPTION_SUB_RETURN);

    private final int code;
    private final String description;

    TriangleMenuOption(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    private static final Map<Integer, TriangleMenuOption> BY_CODE = Arrays.stream(values())
            .collect(Collectors.toMap(TriangleMenuOption::getCode, Function.identity()));

    public static Optional<TriangleMenuOption> fromCode(int code) {
        return Optional.ofNullable(BY_CODE.get(code));
    }

    public static void displayMenu() {
        System.out.println(ShapeConstants.HEADER_TRIANGLE_MENU);
        Arrays.stream(values())
                .forEach(opt -> System.out.println(opt.getDescription()));
    }
}
