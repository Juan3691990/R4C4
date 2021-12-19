
package com.ochobits.retouno.repository.crud;

import com.ochobits.retouno.model.User;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author estdiag
 */
public interface UserCrudRepository extends MongoRepository<User, Integer>{
    
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email, String password); 
    
       
}

