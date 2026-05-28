package practice3.inherit.shape.menu.options;

import lombok.AllArgsConstructor;
import lombok.Getter;
import practice3.inherit.common.menu.MenuOption;

import java.util.Arrays;
import java.util.Optional;

@Getter
@AllArgsConstructor
public enum CircleMenuOption implements MenuOption {
    CIRCUM(1, "원 둘레"),
    AREA(2, "원 넓이"),
    MAIN(9, "이전으로");

    private final int code;
    private final String description;

    public static Optional<CircleMenuOption> fromCode(int code) {
        return Arrays.stream(values())
                .filter(opt -> opt.code == code)
                .findFirst();
    }
}
