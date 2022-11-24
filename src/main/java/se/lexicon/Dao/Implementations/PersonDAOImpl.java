package se.lexicon.Dao.Implementations;

import se.lexicon.Dao.PersonDAO;
import se.lexicon.Sequencers.PersonIdSequencer;
import se.lexicon.model.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PersonDAOImpl implements PersonDAO {

    private List<Person> personStorage;

    private static PersonDAOImpl instance;

    private PersonDAOImpl(){
        personStorage= new ArrayList<>();
    }

    public static PersonDAOImpl getInstance(){
        if(instance== null) instance= new PersonDAOImpl();
        return instance;
    }








    @Override
    public Person add(Person person) {
        if( person== null) throw new IllegalArgumentException("Person was empty");
        person.setId(PersonIdSequencer.nextId());
        personStorage.add(person);
        return person;
    }

    @Override
    public Person findById(int id) {
        if(id==0) throw new IllegalArgumentException("Id was null");
        for(Person person: personStorage)
            if(person.getId()==id) return person;
        return null;
    }

    @Override
    public Person findByEmail(String email) {
        if(email == null) throw new IllegalArgumentException("Email was null");
        for(Person person : personStorage)
            if(person.getEmail().equalsIgnoreCase(email)) return person;
        return null;
    }

    @Override
    public Collection<Person> findAll() {
        return new ArrayList<>(personStorage);
    }

    @Override
    public void remove(int id) {
        Person remove= findById(id);
        if(remove== null) throw new IllegalArgumentException("id did not exist");
        personStorage.remove(remove);

    }
}
