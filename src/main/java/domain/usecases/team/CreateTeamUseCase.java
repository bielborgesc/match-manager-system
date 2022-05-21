package domain.usecases.team;
import domain.entities.team.Team;
import domain.usecases.utils.exceptions.EntityAlreadyExistsException;

public class CreateTeamUseCase {
    private TeamDAO teamDAO;

    public CreateTeamUseCase(TeamDAO teamDAO) {
        this.teamDAO = teamDAO;
    }

    public Integer insert(Team team) throws EntityAlreadyExistsException {
        if(teamDAO.findOne(team.getId()).isPresent()){
            throw new EntityAlreadyExistsException("Entity already exists");
        }
        return teamDAO.create(team);
    };

}
