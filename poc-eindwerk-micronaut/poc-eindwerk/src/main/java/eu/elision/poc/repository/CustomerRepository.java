package eu.elision.poc.repository;


import eu.elision.poc.domain.Customer;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.CrudRepository;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

@MongoRepository
public interface CustomerRepository extends CrudRepository<Customer, ObjectId> {
}
