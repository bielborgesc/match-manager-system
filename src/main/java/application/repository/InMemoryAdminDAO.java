package application.repository;

import domain.entities.user.User;
import domain.usecases.user.UserDAO;

import java.util.*;

public class InMemoryAdminDAO implements UserDAO {

    private static final Map<String, User> db = new LinkedHashMap<>();

    @Override
    public String create(User user) {
        db.put(user.getUsername(), user);
        return user.getUsername();
    }

    @Override
    public Optional<User> findOne(String username) {
        if(db.containsKey(username))
            return Optional.of(db.get(username));
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(db.values());
    }

    @Override
    public boolean update(User user) {
        String username = user.getUsername();
        if(db.containsKey(username)) {
            db.replace(username, user);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteByKey(String key) {
        if(db.containsKey(key)){
            db.remove(key);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(User user) {
        return deleteByKey( user.getUsername());
    }
}
