package product.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import product.type.ProductCategory;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    private Long id;
    private ProductCategory category; // GENERAL, SNACK, FRUIT
    private String kind;             // 종류 (예: 가전, 빵, 과자, 과일 등)
    private String name;             // 이름
    private String detail;           // 브랜드(GENERAL), 맛(SNACK), 품종(FRUIT)
    private int numOf;               // 개수
    private int price;               // 가격

    public String inform() {
        String categoryLabel;
        String detailLabel;
        if (category == ProductCategory.GENERAL) {
            categoryLabel = "일반";
            detailLabel = "브랜드";
        } else if (category == ProductCategory.SNACK) {
            categoryLabel = "스낵";
            detailLabel = "맛";
        } else {
            categoryLabel = "과일";
            detailLabel = "품종";
        }
        return String.format("%d. [%s] 종류 : %s / 이름 : %s / %s : %s / 개수 : %d개 / 가격 : %d원",
                id, categoryLabel, kind, name, detailLabel, detail, numOf, price);
    }
}

