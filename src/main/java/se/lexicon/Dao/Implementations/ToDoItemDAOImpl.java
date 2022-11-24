package se.lexicon.Dao.Implementations;

import se.lexicon.Dao.ToDoItemDAO;
import se.lexicon.Sequencers.ToDoItemSequencer;
import se.lexicon.model.Person;
import se.lexicon.model.ToDoItem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ToDoItemDAOImpl implements ToDoItemDAO {

    private List<ToDoItem> toDoItemStorage;

    private static ToDoItemDAOImpl instance;

    private ToDoItemDAOImpl() {
        toDoItemStorage = new ArrayList<>();
    }

    public static ToDoItemDAOImpl getInstance() {
        if (instance == null) instance = new ToDoItemDAOImpl();
        return instance;
    }


    @Override
    public ToDoItem add(ToDoItem toDoItem) {
        if (toDoItem == null) throw new IllegalArgumentException("to do item can not be null");
        toDoItem.setId(ToDoItemSequencer.nextId());
        toDoItemStorage.add(toDoItem);
        return toDoItem;
    }

    @Override
    public ToDoItem findByID(int id) {
        if (id == 0) throw new IllegalArgumentException("id can not be null");
        for (ToDoItem toDoItem : toDoItemStorage)
            if (toDoItem.getId() == id) return toDoItem;

        return null;
    }

    @Override
    public Collection<ToDoItem> findAll() {
        return new ArrayList<>(toDoItemStorage);
    }

    @Override
    public Collection<ToDoItem> findAllByDoneStatus(boolean done) {
        List<ToDoItem> filteredList = new ArrayList<>();
        for (ToDoItem toDoItem : toDoItemStorage)
            if (toDoItem.isDone())
                filteredList.add(toDoItem);

        return filteredList;
    }

    @Override
    public Collection<ToDoItem> findByTitleContains(String title) {
        List<ToDoItem> filteredList = new ArrayList<>();
        if (title == null) throw new IllegalArgumentException("Title was null");
        for (ToDoItem toDoItem : toDoItemStorage)
            if (toDoItem.getTitle().equalsIgnoreCase(title))
                toDoItemStorage.add(toDoItem);
        return filteredList;
    }

    @Override
    public Collection<ToDoItem> findByPersonId(int personId) {
        List<ToDoItem> filteredList = new ArrayList<>();

        for (ToDoItem toDoItem : toDoItemStorage) {
            Person person = toDoItem.getCreator();
            if (person == null) throw new IllegalArgumentException("person was null");
            {
                if (person.getId() == personId) {
                    filteredList.add(toDoItem);
                }
            }
        }
        return filteredList;
    }

    @Override
    public Collection<ToDoItem> findByDeadlineBefore(LocalDate date) {
        List<ToDoItem> filteredList = new ArrayList<>();
        for (ToDoItem toDoItem : toDoItemStorage)
            if (toDoItem.getDeadline().isBefore(date) && toDoItem.getDeadline().equals(date))
                filteredList.add(toDoItem);
        return filteredList;

    }

    @Override
    public Collection<ToDoItem> findByDeadlineAfter(LocalDate date) {
        List<ToDoItem> filteredList = new ArrayList<>();
        for (ToDoItem toDoItem : toDoItemStorage) {
            if (toDoItem.getDeadline().isAfter(date) && toDoItem.getDeadline().equals(date))
                filteredList.add(toDoItem);
        }
        return filteredList;
    }

    @Override
    public void remove(int id) {
        ToDoItem remove = findByID(id);
        if (remove == null) throw new IllegalArgumentException("does not exist");
        toDoItemStorage.remove(remove);

    }
}
