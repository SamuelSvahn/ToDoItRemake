package se.lexicon.model;

import java.util.Objects;

public class ToDoItemTask {

    private int id;
    private boolean assigned;
    private ToDoItem toDoItem;
    private Person assignee;


    // Constructor

    public ToDoItemTask(int id, boolean assigned, ToDoItem toDoItem, Person assignee) {
        setId(id);
        setAssigned(assigned);
        setToDoItem(toDoItem);
        setAssignee(assignee);
    }

    public ToDoItemTask(int id, boolean assigned, ToDoItem toDoItem) {
        setId(id);
        setAssigned(assigned);
        setToDoItem(toDoItem);
    }

    public ToDoItemTask(ToDoItem toDoItem, Person assignee){
        setToDoItem(toDoItem);
        setAssignee(assignee);
    }

    //Setters and Getters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }

    public ToDoItem getToDoItem() {
        return toDoItem;
    }

    public void setToDoItem(ToDoItem toDoItem) {
        this.toDoItem = toDoItem;
    }

    public Person getAssignee() {
        return assignee;
    }

    public void setAssignee(Person assignee) {
        this.assignee = assignee;
    }

    @Override
    public String toString() {
        return "ToDoItemTask{" +
                "toDoItem=" + toDoItem +
                ", assignee=" + assignee +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToDoItemTask that = (ToDoItemTask) o;
        return id == that.id && assigned == that.assigned && toDoItem.equals(that.toDoItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, assigned, toDoItem);
    }
}
