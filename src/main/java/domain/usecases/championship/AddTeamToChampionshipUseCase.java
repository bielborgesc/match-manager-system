package domain.usecases.championship;

import domain.entities.championship.Championship;
import domain.entities.team.Team;
import domain.usecases.team.TeamDAO;

public class AddTeamToChampionshipUseCase {
    
    private TeamDAO teamDAO;
    private ChampionshipDAO championshipDAO;


    public AddTeamToChampionshipUseCase(TeamDAO teamDAO, ChampionshipDAO championshipDAO) {
        this.teamDAO = teamDAO;
        this.championshipDAO = championshipDAO;
    }


    public Championship AddTeam(Integer idChampionship, Integer idTeam) {
        Team providedTeam = teamDAO.findOne(idTeam).orElseThrow();
        Championship providedChampionship = championshipDAO.findOne(idChampionship).orElseThrow();

        providedChampionship.addChampionshipTeams(providedTeam);
        
        return providedChampionship;

    }
    

}
