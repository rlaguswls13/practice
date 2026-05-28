package practice2.product.dto;

import practice2.product.type.ProductCategory;

public record ProductInputDto(ProductCategory category, String kind, String name, String detail, int numOf, int price) {
}

