package se.lexicon.Dao.Implementations;

import se.lexicon.Dao.AppUserDao;
import se.lexicon.Sequencers.AppUserIdSequencers;
import se.lexicon.model.AppUser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AppUserDAOImpl implements AppUserDao {

    private List<AppUser> userStorage;


    private static AppUserDAOImpl instance;

    private AppUserDAOImpl() {
        userStorage = new ArrayList<>();
    }

    public static AppUserDAOImpl getInstance() {
        if (instance == null) instance = new AppUserDAOImpl();
        return instance;
    }

    @Override
    public AppUser add(AppUser appUser) {
        if (appUser == null) throw new IllegalArgumentException("Appuser was null");
        appUser.setId(AppUserIdSequencers.nextId());
        userStorage.add(appUser);
        return appUser;
    }

    @Override
    public AppUser findByUsername(String username) {
        if (username == null) throw new IllegalArgumentException("Username was null");
        for (AppUser appUser : userStorage)
            if (appUser.getUserName().equalsIgnoreCase(username)) return appUser;
        return null;
    }

    @Override
    public Collection<AppUser> findAll() {
        return new ArrayList<>(userStorage);
    }

    @Override
    public void remove(String username) {
        AppUser remove = findByUsername(username);
        if (remove == null) throw new IllegalArgumentException("does not exist");
        userStorage.remove(remove);

    }
}
