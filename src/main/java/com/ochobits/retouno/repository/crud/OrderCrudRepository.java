package com.ochobits.retouno.repository.crud;

import com.ochobits.retouno.model.Order;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author jpere
 */
public interface OrderCrudRepository extends MongoRepository<Order, Integer>{
    
}
