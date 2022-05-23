package domain.usecases.team;

import domain.entities.player.Player;
import domain.entities.player.StatusEnum;
import domain.usecases.player.PlayerDAO;
import domain.usecases.utils.exceptions.EntityNotFoundException;
import domain.usecases.utils.exceptions.UnavailablePlayerException;

public class RemovePlayerInTeamUseCase {

  public RemovePlayerInTeamUseCase(PlayerDAO playerDAO) {
    this.playerDAO = playerDAO;
  }

  private PlayerDAO playerDAO;

  public boolean removePlayerInTeam(Player player) throws UnavailablePlayerException {
    if (StatusEnum.UNAVAILABLE.compareTo(player.getStatus()) == 0) {
      Player playerTeam = new Player(player.getName(), player.getCpf(), player.getGender(), null);
      return playerDAO.update(playerTeam);
    }
    throw new UnavailablePlayerException("Player not found");
  }

}