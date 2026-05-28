package product.prompt;

public enum InsertPrompt implements Prompt {
    PRODUCT_NAME("상품명 : "),
    PRODUCT_PRICE("가격 : "),
    PRODUCT_BRAND("브랜드명 : ");

    private final String text;

    InsertPrompt(String text) { this.text = text; }
    @Override public String getText() { return text; }
}
