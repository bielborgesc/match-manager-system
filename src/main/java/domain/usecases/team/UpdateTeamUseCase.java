package domain.usecases.team;

import domain.entities.team.Team;
import domain.utils.exceptions.EntityNotFoundException;

public class UpdateTeamUseCase {
    private TeamDAO teamDAO;

    public UpdateTeamUseCase(TeamDAO teamDAO) {
        this.teamDAO = teamDAO;
    }

    public boolean update(Team team) {
        Integer id = team.getId();
        if(teamDAO.findOne(id).isEmpty())
            throw new EntityNotFoundException("Team not found.");

        return teamDAO.update(team);
    }
}
