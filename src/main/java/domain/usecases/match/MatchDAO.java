package domain.usecases.match;

import domain.entities.match.Match;
import domain.utils.dao.DAO;

import java.util.LinkedHashMap;

public interface MatchDAO extends DAO<Integer, Match> {

    LinkedHashMap<Integer, Match> findMatchByIdTeam(Integer idTeam);
}
