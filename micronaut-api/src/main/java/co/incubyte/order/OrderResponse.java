package co.incubyte.order;

import co.incubyte.product.Product;

public record OrderResponse(String id, Integer quantity, Product product) {
}
