package practice3.inherit.shape.menu.options;

import lombok.AllArgsConstructor;
import lombok.Getter;
import practice3.inherit.common.menu.MenuOption;

import java.util.Arrays;
import java.util.Optional;

@Getter
@AllArgsConstructor
public enum ShapeMenuOption implements MenuOption {
    CIRCLE(1, "원"),
    RECTANGLE(2, "사각형"),
    TRIANGLE(3, "삼각형"),
    POLY(4, "다각형"),
    MAIN(9, "이전으로");

    private final int code;
    private final String description;

    public static Optional<ShapeMenuOption> fromCode(int code) {
        return Arrays.stream(values())
                .filter(opt -> opt.code == code)
                .findFirst();
    }
}
