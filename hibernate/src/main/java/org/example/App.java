package org.example;

import org.example.model.Item;
import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class App {
    public static void main( String[] args ){
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Item.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();

            Person person = new Person("bob", 122);

            person.addItem(new Item("some"));
            person.addItem(new Item("eeee"));
            person.addItem(new Item("rock"));

            session.save(person);

            session.getTransaction().commit();
        }finally {
            session.close();
        }
    }
}
