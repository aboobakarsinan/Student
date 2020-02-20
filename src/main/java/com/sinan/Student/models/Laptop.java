package com.sinan.Student.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "laptop")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Laptop implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "laptop_id",nullable = false, updatable = false)
    private Long laptopId;

    @Column(name = "laptop_model", nullable = false)
    private String model;

    @Column(name = "branch", nullable = false)
    private String brand;


    @OneToOne(mappedBy = "laptop")
    @JsonIgnore
    private Student student;

    public Laptop () {

    }

    public Long getLaptopId() {
        return laptopId;
    }

    public void setLaptopId(Long laptopId) {
        this.laptopId = laptopId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
