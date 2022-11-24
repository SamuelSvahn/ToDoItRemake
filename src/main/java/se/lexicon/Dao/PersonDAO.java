package se.lexicon.Dao;

import se.lexicon.model.Person;

import java.util.Collection;

public interface PersonDAO {

    Person add(Person person);

    Person findById(int id);

    Person findByEmail(String email);

    Collection<Person> findAll();

    void remove(int id);
}
