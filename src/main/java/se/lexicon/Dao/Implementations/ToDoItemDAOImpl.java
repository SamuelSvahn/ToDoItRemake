package se.lexicon.Dao.Implementations;

import se.lexicon.Dao.ToDoItemDAO;
import se.lexicon.model.ToDoItem;

import java.time.LocalDate;
import java.util.Collection;

public class ToDoItemDAOImpl implements ToDoItemDAO {
    @Override
    public ToDoItem add(ToDoItem toDoItem) {
        return null;
    }

    @Override
    public ToDoItem findByID(int id) {
        return null;
    }

    @Override
    public Collection<ToDoItem> findAll() {
        return null;
    }

    @Override
    public Collection<ToDoItem> findAllByDoneStatus(boolean done) {
        return null;
    }

    @Override
    public Collection<ToDoItem> findByTitleContains(String title) {
        return null;
    }

    @Override
    public Collection<ToDoItem> findByPersonId(int personId) {
        return null;
    }

    @Override
    public Collection<ToDoItem> findByDeadlineBefore(LocalDate date) {
        return null;
    }

    @Override
    public Collection<ToDoItem> findByDeadlineAfter(LocalDate date) {
        return null;
    }

    @Override
    public void remove(int id) {

    }
}
