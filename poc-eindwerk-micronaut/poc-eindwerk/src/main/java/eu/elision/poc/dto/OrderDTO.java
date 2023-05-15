package eu.elision.poc.dto;


import eu.elision.poc.domain.Customer;
import eu.elision.poc.domain.Order;
import eu.elision.poc.domain.Product;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;
import java.util.List;


public class OrderDTO {
    private ObjectId id;
    private LocalDateTime createTime;
    private Customer customer;
    private List<Product> products;

    public OrderDTO() {
    }

    public OrderDTO(Order order) {
        this.id = order.getId();
        this.createTime = order.getCreateTime();
        this.customer = order.getCustomer();
        this.products = order.getProducts();
    }

    public ObjectId getId() {
        return id;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Product> getProducts() {
        return products;
    }
}
