/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ochobits.retouno.service;

import com.ochobits.retouno.model.Laptop;
import com.ochobits.retouno.repository.LaptopRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author win10
 */
@Service
public class LaptopService {

    @Autowired
    private LaptopRepository laptopRepository;
    
    @Autowired
    private SequenceGeneratorService sequenceGenerator; 
    
    public List<Laptop> getAll() {
        return laptopRepository.getAll();
    }
    
    public Laptop getLaptop(int id) {
        Optional<Laptop> laptop = laptopRepository.findById(id);
        if(laptop.isPresent())
            return laptop.get();
        return null;
    }

    public Laptop save(Laptop laptop) {
        if (laptop.getId() == null) {
            laptop.setId(sequenceGenerator.generateSequence(laptop.SEQUENCE_NAME));
            return laptopRepository.save(laptop);
        } else {
            Optional<Laptop> laptop1 = laptopRepository.getLaptop(laptop.getId());
            if (laptop1.isEmpty()) {
                return laptopRepository.save(laptop);
            } else {
                return laptop;
            }
        }
    }

    public boolean deleteLaptop(int id) {
        Optional<Laptop> categoryd = laptopRepository.getLaptop(id);

        if (categoryd.isEmpty()) {
            return false;
        } else {
            laptopRepository.delete(categoryd.get());
            return true;
        }
    }

    public Laptop updateLaptop(Laptop laptop) {

        if (laptop.getId() != null) {
            Optional<Laptop> laptopU = laptopRepository.getLaptop(laptop.getId());

            if (!laptopU.isEmpty()) {

                    laptopU.get().setBrand(laptop.getBrand());                               
                    laptopU.get().setModel(laptop.getModel());
                    laptopU.get().setProcesor(laptop.getProcesor());
                    laptopU.get().setOs(laptop.getOs());
                    laptopU.get().setDescription(laptop.getDescription());
                    laptopU.get().setMemory(laptop.getMemory());
                    laptopU.get().setHardDrive(laptop.getHardDrive());
                    laptopU.get().setAvailability(laptop.getAvailability());
                    laptopU.get().setPrice(laptop.getPrice());
                    laptopU.get().setQuantity(laptop.getQuantity());
                    laptopU.get().setPhotography(laptop.getPhotography());
                    
                
            }
            return laptopRepository.save(laptopU.get());
        }
        return laptop;
    }
}
