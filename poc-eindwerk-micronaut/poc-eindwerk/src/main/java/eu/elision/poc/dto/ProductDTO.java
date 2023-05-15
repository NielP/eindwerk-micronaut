package eu.elision.poc.dto;

import eu.elision.poc.domain.Order;
import eu.elision.poc.domain.Product;
import io.micronaut.core.annotation.Nullable;
import org.bson.types.ObjectId;

import java.util.List;

public class ProductDTO {
    private ObjectId id;
    private String name;
    private Double price;
    private String ean;
    @Nullable
    private List<Order> orders;

    public ProductDTO() {
    }

    public ProductDTO(Product product) {
        this.name = product.getName();
        this.price = product.getPrice();
        this.ean = product.getEan();
        this.orders = product.getOrders();
    }

    public ObjectId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getEan() {
        return ean;
    }

    @Nullable
    public List<Order> getOrders() {
        return orders;
    }
}
