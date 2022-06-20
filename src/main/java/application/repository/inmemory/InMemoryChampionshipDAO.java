package application.repository.inmemory;

import domain.entities.championship.Championship;
import domain.entities.round.Round;
import domain.entities.team.Team;
import domain.usecases.championship.ChampionshipDAO;

import java.util.*;

public class InMemoryChampionshipDAO implements ChampionshipDAO {

    private static final Map<Integer, Championship> db = new LinkedHashMap<>();

    @Override
    public void addRoundInChampionship(Round round, Integer idChampionship) {
        if(db.containsKey(idChampionship)){
            Championship championship = findOne(idChampionship).orElseThrow();
            championship.addRounds(round);
            db.put(championship.getId(), championship);
        }
    }

    @Override
    public void addTeamInChampionship(Team team, Integer idChampionship) {
        if(db.containsKey(idChampionship)){
            Championship championship = findOne(idChampionship).orElseThrow();
            championship.addChampionshipTeams(team);
            db.put(championship.getId(), championship);
        }
    }

    @Override
    public Integer create(Championship championship) {
        db.put(championship.getId(), championship);
        return championship.getId();
    }


    @Override
    public Optional<Championship> findOne(Integer id) {
        if(db.containsKey(id))
            return Optional.of(db.get(id));
        return Optional.empty();
    }



    @Override
    public List<Championship> findAll() {
        return new ArrayList<>(db.values());
    }

    @Override
    public boolean update(Championship championship) {
        Integer id = championship.getId();
        if(db.containsKey(id)) {
            db.replace(id, championship);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteByKey(Integer id) {
        if(db.containsKey(id)){
            db.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Championship championship) {
        return deleteByKey(championship.getId());
    }
}
