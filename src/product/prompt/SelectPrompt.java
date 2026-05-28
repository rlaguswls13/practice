package product.prompt;

public enum SelectPrompt implements Prompt {
    SEARCH_BRAND("브랜드명 : "),
    SEARCH_PRICE("기준 가격(이하) : ");

    private final String text;

    SelectPrompt(String text) { this.text = text; }
    @Override public String getText() { return text; }
}
