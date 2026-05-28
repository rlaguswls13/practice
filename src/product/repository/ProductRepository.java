package product.repository;

import product.entity.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class ProductRepository {
    private final Map<Long, Product> store = new ConcurrentHashMap<>();
    private final AtomicLong sequence = new AtomicLong(1L);

    public Product save(Product product) {
        if (product.getId() == null) {
            product.setId(sequence.getAndIncrement());
        }
        store.put(product.getId(), product);
        return product;
    }

    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    public List<Product> findAll() {
        return Collections.unmodifiableList(new ArrayList<>(store.values()));
    }

    public void delete(Long id) {
        store.remove(id);
    }

    public void clear() {
        store.clear();
    }
}
