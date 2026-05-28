package product.controller;

import product.ProductConstants;
import product.dto.ProductInputDto;
import product.entity.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductController {
    private final List<Product> pro = new ArrayList<>(ProductConstants.MAX_INVENTORY);

    public ProductController() {
        pro.add(Product.builder().pName("갤럭시").price(1200000).brand("삼성").build());
        pro.add(Product.builder().pName("아이폰").price(1300000).brand("애플").build());
        pro.add(Product.builder().pName("아이패드").price(800000).brand("애플").build());
    }

    public void insertProduct(ProductInputDto dto) {
        if (pro.size() >= ProductConstants.MAX_INVENTORY) {
            throw new IllegalStateException(ProductConstants.MSG_FULL_INVENTORY);
        }

        pro.add(Product.builder()
                .pName(dto.pName())
                .price(dto.price())
                .brand(dto.brand())
                .build());
    }

    public List<Product> selectProduct() {
        return Collections.unmodifiableList(pro);
    }

    public List<Product> selectProductByBrand(String brand) {
        return pro.stream()
                .filter(p -> p.getBrand().equalsIgnoreCase(brand.trim()))
                .toList();
    }

    public List<Product> selectProductByPriceLessThanOrEqual(int price) {
        return pro.stream()
                .filter(p -> p.getPrice() <= price)
                .toList();
    }
}
