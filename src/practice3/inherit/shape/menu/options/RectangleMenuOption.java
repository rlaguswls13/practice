package practice3.inherit.shape.menu.options;

import lombok.AllArgsConstructor;
import lombok.Getter;
import practice3.inherit.common.menu.MenuOption;

import java.util.Arrays;
import java.util.Optional;

@Getter
@AllArgsConstructor
public enum RectangleMenuOption implements MenuOption {
    PERIMETER(1, "사각형 둘레"),
    AREA(2, "사각형 넓이"),
    MAIN(9, "이전으로");

    private final int code;
    private final String description;

    public static Optional<RectangleMenuOption> fromCode(int code) {
        return Arrays.stream(values())
                .filter(opt -> opt.code == code)
                .findFirst();
    }
}
