package domain.usecases.team;

import domain.entities.player.Player;
import domain.usecases.player.PlayerDAO;

import java.util.LinkedHashMap;

public class FindAllPlayersInTeamUseCase {

  private PlayerDAO playerDAO;

  public FindAllPlayersInTeamUseCase(PlayerDAO playerDAO) {
    this.playerDAO = playerDAO;
  }

  public LinkedHashMap<String, Player> findAllPlayersInTeam(Integer idTeam) {
    return playerDAO.findAllPlayersByIdTeam(idTeam);
  }
}