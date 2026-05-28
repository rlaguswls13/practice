package product.controller;

import product.ProductConstants;
import product.dto.ProductInputDto;
import product.entity.Product;
import product.repository.ProductRepository;

import java.util.List;

public class ProductController {
    private final ProductRepository repository = new ProductRepository();

    public ProductController() {
        // 샘플 데이터 초기화 (Lombok 빌더 활용)
        repository.save(Product.builder().category("GENERAL").kind("가전").name("갤럭시").detail("삼성").numOf(1).price(1200000).build());
        repository.save(Product.builder().category("GENERAL").kind("가전").name("아이폰").detail("애플").numOf(1).price(1300000).build());
        repository.save(Product.builder().category("SNACK").kind("빵").name("케이크").detail("블루베리").numOf(1).price(15000).build());
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
