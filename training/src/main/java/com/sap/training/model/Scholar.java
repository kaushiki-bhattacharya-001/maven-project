package com.sap.training.model;

import javax.persistence.*;

@Entity
@Table(name="scholar")
public class Scholar {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "batch", nullable = false)
    private String batch;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }


}
