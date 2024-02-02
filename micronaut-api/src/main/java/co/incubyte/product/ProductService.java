package co.incubyte.product;

import co.incubyte.exception.EntityNotFound;
import de.huxhorn.sulky.ulid.ULID;
import jakarta.inject.Singleton;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Singleton
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public Product getProductById(String id) {
        return productRepository.findById(id).orElseThrow(EntityNotFound::new);
    }

    public List<ProductResponse> getProducts()  {
        List<Product> products = productRepository.findAll();
        return products.stream().map(product -> new ProductResponse(product.getId(), product.getName(),
                product.getCreatedAt(),
                product.getUpdatedAt())).toList();
    }

    public ProductResponse addProduct(ProductRequest body) {
        Product savedProduct = productRepository.save(new Product(new ULID().nextULID(), body.name()));
        return new ProductResponse(savedProduct.getId(), savedProduct.getName(),
                savedProduct.getCreatedAt(),
                savedProduct.getUpdatedAt());
    }

    public List<ProductResponse> getProductByName(String name) {
        return productRepository.findByName(name).stream().map(product -> new ProductResponse(product.getId(), product.getName(),
                product.getCreatedAt(),
                product.getUpdatedAt())).toList();
    }
}

