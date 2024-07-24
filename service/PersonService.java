package com.cn.cnEvent.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.cnEvent.dal.PersonDAL;
import com.cn.cnEvent.entity.Person;
import com.cn.cnEvent.exception.NotFoundException;

@Service
public class PersonService {

    @Autowired
    PersonDAL personDAL;

    @Transactional
    public Person getPersonById(Long id) {
        Person person = personDAL.getPersonById(id);

        if(person == null){
            // exception
            throw new NotFoundException("No person found with id:  "+id);
        }

        return person;
    }

    @Transactional
    public List<Person> getAllPersons() {
        List<Person> persons = personDAL.getAllPersons();

        if(persons == null){
            throw new NotFoundException("No persons found");
        }

        return persons;
    }
}
