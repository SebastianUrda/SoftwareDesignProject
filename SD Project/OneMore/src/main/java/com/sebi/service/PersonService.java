package com.sebi.service;

import com.sebi.entity.Person;
import com.sebi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAllPersons()
    {
        //return topics;
        List<Person> topics=new ArrayList<>();
        personRepository.findAll().forEach(topics::add);
        return topics;
    }
    public Person getPerons(Integer id)
    {
        //return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
        return personRepository.findOne(id);
    }

    public void addPerson(Person topic) {
        personRepository.save(topic);
    }
    public Person findByName(String name){ return personRepository.findByUserName(name);}

    public void updatePerson(String id, Person topic) {
        personRepository.save(topic);
    }

    public void deletePerson(Integer id) {
        personRepository.delete(id);

    }
}

