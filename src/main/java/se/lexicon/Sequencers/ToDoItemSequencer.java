package se.lexicon.Sequencers;

public class ToDoItemSequencer {

    private static int currentId = 0;

    public static int nextId() {
        return ++currentId;
    }
}

