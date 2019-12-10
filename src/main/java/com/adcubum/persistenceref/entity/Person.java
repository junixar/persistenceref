package com.adcubum.persistenceref.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Person {

   @Id
   @GeneratedValue(generator = "uuid")
   @GenericGenerator(name = "uuid", strategy = "uuid2")
   public String id;

   public String name;

   @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
   public Collection<Contract> contracts;

}
