package product.dto;

import product.type.ProductCategory;

public record ProductInputDto(ProductCategory category, String kind, String name, String detail, int numOf, int price) {
}

