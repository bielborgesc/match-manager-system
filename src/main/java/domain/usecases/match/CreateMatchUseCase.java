package domain.usecases.match;

import domain.entities.match.Match;
import domain.entities.team.Team;
import domain.usecases.utils.exceptions.EntityAlreadyExistsException;

public class CreateMatchUseCase {
    private Match match;
    private Team firstTeam;
    private Team secondTeam;

    public CreateMatchUseCase(Match match, Team firstTeam, Team secondTeam) {
        this.match = match;
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
    }

    public void addTeamsInMatch() throws EntityAlreadyExistsException {
        match.setTeams(this.firstTeam, this.secondTeam);
    }
}
