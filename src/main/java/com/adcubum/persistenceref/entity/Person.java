package com.adcubum.persistenceref.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
public class Person {

   @Id
   @GeneratedValue(generator = "uuid")
   @GenericGenerator(name = "uuid", strategy = "uuid2")
   public String id;

   public String name;

   @Version
   public LocalDateTime version;

   @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
   public Collection<Contract> contracts;

}
