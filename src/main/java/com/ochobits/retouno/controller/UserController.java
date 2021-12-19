
package com.ochobits.retouno.controller;

import com.ochobits.retouno.model.User;
import com.ochobits.retouno.service.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author estdiag
 */

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;
 
    @GetMapping("/all")
    public List <User> listar(){
        return userService.listar();
    }
 
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User create (@RequestBody User user){
    return userService.create(user);
    }
 
    @GetMapping("/{email}/{password}")
    public User autenticaUser (@PathVariable("email") String email,@PathVariable("password") String password){
         return userService.autenticaUser(email,password);
    }
    
    @GetMapping("/emailexist/{email}")
    public boolean existeEmail(@PathVariable("email")String email){
         return userService.existeEmail(email);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update (@RequestBody User user){
        return userService.update(user);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete (@PathVariable("id")int id){
        return userService.delete(id);
    }
    
    @GetMapping("/{id}")
    public User getUserById (@PathVariable("id")int id){
        Optional<User> user = userService.getUser(id);
        
        if(user.isPresent())
            return user.get();
        
        return null;
        
    }
}
