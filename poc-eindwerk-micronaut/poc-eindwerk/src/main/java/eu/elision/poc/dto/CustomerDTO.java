package eu.elision.poc.dto;

import eu.elision.poc.domain.Customer;
import eu.elision.poc.domain.Order;
import io.micronaut.core.annotation.Nullable;
import org.bson.types.ObjectId;

import java.util.Set;

public class CustomerDTO {
    private ObjectId id;
    private String firstName;
    private String lastName;
    private String postalCode;
    private Set<Order> orders;

    public CustomerDTO() {
    }

    public CustomerDTO(Customer customer) {
        this.id = customer.getId();
        this.firstName = customer.getFirstName();
        this.lastName = customer.getLastName();
        this.postalCode = customer.getPostalCode();
        this.orders = customer.getOrders();
    }

    public CustomerDTO(String firstName, String lastName, String postalCode, Set<Order> orders) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalCode = postalCode;
        this.orders = orders;
    }

    public ObjectId getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public Set<Order> getOrders() {
        return orders;
    }
}
