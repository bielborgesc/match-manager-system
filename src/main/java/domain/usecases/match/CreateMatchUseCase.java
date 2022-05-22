package domain.usecases.score;

import domain.entities.score.Score;
import domain.usecases.utils.exceptions.EntityAlreadyExistsException;

public class CreateMatchUseCase {
    private MatchDAO matchDAO;
    private TeamDAO firstTeamDAO;
    private TeamDAO secondTeamDAO;

    public CreateScoreUseCase(MatchDAO matchDAO, TeamDAO firstTeamDAO, TeamDAO secondTeamDAO) {
        this.matchDAO = matchDAO;
        this.firstTeamDAO = firstTeamDAO;
        this.secondTeamDAO = secondTeamDAO;
    }

    public Integer addTeamsInMatch() throws EntityAlreadyExistsException {
        return matchDAO.setTeams(this.firstTeamDAO, this.secondTeamDAO);
    }
}
