package domain.usecases.team;

import domain.entities.player.Player;
import domain.usecases.player.PlayerDAO;

import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.Optional;

public class FindOnePlayerInTeamUseCase {

  private PlayerDAO playerDAO;

  public FindOnePlayerInTeamUseCase(PlayerDAO playerDAO) {
    this.playerDAO = playerDAO;
  }

  public Player findOnePlayerInTeam(String cpf, Integer idTeam) {
    LinkedHashMap<String, Player> playersInTeam = (LinkedHashMap<String, Player>) playerDAO.findAll();
    for (Player player : playersInTeam.values()) {
        if(Objects.equals(player.getCpf(), cpf)) return player;
    }
    return null;
  }

}