package application.repository.inmemory;

import domain.entities.match.Match;
import domain.usecases.match.MatchDAO;

import java.util.*;

public class InMemoryMatchDAO implements MatchDAO {

    private static final Map<Integer, Match> db = new LinkedHashMap<>();


    @Override
    public Integer create(Match match) {
        db.put(match.getId(), match);
        return match.getId();
    }

    @Override
    public Optional<Match> findOne(Integer id) {
        if(db.containsKey(id))
            return Optional.of(db.get(id));
        return Optional.empty();
    }

    @Override
    public List<Match> findAll() {
        return new ArrayList<>(db.values());
    }

    @Override
    public boolean update(Match match) {
        Integer id = match.getId();
        if(db.containsKey(id)) {
            db.replace(id, match);
            return true;
        }
        return false;
    }

    @Override
    public LinkedHashMap<Integer, Match> findMatchByIdTeam(Integer idTeam) {
        LinkedHashMap<Integer, Match> arrMatches = new LinkedHashMap<>();
        for (Match match : db.values()) {
            if (match.getTeamA().getId() == idTeam || match.getTeamB().getId() == idTeam) {
                arrMatches.put(match.getId(), match);
            }
        }
        return arrMatches;
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
    public boolean delete(Match match) {
        return deleteByKey(match.getId());
    }

}
