package eu.elision.poc.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import eu.elision.poc.dto.OrderDTO;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.data.annotation.AutoPopulated;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import jakarta.persistence.*;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@MappedEntity
@Introspected
@JsonIgnoreProperties(ignoreUnknown = true)
public class Order {

    @Id
    @AutoPopulated
    private ObjectId id;

    private LocalDateTime createTime;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "orders_products",
            joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"))
    private List<Product> products = new ArrayList<>();

    public Order() {
    }

    public Order(LocalDateTime createTime, Customer customer, @Nullable List<Product> products) {
        this.createTime = createTime;
        this.customer = customer;
        this.products = products;
    }

    public Order(OrderDTO orderDTO) {
        this.createTime = orderDTO.getCreateTime();
        this.customer = orderDTO.getCustomer();
        this.products = orderDTO.getProducts();
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public OrderDTO toOrderDTO() {
        return new OrderDTO(this);
    }

    public static Order fromOrderDTO(OrderDTO orderDTO) {
        return new Order(orderDTO);
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
