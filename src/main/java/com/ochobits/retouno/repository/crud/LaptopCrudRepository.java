/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ochobits.retouno.repository.crud;

import com.ochobits.retouno.model.Laptop;
import org.springframework.data.mongodb.repository.MongoRepository;


/**
 *
 * @author win10
 */
public interface LaptopCrudRepository extends MongoRepository<Laptop, Integer> {
    
}
