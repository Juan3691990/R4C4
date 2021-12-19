package com.ochobits.retouno.repository;

import com.ochobits.retouno.repository.crud.UserCrudRepository;
import com.ochobits.retouno.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author estdiag
 */
@Repository
public class UserRepository {

    @Autowired
    private UserCrudRepository userCrudRepository;

    public List<User> listar() {
        return (List<User>) userCrudRepository.findAll();
    }
    
    public boolean existeEmail(String email) {
        Optional<User> usuario = userCrudRepository.findByEmail(email);
        return !usuario.isEmpty();
    }

    public Optional<User> getUser(int id) {
        return userCrudRepository.findById(id);
    }

    public User create(User user) {
        return userCrudRepository.save(user);
    }

    

    public Optional<User> autenticaUser(String email, String password) {
        return userCrudRepository.findByEmailAndPassword(email, password);
    }

    public void update(User user) {
        userCrudRepository.save(user);
    }

   
    public void delete(User user) {
        userCrudRepository.delete(user);
    }

}
