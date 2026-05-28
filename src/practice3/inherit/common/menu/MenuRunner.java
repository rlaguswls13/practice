package practice3.inherit.common.menu;

import lombok.RequiredArgsConstructor;
import practice3.inherit.application.constant.MainMessage;
import practice3.inherit.common.utils.InputView;

import java.util.Optional;
import java.util.function.Function;

@RequiredArgsConstructor
public class MenuRunner {
    private final InputView viewer;

    public <T extends Enum<T> & MenuOption> T runMenu(
            String header,
            Class<T> enumClass,
            Function<Integer, Optional<T>> parser) {
        while (true) {
            System.out.println(header);
            for (T opt : enumClass.getEnumConstants()) {
                System.out.printf("%d. %s%n", opt.getCode(), opt.getDescription());
            }
            int menuCode = viewer.inputInt(MainMessage.PROMPT_MENU);
            Optional<T> optionOpt = parser.apply(menuCode);

            if (optionOpt.isEmpty()) {
                System.out.println(MainMessage.MSG_INVALID_MENU);
                continue;
            }

            return optionOpt.get();
        }
    }
}
