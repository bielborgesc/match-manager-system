package domain.usecases.player;

import domain.entities.player.Player;
import domain.usecases.utils.dao.DAO;

import java.util.LinkedHashMap;

public interface PlayerDAO extends DAO<String, Player> {
    LinkedHashMap<String, Player> findAllPlayersByIdTeam(Integer idTeam);
    Player findPlayersByIdTeam(String cpfPlayer, Integer idTeam);
}
