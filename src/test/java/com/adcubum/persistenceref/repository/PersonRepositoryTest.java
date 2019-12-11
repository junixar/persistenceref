package com.adcubum.persistenceref.repository;

import com.adcubum.persistenceref.entity.Contract;
import com.adcubum.persistenceref.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import java.util.Collections;

@SpringBootTest
@Transactional
@Rollback(false)
public class PersonRepositoryTest {

   @Autowired
   private PersonRepository personRepository;

   @Autowired
   private EntityManager entityManager;

   @Test
   public void test() {
      Person person = new Person();
      person.name = "testName";

      Contract contract = new Contract();
      contract.name1 = "contractTestName";
      contract.person = person;
      person.contracts = Collections.singleton(contract);

      Person savedPerson = personRepository.save(person);
      savedPerson.name = "changedName";

      Person loadedPerson = personRepository.findById(savedPerson.id).get();
   }

   @Test
   public void testOptimisticLocking() {
      Iterable<Person> allPeople = personRepository.findAll();
      Person person = allPeople.iterator().next();
      entityManager.lock(person, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
   }
}
