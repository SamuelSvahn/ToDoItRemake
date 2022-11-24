package se.lexicon.model;

import java.time.LocalDate;
import java.util.Objects;

public class ToDoItem {

    private int id;
    public String title;
    public String description;
    public LocalDate deadline;
    public boolean done;
    public Person creator;


    // Constructors


    // Getters and setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null) throw new IllegalArgumentException("Title can not be null");
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        if (deadline == null) throw new IllegalArgumentException("Id can not be null");
        this.deadline = deadline;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Person getCreator() {
        return creator;
    }

    public void setCreator(Person creator) {
        this.creator = creator;
    }

    public boolean isOverdue() {
        LocalDate rightNow = LocalDate.now();
        if (rightNow.isAfter(deadline)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "ToDoItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", deadline=" + deadline +
                ", done=" + done +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToDoItem toDoItem = (ToDoItem) o;
        return id == toDoItem.id && done == toDoItem.done && title.equals(toDoItem.title) && description.equals(toDoItem.description) && deadline.equals(toDoItem.deadline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, deadline, done);
    }
}

