package co.incubyte.product;

import io.micronaut.http.annotation.Error;
import io.micronaut.http.annotation.*;

import java.util.List;

@Controller("/product")
public class ProductController {
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Get("/all")
    List<ProductResponse> getProducts() {
        return productService.getProducts();
    }

    @Get("/{id}")
    Product getProductById(@PathVariable String id) {
        return productService.getProductById(id);
    }

    @Post()
    ProductResponse addProduct(@Body ProductRequest body) {
        return productService.addProduct(body);
    }

    @Get
    List<ProductResponse> getProductByName(@QueryValue(value = "name", defaultValue = "") String name) {
        return productService.getProductByName(name);
    }

//    @Error(global = true)
//    String notFound() {
//        return "Not found";
//    }
}
