package eu.elision.poc.service;


import eu.elision.poc.domain.Order;
import eu.elision.poc.dto.OrderDTO;
import eu.elision.poc.repository.OrderRepository;
import jakarta.inject.Singleton;
import org.bson.types.ObjectId;

import javax.transaction.Transactional;
import java.util.List;

@Singleton
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderDTO> findAll() {
        List<Order> temp = (List<Order>) orderRepository.findAll();
        return temp.stream().map(eu.elision.poc.domain.Order::toOrderDTO).toList();
    }

    public OrderDTO findById(ObjectId id) {
        return orderRepository.findById(id)
                .map(eu.elision.poc.domain.Order::toOrderDTO)
                .orElseThrow();
    }

    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {
        return orderRepository.save(eu.elision.poc.domain.Order.fromOrderDTO(orderDTO))
                .toOrderDTO();
    }

    @Transactional
    public void delete(ObjectId id) {
        orderRepository.deleteById(id);
    }
}
