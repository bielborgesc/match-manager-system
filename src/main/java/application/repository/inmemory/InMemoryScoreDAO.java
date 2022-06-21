package application.repository.inmemory;

import domain.entities.score.Score;
import domain.usecases.score.ScoreDAO;

import java.util.*;

public class InMemoryScoreDAO implements ScoreDAO {

    private static final Map<Integer, Score> db = new LinkedHashMap<>();


    @Override
    public Integer create(Score score) {
        db.put(score.getIdTeam(), score);
        return null;
    }

    @Override
    public Optional<Score> findOne(Integer idTeam) {
        if(db.containsKey(idTeam))
            return Optional.of(db.get(idTeam));
        return Optional.empty();
    }

    @Override
    public List<Score> findAll() {
        return new ArrayList<>(db.values());
    }

    @Override
    public boolean update(Score score) {
        Integer idTeam = score.getIdTeam();
        if(db.containsKey(idTeam)) {
            db.replace(idTeam, score);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteByKey(Integer idTeam) {
        if(db.containsKey(idTeam)){
            db.remove(idTeam);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Score score) {
        return deleteByKey(score.getIdTeam());
    }
}
