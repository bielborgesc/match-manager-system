package application.repository;

import domain.entities.player.Player;
import domain.usecases.player.PlayerDAO;

import java.util.*;

public class InMemoryPlayerDAO implements PlayerDAO {

    private static final Map<String, Player> db = new LinkedHashMap<>();

    @Override
    public String crete(Player player) {
        db.put(player.getCpf(), player);
        return player.getCpf();
    }

    @Override
    public Optional<Player> findOne(String cpf) {
        if(db.containsKey(cpf))
            return Optional.of(db.get(cpf));
        return Optional.empty();
    }

    @Override
    public List<Player> findAll() {
        return new ArrayList<>(db.values());
    }

    @Override
    public boolean update(Player player) {
        String cpf = player.getCpf();
        if(db.containsKey(cpf)) {
            db.replace(cpf, player);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteByKey(String cpf) {
        if(db.containsKey(cpf)){
            db.remove(cpf);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Player player) {
        return deleteByKey(player.getCpf());
    }
}
