package practice2.shape.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import practice2.shape.ShapeConstants;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public enum ShapeMenuOption {
    INPUT_INFO(1, ShapeConstants.OPTION_INPUT_INFO),
    PAINT_COLOR(2, ShapeConstants.OPTION_PAINT_COLOR),
    EXIT(9, ShapeConstants.OPTION_EXIT);

    private final int code;
    private final String description;

    private static final Map<Integer, ShapeMenuOption> BY_CODE = Arrays.stream(values())
            .collect(Collectors.toMap(ShapeMenuOption::getCode, Function.identity()));

    public static Optional<ShapeMenuOption> fromCode(int code) {
        return Optional.ofNullable(BY_CODE.get(code));
    }

    public static void displayMenu() {
        System.out.println(ShapeConstants.HEADER_SHAPE_MENU);
        Arrays.stream(values())
                .forEach(opt -> System.out.printf("%d. %s%n", opt.getCode(), opt.getDescription()));
    }
}

