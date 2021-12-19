
package com.ochobits.retouno.service;

import com.ochobits.retouno.model.User;
import com.ochobits.retouno.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author estdiag
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private SequenceGeneratorService sequenceGenerator; 

    public List<User> listar() {
        return userRepository.listar();
    }

    public Optional<User> getUser(int id) {
        return userRepository.getUser(id);

    }

    public User create(User user) {
        if (user.getId() == null) {
            user.setId(sequenceGenerator.generateSequence(user.SEQUENCE_NAME));
            return userRepository.create(user);
        } else {
            Optional<User> e = userRepository.getUser(user.getId());
            if (e.isEmpty()) {
                if (!existeEmail(user.getEmail())) {
                    return userRepository.create(user);
                } else {
                    return user;
                }
            } else {
                return user;
            }
        }
    }

   public boolean existeEmail(String email) {
        return userRepository.existeEmail(email);
    }

    public User autenticaUser(String email, String password) {
        Optional<User> usuario = userRepository.autenticaUser(email, password);

        if (usuario.isEmpty()) {
            return new User();
        } else {
            return usuario.get();
        }
    }
    public User update(User user) {
        if (user.getId() != null) {
            Optional<User> userDb = userRepository.getUser(user.getId());
            if (!userDb.isEmpty()) {
                if (user.getIdentification() != null) {
                    userDb.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null) {
                    userDb.get().setName(user.getName());
                }
                if(user.getBirthtDay() != null){
                    userDb.get().setBirthtDay(user.getBirthtDay());
                }
                if(user.getMonthBirthtDay()!= null){
                    userDb.get().setMonthBirthtDay(user.getMonthBirthtDay());
                }
                if (user.getAddress() != null) {
                    userDb.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null) {
                    userDb.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null) {
                    userDb.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    userDb.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null) {
                    userDb.get().setZone(user.getZone());
                }
                userRepository.update(userDb.get());
                return userDb.get();
            } else {
                return user;
            }
        } else {
            return user;
        }
    }
    public boolean delete(int id) {
        Optional<User> usuario = userRepository.getUser(id);

        if (usuario.isEmpty()) {
            return false;
        } else {
            userRepository.delete(usuario.get());
            return true;
        }
    }
    

}
