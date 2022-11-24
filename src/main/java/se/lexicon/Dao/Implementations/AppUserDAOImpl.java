package se.lexicon.Dao.Implementations;

import se.lexicon.Dao.AppUserDao;
import se.lexicon.model.AppUser;

import java.util.Collection;

public class AppUserDAOImpl implements AppUserDao {


    @Override
    public AppUser persists(AppUser appUser) {
        return null;
    }

    @Override
    public AppUser findByUsername(String username) {
        return null;
    }

    @Override
    public Collection<AppUser> findAll() {
        return null;
    }

    @Override
    public void remove(String username) {

    }
}
