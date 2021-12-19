/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ochobits.retouno.model;

import javax.persistence.Column;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.Transient;
/**
 *
 * @author win10
 */


@Data

@NoArgsConstructor

@AllArgsConstructor

@Document(collection = "laptops")

public class Laptop {
    
    @Transient
    public static final String SEQUENCE_NAME = "laptops_sequence";
    
    @Id
    private Integer id;
    @NonNull
    @Column(nullable=false)
    private String brand;
    @NonNull
    @Column(nullable=false)
    private String model;
    @NonNull
    @Column(nullable=false)
    private String procesor;
    @NonNull
    @Column(nullable=false)
    private String os;
    @NonNull
    @Column(nullable=false,length = 80)
    private String description;
    @NonNull
    @Column(nullable=false)
    private String memory;
    @NonNull
    @Column(nullable=false)
    private String hardDrive;

    @Column(nullable=false)
    private Boolean availability = true;

    @Column(nullable=false)
    private Double price;

    @Column(nullable=false)
    private Integer quantity;
    @NonNull
    @Column(nullable=false)
    private String photography;
}
