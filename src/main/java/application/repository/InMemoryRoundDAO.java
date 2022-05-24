package application.repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


import domain.entities.round.Round;
import domain.usecases.round.RoundDAO;

public class InMemoryRoundDAO implements RoundDAO{
    
    private static final Map<Integer, Round> db = new LinkedHashMap<>();

    @Override
    public Integer create(Round round) {
        db.put(round.getId(), round);
        return round.getId();
    }

    @Override
    public Optional<Round> findOne(Integer id) {
        if(db.containsKey(id))
            return Optional.of(db.get(id));
        return Optional.empty();
    }

    @Override
    public List<Round> findAll() {
        return new ArrayList<>(db.values());
    }

    @Override
    public boolean update(Round round) {
        Integer id = round.getId();
        if(db.containsKey(id)) {
            db.replace(id, round);
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
    public boolean delete(Round round) {
        return deleteByKey(round.getId());
    }

}
