package domain.usecases.match;

import domain.entities.match.Match;
import domain.usecases.utils.exceptions.EntityNotFoundException;

import java.util.LinkedHashMap;
import java.util.Optional;

public class FindMatchByIdTeamUseCase {

  private MatchDAO matchDAO;

  public FindMatchByIdTeamUseCase(MatchDAO matchDAO) {
    this.matchDAO = matchDAO;
  }

  public LinkedHashMap<Integer, Match> findMatchByIdTeam(Integer idTeam) {
    Optional<Match> match = matchDAO.findOne(idMatch);
    if(match.isEmpty()){
      throw new EntityNotFoundException("Team not found");
    }
    return matchDAO.findMatchByIdTeam(idTeam);
  }

}