package domain.usecases.championship;

import domain.entities.championship.Championship;
import domain.entities.round.Round;
import domain.utils.dao.DAO;

public interface ChampionshipDAO extends DAO<Integer, Championship> {
    void addRoundInChampionship(Round round, Integer idChampionship);
}
