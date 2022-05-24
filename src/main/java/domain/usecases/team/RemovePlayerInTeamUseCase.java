package domain.usecases.team;

import domain.entities.player.Player;
import domain.entities.player.StatusEnum;
import domain.usecases.player.PlayerDAO;
import domain.usecases.utils.exceptions.UnavailablePlayerException;

import java.util.Optional;

public class RemovePlayerInTeamUseCase {

  public RemovePlayerInTeamUseCase(PlayerDAO playerDAO) {
    this.playerDAO = playerDAO;
  }

  private PlayerDAO playerDAO;

  public boolean removePlayerInTeam(Optional<Player> player) throws UnavailablePlayerException {
    if (StatusEnum.UNAVAILABLE == playerDAO.findOne(player.get().getCpf()).get().getStatus()) {
      Player playerTeam = new Player(player.get().getName(), player.get().getCpf(), player.get().getGender(), null);
      return playerDAO.update(playerTeam);
    }
    throw new UnavailablePlayerException("Player is available");
  }

}