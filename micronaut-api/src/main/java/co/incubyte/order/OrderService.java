package co.incubyte.order;

import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderResponse placeOrder(OrderRequest orderRequest) {
        Order save = orderRepository.save(new Order(orderRequest.quantity()));
        return new OrderResponse(save.getId(), save.getQuantity());
    }

    public List<OrderResponse> getOrders() {
        return orderRepository.findAll().stream()
                .map(order -> new OrderResponse(order.getId(), order.getQuantity()))
                .toList();
    }
}
