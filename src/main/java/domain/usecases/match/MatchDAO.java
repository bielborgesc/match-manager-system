package domain.usecases.match;

import domain.entities.match.Match;
import domain.utils.dao.DAO;

public interface MatchDAO extends DAO<Integer, Match> {
    Match findMatchByIdTeam(Integer idTeam);
}
