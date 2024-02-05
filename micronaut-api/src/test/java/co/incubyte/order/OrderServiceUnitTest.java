package co.incubyte.order;

import co.incubyte.product.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.AdditionalAnswers.returnsSecondArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class OrderServiceUnitTest {

  OrderRepository orderRepository;
  ProductService productService;

  OrderService orderService;

  @BeforeEach
  void setUp() {
    productService = mock(ProductService.class);
    orderRepository = mock(OrderRepository.class);

    orderService = new OrderService(orderRepository, productService);
  }

  @Test
  public void testPlaceOrder() {
    when(orderRepository.save(any(Order.class))).thenAnswer(returnsFirstArg());
    OrderResponse response = orderService.placeOrder(new OrderRequest(1, "FAKE_PRODUCT_ID"));
    verify(orderRepository).save(any(Order.class));
    assertThat(response.product()).isNull();
  }
}
