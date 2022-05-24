package application.repository;

import domain.entities.player.Player;
import domain.entities.team.Team;
import domain.usecases.player.PlayerDAO;
import domain.usecases.team.TeamDAO;

import java.util.*;

public class InMemoryTeamDAO implements TeamDAO {

    private static final Map<Integer, Team> db = new LinkedHashMap<>();


    @Override
    public Integer create(Team team) {
        db.put(team.getId(), team);
        return null;
    }

    @Override
    public Optional<Team> findOne(Integer id) {
        if(db.containsKey(id))
            return Optional.of(db.get(id));
        return Optional.empty();
    }

    @Override
    public List<Team> findAll() {
        return new ArrayList<>(db.values());
    }

    @Override
    public boolean update(Team team) {
        Integer id = team.getId();
        if(db.containsKey(id)) {
            db.replace(id, team);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteByKey(Integer key) {
        if(db.containsKey(key)){
            db.remove(key);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Team team) {
        return deleteByKey(team.getId());
    }

}
