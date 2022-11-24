package se.lexicon.Dao.Implementations;

import se.lexicon.Dao.PersonDAO;
import se.lexicon.Dao.ToDoItemTaskDAO;
import se.lexicon.Sequencers.ToDoItemTaskIdSequencers;
import se.lexicon.model.Person;
import se.lexicon.model.ToDoItemTask;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ToDoItemTaskDAOImpl implements ToDoItemTaskDAO {

    private List<ToDoItemTask> toDoItemTaskStorage;

    private static ToDoItemTaskDAOImpl instance;

    private ToDoItemTaskDAOImpl() {
        toDoItemTaskStorage = new ArrayList<>();
    }

    public static ToDoItemTaskDAOImpl getInstance() {
        if (instance == null) instance = new ToDoItemTaskDAOImpl();
        return instance;
    }


    @Override
    public ToDoItemTask add(ToDoItemTask toDoItemTask) {
        if (toDoItemTask == null) throw new IllegalArgumentException("task was null");
        toDoItemTask.setId(ToDoItemTaskIdSequencers.nextId());
        toDoItemTaskStorage.add(toDoItemTask);
        return toDoItemTask;
    }

    @Override
    public ToDoItemTask findById(int id) {
        if (id == 0) throw new IllegalArgumentException("id was null");
        for (ToDoItemTask toDoItemTask : toDoItemTaskStorage)
            if (toDoItemTask.getId() == id) return toDoItemTask;
        return null;
    }

    @Override
    public Collection<ToDoItemTask> findAll() {
        return new ArrayList<>(toDoItemTaskStorage);
    }

    @Override
    public Collection<ToDoItemTask> findByAssignedStatus(ToDoItemTask status) {
        List<ToDoItemTask> filteredList = new ArrayList<>();
        for (ToDoItemTask toDoItemTask : toDoItemTaskStorage)
            if (toDoItemTask.isAssigned()) filteredList.add(toDoItemTask);
        return filteredList;
    }

    @Override
    public Collection<ToDoItemTask> findByPersonId(int personId) {
        List<ToDoItemTask> filteredList = new ArrayList<>();
        for (ToDoItemTask toDoItemTask : toDoItemTaskStorage) {
            Person person = toDoItemTask.getAssignee();
            if (person != null) {
                if (person.getId() == personId) filteredList.add(toDoItemTask);
            }
        }
        return filteredList;
    }


    @Override
    public void remove(int id) {
        ToDoItemTask remove = findById(id);
        if (remove == null) throw new IllegalArgumentException("id does not exist");
        toDoItemTaskStorage.remove(remove);

    }
}
