package domain.usecases.championship;

import domain.entities.championship.Championship;
import domain.entities.round.Round;
import domain.entities.team.Team;
import domain.utils.dao.DAO;

import java.util.List;

public interface ChampionshipDAO extends DAO<Integer, Championship> {
    void addRoundInChampionship(Round round, Integer idChampionship);
    void addTeamInChampionship(Team team, Integer idChampionship);
    List<Round> getRoundsInChampionship(Integer idChampionship);
    List<Team> getTeamsInChampionship(Integer idChampionship);
}
