package product.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    private Long id;
    private String category; // "GENERAL" 또는 "SNACK"
    private String kind;     // 종류 (예: 가전, 빵, 과자 등)
    private String name;     // 이름
    private String detail;   // 브랜드(GENERAL) 또는 맛(SNACK)
    private int numOf;       // 개수
    private int price;       // 가격

    public String inform() {
        if ("SNACK".equalsIgnoreCase(category)) {
            return String.format("%d. [스낵] 종류 : %s / 이름 : %s / 맛 : %s / 개수 : %d개 / 가격 : %d원", id, kind, name, detail, numOf, price);
        } else {
            return String.format("%d. [상품] 종류 : %s / 이름 : %s / 브랜드 : %s / 개수 : %d개 / 가격 : %d원", id, kind, name, detail, numOf, price);
        }
    }
}
