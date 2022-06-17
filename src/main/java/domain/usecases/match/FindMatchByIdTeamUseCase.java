package domain.usecases.match;

import domain.entities.match.Match;
import domain.usecases.team.TeamDAO;
import domain.utils.exceptions.EntityNotFoundException;

import java.util.LinkedHashMap;


public class FindMatchByIdTeamUseCase {

  private MatchDAO matchDAO;
  private TeamDAO teamDAO;

  public FindMatchByIdTeamUseCase(MatchDAO matchDAO, TeamDAO teamDAO) {
    this.matchDAO = matchDAO;
    this.teamDAO = teamDAO;
  }

  public LinkedHashMap<Integer, Match> findMatchByIdTeam(Integer idTeam) {
    if(teamDAO.findOne(idTeam).isEmpty()){
      throw new EntityNotFoundException("Team not found");
    }
    return matchDAO.findMatchByIdTeam(idTeam);
  }

}