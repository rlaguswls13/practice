package product.prompt;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum MainPrompt implements Prompt {
    MENU_NUM("메뉴 번호 : "),
    SELECT_TYPE_NUM("조회 방식 : ");

    private final String text;

    @Override public String getText() { return text; }
}
