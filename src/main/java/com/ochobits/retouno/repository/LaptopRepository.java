/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ochobits.retouno.repository;

import com.ochobits.retouno.model.Laptop;
import com.ochobits.retouno.repository.crud.LaptopCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author win10
 */
@Repository
public class LaptopRepository {
    @Autowired
    private LaptopCrudRepository laptopCrudRepository;
    
    public List<Laptop> getAll(){
        return (List<Laptop>) laptopCrudRepository.findAll();
    } 
    
    public Optional<Laptop>getLaptop(int id){
        return laptopCrudRepository.findById(id);
    }
    
    public Laptop save(Laptop laptop){
        return laptopCrudRepository.save(laptop);
    }
    
    public void delete(Laptop laptop){
        laptopCrudRepository.delete(laptop);
    }

    public Optional<Laptop> findById(int id) {
        return laptopCrudRepository.findById(id);
    }
    
}
