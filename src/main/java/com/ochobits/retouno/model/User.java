
package com.ochobits.retouno.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 *
 * @author estdiag
 */

@Document(collection = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {

    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";
    
    @Id
    private Integer id;
    @NonNull
    @Column (nullable=false)
    private String identification;
    @NonNull
    @Column (nullable = false, length =80)
    private String name;
    @NonNull
    @Column (nullable = false)
    private Date birthtDay;
    @NonNull
    @Column (nullable = false)
    private String monthBirthtDay;
    @NonNull
    @Column (nullable = false)
    private String address;
    @NonNull
    @Column (nullable = false)
    private String cellPhone;
    @NonNull
    @Column (nullable = false, length =50) 
    private String email;
    @NonNull
    @Column (nullable = false, length =50) 
    private String password;
    @NonNull
    @Column (nullable = false)
    private String zone;
    @NonNull
    @Column (nullable = false)
    private String type;
    
    
    
    
}
