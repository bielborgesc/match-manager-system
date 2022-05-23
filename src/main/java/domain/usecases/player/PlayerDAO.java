package domain.usecases.player;

import domain.entities.player.Player;
import domain.usecases.utils.dao.DAO;

public interface PlayerDAO extends DAO<String, Player> {
}
