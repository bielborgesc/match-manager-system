package application.repository;

import domain.entities.championship.Championship;
import domain.entities.round.Round;
import domain.entities.user.User;
import domain.usecases.championship.ChampionshipDAO;
import domain.usecases.user.UserDAO;

import java.util.*;

public class InMemoryUserDAO implements UserDAO {

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
        String id = user.get();
        if(db.containsKey(id)) {
            db.replace(id, team);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(User type) {
        return false;
    }

    @Override
    public boolean deleteByKey(String key) {
        return false;
    }

    @Override
    public boolean delete(User type) {
        return false;
    }
}
