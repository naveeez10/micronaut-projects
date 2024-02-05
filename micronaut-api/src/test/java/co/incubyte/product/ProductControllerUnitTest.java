package co.incubyte.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ProductControllerUnitTest {

    ProductService productService;
    @BeforeEach
    public void setUp() {
        productService = mock(ProductService.class);
    }

    @Test
    public void testGetProducts() {
        productService.getProducts();
        verify(productService).getProducts();
    }
}
