package domain.usecases.match;

import domain.entities.match.Match;

import java.util.List;
import java.util.Optional;

public class FindMatchUseCase {
    private MatchDAO matchDAO;

    public FindMatchUseCase(MatchDAO matchDAO) {
        this.matchDAO = matchDAO;
    }

    public Optional<Match> findOne(Integer idMatch) {
        if (idMatch == null) {
            throw new IllegalArgumentException("Argument provided is not valid");
        }
        return matchDAO.findOne(idMatch);
    }

    public List<Match> findAll(){
        return matchDAO.findAll();
    }
}