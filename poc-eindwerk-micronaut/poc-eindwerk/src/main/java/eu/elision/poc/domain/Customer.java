package eu.elision.poc.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import eu.elision.poc.dto.CustomerDTO;
import io.micronaut.core.annotation.Creator;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.data.annotation.AutoPopulated;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import jakarta.persistence.*;
import org.bson.types.ObjectId;

import java.util.Set;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.GenerationType.IDENTITY;

@MappedEntity
@Introspected
@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer {

    @Id
    @AutoPopulated
    private ObjectId id;
    private String firstName;
    private String lastName;
    private String postalCode;

    public Customer() {
    }

    @Creator
    public Customer(ObjectId id, String firstName,
                    String lastName, String postalCode, @Nullable Set<Order> orders) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalCode = postalCode;
        this.orders = orders;
    }

    public Customer(CustomerDTO customerDTO) {
        this.id = customerDTO.getId();
        this.firstName = customerDTO.getFirstName();
        this.lastName = customerDTO.getLastName();
        this.postalCode = customerDTO.getPostalCode();
        this.orders = customerDTO.getOrders();
    }

    @OneToMany(cascade = ALL, mappedBy = "customer")
    private Set<Order> orders;

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public CustomerDTO toCustomerDTO() {
        return new CustomerDTO(this);
    }

    public static Customer fromCustomerDTO(CustomerDTO customerDTO) {
        return new Customer(customerDTO);
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
