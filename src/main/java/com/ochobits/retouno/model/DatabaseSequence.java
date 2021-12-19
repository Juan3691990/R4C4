package com.ochobits.retouno.model;

import org.springframework.data.annotation.Id;

/**
 *
 * @author jpere
 */
public class DatabaseSequence {
    @Id
    private String id;

    private int seq;

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }
    
}
