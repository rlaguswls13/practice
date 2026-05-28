package practice2.product.controller;

import practice2.product.ProductConstants;
import practice2.product.dto.ProductInputDto;
import practice2.product.entity.Product;
import practice2.product.repository.ProductRepository;
import practice2.product.type.ProductCategory;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductController {
    private final ProductRepository repository = new ProductRepository();

    public ProductController() {
        // 샘플 데이터 초기화 (Lombok 빌더 및 ProductCategory 적용)
        repository.save(Product.builder().category(ProductCategory.GENERAL).kind("가전").name("갤럭시").detail("삼성").numOf(1).price(1200000).build());
        repository.save(Product.builder().category(ProductCategory.GENERAL).kind("가전").name("아이폰").detail("애플").numOf(1).price(1300000).build());
        repository.save(Product.builder().category(ProductCategory.SNACK).kind("빵").name("케이크").detail("블루베리").numOf(1).price(15000).build());
        repository.save(Product.builder().category(ProductCategory.FRUIT).kind("과일").name("사과").detail("부사").numOf(5).price(10000).build());
    }

    public void insertProduct(ProductInputDto dto) {
        if (repository.findAll().size() >= ProductConstants.MAX_INVENTORY) {
            throw new IllegalStateException(ProductConstants.MSG_FULL_INVENTORY);
        }

        Product product = Product.builder()
                .category(dto.category())
                .kind(dto.kind())
                .name(dto.name())
                .detail(dto.detail())
                .numOf(dto.numOf())
                .price(dto.price())
                .build();
        repository.save(product);
    }

    public List<Product> selectProduct() {
        return repository.findAll();
    }

    public Optional<Product> selectProductById(Long id) {
        return repository.findById(id);
    }

    public List<Product> selectProductByCategory(ProductCategory category) {
        return repository.findAll().stream()
                .filter(p -> p.getCategory() == category)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Product> selectProductByBrand(String brand) {
        return repository.findAll().stream()
                .filter(p -> p.getDetail().toLowerCase().contains(brand.trim().toLowerCase()) 
                        || p.getKind().toLowerCase().contains(brand.trim().toLowerCase())
                        || p.getName().toLowerCase().contains(brand.trim().toLowerCase()))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Product> selectProductByPriceLessThanOrEqual(int price) {
        return repository.findAll().stream()
                .filter(p -> p.getPrice() <= price)
                .collect(Collectors.toUnmodifiableList());
    }

    public void updateProduct(Long id, ProductInputDto dto) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(ProductConstants.MSG_NOT_FOUND));

        product.setKind(dto.kind());
        product.setName(dto.name());
        product.setDetail(dto.detail());
        product.setNumOf(dto.numOf());
        product.setPrice(dto.price());
        repository.save(product);
    }

    public void deleteProduct(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(ProductConstants.MSG_NOT_FOUND));
        repository.delete(id);
    }
}

