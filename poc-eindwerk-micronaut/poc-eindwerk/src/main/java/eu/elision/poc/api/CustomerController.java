package eu.elision.poc.api;

import eu.elision.poc.dto.CustomerDTO;
import eu.elision.poc.service.CustomerService;
import io.micronaut.http.annotation.*;
import org.bson.types.ObjectId;

import java.util.List;

@Controller( "/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Get
    public List<CustomerDTO> listCustomers() {
        return customerService.findAll();
    }

    @Get("/{id}")
    public CustomerDTO getCustomer(@PathVariable("id") ObjectId id) {
        return customerService.findById(id);
    }

    @Post
    public CustomerDTO createCustomer(@Body CustomerDTO customerDTO) {
        return customerService.create(customerDTO);
    }

    @Delete("/{id}")
    public void deleteCustomer(@PathVariable("id") ObjectId id) {
        customerService.delete(id);
    }
}