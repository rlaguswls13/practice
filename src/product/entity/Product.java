package product.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import product.ProductConstants;

@Getter
@AllArgsConstructor
@Builder
public class Product {
    private final String pName;
    private final int price;
    private final String brand;

    public String inform() {
        return String.format(ProductConstants.PRODUCT_INFORM_FORMAT, pName, price, brand);
    }
}
