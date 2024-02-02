package co.incubyte.order;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

import java.util.List;

@Controller("/order")
public class OrderController {
    private final OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @Post
    public OrderResponse placeOrder(@Body OrderRequest orderRequest) {
        return orderService.placeOrder(orderRequest);
    }

    @Get
    public List<OrderResponse> getOrders() {
        return orderService.getOrders();
    }
}
