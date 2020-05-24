package com.melhamra.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerators;

import javax.persistence.*;

@Entity
@Data
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private User user;
}
