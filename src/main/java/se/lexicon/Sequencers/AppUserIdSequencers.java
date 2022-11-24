package se.lexicon.Sequencers;

public class AppUserIdSequencers {

    private static int currentId = 0;

    public static int nextId() {
        return ++currentId;
    }
}
