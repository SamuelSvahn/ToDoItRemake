package se.lexicon.Dao;

import se.lexicon.model.ToDoItem;

import java.time.LocalDate;
import java.util.Collection;

public interface ToDoItemDAO {

    ToDoItem add(ToDoItem toDoItem);

    ToDoItem findByID( int id);

    Collection<ToDoItem> findAll();

    Collection<ToDoItem> findAllByDoneStatus(boolean done);

    Collection<ToDoItem> findByTitleContains(String title);

    Collection<ToDoItem> findByPersonId(int personId);

    Collection<ToDoItem> findByDeadlineBefore(LocalDate date);

    Collection<ToDoItem> findByDeadlineAfter(LocalDate date);

    void remove(int id);
}
