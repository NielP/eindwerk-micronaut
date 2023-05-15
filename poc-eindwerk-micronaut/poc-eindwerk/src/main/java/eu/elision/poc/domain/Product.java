package eu.elision.poc.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import eu.elision.poc.dto.ProductDTO;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.data.annotation.AutoPopulated;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import jakarta.persistence.*;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

@MappedEntity
@Introspected
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {

    @Id
    @AutoPopulated
    private ObjectId id;
    private String name;
    private Double price;
    private String ean;
    @ManyToMany(mappedBy = "products")
    private List<Order> orders = new ArrayList<>();

    public Product() {
    }

    public Product(String name, Double price, String ean, @Nullable List<Order> orders) {
        this.name = name;
        this.price = price;
        this.ean = ean;
        this.orders = orders;
    }

    public Product(ProductDTO productDTO) {
        this.name = productDTO.getName();
        this.price = productDTO.getPrice();
        this.ean = productDTO.getEan();
        this.orders = productDTO.getOrders();
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public ProductDTO toProductDTO() {
        return new ProductDTO(this);
    }

    public static Product fromProductDTO(ProductDTO productDTO) {
        return new Product(productDTO);
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
