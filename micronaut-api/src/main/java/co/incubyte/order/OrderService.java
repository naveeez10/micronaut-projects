package co.incubyte.order;

import co.incubyte.product.Product;


import co.incubyte.product.ProductService;
import jakarta.inject.Singleton;


import java.util.List;

@Singleton
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductService productService;

    public OrderService(OrderRepository orderRepository, ProductService productService) {
        this.orderRepository = orderRepository;
        this.productService = productService;
    }

    public OrderResponse placeOrder(OrderRequest orderRequest) {
        Product product = productService.getProductById(orderRequest.id());
        Order save = orderRepository.save(new Order(orderRequest.quantity(), product));
        return new OrderResponse(save.getId(), save.getQuantity(), save.getProduct());
    }

    public List<OrderResponse> getOrders() {
        return orderRepository.findAll().stream().map(order ->
                new OrderResponse(order.getId(), order.getQuantity(), order.getProduct())).toList();

    }
}
