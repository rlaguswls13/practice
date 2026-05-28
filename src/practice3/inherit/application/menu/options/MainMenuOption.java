package practice3.inherit.application.menu.options;

import lombok.AllArgsConstructor;
import lombok.Getter;
import practice3.inherit.common.menu.MenuOption;

import java.util.Arrays;
import java.util.Optional;

@Getter
@AllArgsConstructor
public enum MainMenuOption implements MenuOption {
    SHAPE(1, "도형 정보 확인 시스템"),
    STUDENT(2, "학생 관리 시스템"),
    EXIT(9, "종료");

    private final int code;
    private final String description;

    public static Optional<MainMenuOption> fromCode(int code) {
        return Arrays.stream(values())
                .filter(opt -> opt.code == code)
                .findFirst();
    }
}
