package com.sebi.repository;

import com.sebi.entity.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person,Integer> {
        Person findByUserName(String Name);
}
