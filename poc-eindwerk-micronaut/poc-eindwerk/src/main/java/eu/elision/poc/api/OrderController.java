package eu.elision.poc.api;

import eu.elision.poc.dto.OrderDTO;
import eu.elision.poc.service.OrderService;
import io.micronaut.http.annotation.*;
import org.bson.types.ObjectId;

import java.util.List;

@Controller("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @Get
    public List<OrderDTO> listOrders() {
        return orderService.findAll();
    }

    @Get("/{id}")
    public OrderDTO getOrder(@PathVariable("id") ObjectId id) {
        return orderService.findById(id);
    }

    @Post
    public OrderDTO createOrder(@Body OrderDTO orderDTO) {
        return orderService.create(orderDTO);
    }

    @Delete("/{id}")
    public void deleteOrder(@PathVariable("id") ObjectId id) {
        orderService.delete(id);
    }
}
