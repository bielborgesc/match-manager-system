package domain.usecases.team;

import domain.entities.team.Team;
import java.util.List;
import java.util.Optional;

public class FindTeamUseCase {
    private TeamDAO teamDAO;

    public FindTeamUseCase(TeamDAO teamDAO) {
        this.teamDAO = teamDAO;
    }

    public Optional<Team> findOne(Integer id){
        if(id == null) {
            throw new IllegalArgumentException("Argument provided is not valid");
        }
        return teamDAO.findOne(id);
    }

    public List<Team> findAll(){
        return teamDAO.findAll();
    }
}
