package se.lexicon.Dao;

import se.lexicon.model.ToDoItemTask;

import java.util.Collection;

public interface ToDoItemTaskDAO {

    ToDoItemTask add(ToDoItemTask toDoItemTask);

    ToDoItemTask findById(int id);

    Collection<ToDoItemTask> findAll();

    Collection<ToDoItemTask> findByAssignedStatus(ToDoItemTask status);

    Collection<ToDoItemTask> findByPersonId(int personId);

    void remove(int id);
}
