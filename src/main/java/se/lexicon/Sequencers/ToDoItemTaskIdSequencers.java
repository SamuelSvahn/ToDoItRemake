package se.lexicon.Sequencers;

public class ToDoItemTaskIdSequencers {

    private static int currentId = 0;

    public static int nextId() {
        return ++currentId;
    }
}

