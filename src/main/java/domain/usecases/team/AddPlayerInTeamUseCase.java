package domain.usecases.team;

import domain.entities.player.Player;
import domain.entities.player.StatusEnum;
import domain.usecases.player.PlayerDAO;
import domain.usecases.utils.exceptions.UnavailablePlayerException;

import java.util.Optional;

public class AddPlayerInTeamUseCase {

  private PlayerDAO playerDAO;

  public AddPlayerInTeamUseCase(PlayerDAO playerDAO) {
    this.playerDAO = playerDAO;
  }

  public boolean addPlayerInTeam(Optional<Player> player, Integer idTeam) throws UnavailablePlayerException {
    if (playerDAO.findOne(player.get().getCpf()).isPresent() && playerDAO.findOne(player.get().getCpf()).get().getStatus() == StatusEnum.AVAILABLE) {
      Player playerTeam = new Player(player.get().getName(), player.get().getCpf(), player.get().getGender(), idTeam);
      return playerDAO.update(playerTeam);
    }
    throw new UnavailablePlayerException("This player is already on a team");
  }

}