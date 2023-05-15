package eu.elision.poc.repository;

import eu.elision.poc.domain.Order;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.CrudRepository;
import org.bson.types.ObjectId;

import java.util.List;

@MongoRepository
public interface OrderRepository extends CrudRepository<Order, ObjectId> {
}
