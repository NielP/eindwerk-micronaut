package eu.elision.poc.service;


import eu.elision.poc.domain.Customer;
import eu.elision.poc.dto.CustomerDTO;
import eu.elision.poc.repository.CustomerRepository;
import jakarta.inject.Singleton;
import org.bson.types.ObjectId;


import javax.transaction.Transactional;
import java.util.List;

@Singleton
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerDTO> findAll() {
        List<Customer> temp = (List<Customer>) customerRepository.findAll();
        return temp.stream().map(eu.elision.poc.domain.Customer::toCustomerDTO).toList();
    }

    public CustomerDTO findById(ObjectId id) {
        return customerRepository.findById(id)
                .map(eu.elision.poc.domain.Customer::toCustomerDTO)
                .orElseThrow();
    }

    @Transactional
    public CustomerDTO create(CustomerDTO customerDTO) {
        return customerRepository.save(eu.elision.poc.domain.Customer.fromCustomerDTO(customerDTO))
                .toCustomerDTO();
    }

    @Transactional
    public void delete(ObjectId id) {
        customerRepository.deleteById(id);
    }
}
