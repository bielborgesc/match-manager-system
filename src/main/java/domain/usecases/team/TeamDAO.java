package domain.usecases.team;

import domain.entities.player.Player;
import domain.entities.team.Team;
import domain.usecases.utils.dao.DAO;

import java.util.LinkedHashMap;

public interface TeamDAO extends DAO<Integer, Team> {
}
