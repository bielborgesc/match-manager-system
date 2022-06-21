package domain.usecases.team;

import domain.entities.team.Team;
import domain.utils.exceptions.EntityNotFoundException;

public class RemoveTeamUseCase {
    private TeamDAO teamDAO;

    public RemoveTeamUseCase(TeamDAO teamDAO) {
        this.teamDAO = teamDAO;
    }

    public boolean remove(Team team) {
        if (team == null || teamDAO.findOne(team.getId()).isEmpty()) {
            throw  new EntityNotFoundException("Team not exists");
        }
        return teamDAO.delete(team);
    }

    public boolean remove(Integer id) {
        if (id == null || teamDAO.findOne(id).isEmpty()) {
            throw new EntityNotFoundException("Team not exists");
        }
        return teamDAO.deleteByKey(id);
    }
}
