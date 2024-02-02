package co.incubyte.order;

import co.incubyte.product.Product;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderResponse placeOrder(OrderRequest orderRequest) {
        Product product =  Product.fromId(orderRequest.productId());
        Order save = orderRepository.save(new Order(orderRequest.quantity(), product));
        return new OrderResponse(save.getId(), save.getQuantity(), save.getProduct());
    }

    public List<OrderResponse> getOrders() {
        return orderRepository.findAll().stream()
                .map(order -> new OrderResponse(order.getId(), order.getQuantity(), order.getProduct()))
                .toList();
    }
}
