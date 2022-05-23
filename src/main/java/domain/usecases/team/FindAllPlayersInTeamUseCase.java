package domain.usecases.team;

import domain.entities.player.Player;
import domain.entities.player.StatusEnum;
import domain.entities.team.Team;
import domain.usecases.player.PlayerDAO;
import domain.usecases.utils.exceptions.UnavailablePlayerException;

import java.util.LinkedHashMap;
import java.util.List;

public class FindAllPlayersInTeamUseCase {

  private PlayerDAO playerDAO;

  public FindAllPlayersInTeamUseCase(PlayerDAO playerDAO) {
    this.playerDAO = playerDAO;
  }

  public LinkedHashMap<String, Player> findAllPlayersInTeam(Integer idTeam) {
    LinkedHashMap<String, Player> players = new LinkedHashMap<>();
    for (Player player : playerDAO.findAll()) {
      if(player.getIdTeam() == idTeam) players.put(player.getCpf(), player);
    }
    return players;
  }


}