package com.adcubum.persistenceref.repository;

import com.adcubum.persistenceref.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface PersonRepository extends CrudRepository<Person, String> {
}
