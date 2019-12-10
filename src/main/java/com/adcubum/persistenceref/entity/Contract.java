package com.adcubum.persistenceref.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Contract {

   @Id
   @GeneratedValue(generator = "uuid")
   @GenericGenerator(name = "uuid", strategy = "uuid2")
   public String id;

   public String name1;

   @ManyToOne(fetch = FetchType.EAGER)
   public Person person;

}
