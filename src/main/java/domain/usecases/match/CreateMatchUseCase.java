package domain.usecases.match;

import domain.entities.match.Match;
import domain.utils.exceptions.EntityAlreadyExistsException;


public class CreateMatchUseCase {
    private MatchDAO matchDAO;

    public CreateMatchUseCase(MatchDAO matchDAO) {
        this.matchDAO = matchDAO;
    }

    public void addMatch(Match match) throws EntityAlreadyExistsException {
        matchDAO.create(match);
    }
}
