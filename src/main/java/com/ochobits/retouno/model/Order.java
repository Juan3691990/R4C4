package com.ochobits.retouno.model;

import java.util.Date;
import java.util.Map;
import javax.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author jpere
 */
@Document(collection = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    
    @Transient
    public static final String SEQUENCE_NAME = "orders_sequence";
    
    public static final String PENDING = "Pendiente";

    public static final String APROVED = "Aprobada";

    public static final String REJECTED = "Rechazada";

    @Id
    private Integer id;

    private Date registerDay;

    private String status;

    private User salesMan;

    private Map<Integer, Laptop> products;

    private Map<Integer, Integer> quantities;

}