package com.cn.cnEvent.dal;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cn.cnEvent.entity.Person;

@Repository
public class PersonDALImpl implements PersonDAL{

    @Autowired
    EntityManager entityManager;

    @Override
    public Person getPersonById(Long id) {
       Session session = entityManager.unwrap(Session.class);
       Person person = session.get(Person.class, id);
       return person;
    }

    @Override
    public List<Person> getAllPersons() {
        Session session = entityManager.unwrap(Session.class);
        List<Person> persons = session.createQuery("from Person", Person.class).getResultList();
        return persons;
    }
}
