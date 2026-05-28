package practice3.inherit.student.menu.options;

import lombok.AllArgsConstructor;
import lombok.Getter;
import practice3.inherit.common.menu.MenuOption;

import java.util.Arrays;
import java.util.Optional;

@Getter
@AllArgsConstructor
public enum StudentMenuOption implements MenuOption {
    REGISTER(1, "학생 등록"),
    LIST(2, "학생 전체 조회"),
    MAIN(9, "이전으로");

    private final int code;
    private final String description;

    public static Optional<StudentMenuOption> fromCode(int code) {
        return Arrays.stream(values())
                .filter(opt -> opt.code == code)
                .findFirst();
    }
}
