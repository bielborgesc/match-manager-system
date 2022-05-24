package domain.usecases.match;

import domain.entities.match.Match;
import domain.entities.team.Team;
import domain.usecases.utils.exceptions.EntityAlreadyExistsException;

public class CreateMatchUseCase {
    private MatchDAO matchDAO;

    public CreateMatchUseCase(MatchDAO matchDAO) {
        this.matchDAO = matchDAO;
    }

    public void addTeamsInMatch(Match match) throws EntityAlreadyExistsException {
        matchDAO.create(match);
    }
}
