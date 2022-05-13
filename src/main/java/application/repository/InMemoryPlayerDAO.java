package application.repository;

import domain.entities.player.Player;
import domain.usecases.player.PlayerDAO;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemoryPlayerDAO implements PlayerDAO {

    private static final Map<String, Player> db = new LinkedHashMap<>();

    @Override
    public String crete(Player type) {
        db.put()
        return null;
    }

    @Override
    public Optional<Player> findOne(String type) {
        return Optional.empty();
    }

    @Override
    public List<Player> findAll() {
        return null;
    }

    @Override
    public boolean update(Player type) {
        return false;
    }

    @Override
    public boolean deleteByKey(String key) {
        return false;
    }

    @Override
    public boolean delete(Player type) {
        return false;
    }
}
