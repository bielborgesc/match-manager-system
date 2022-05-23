package domain.usecases.team;

import domain.entities.player.Player;
import domain.entities.player.StatusEnum;
import domain.usecases.player.PlayerDAO;
import domain.usecases.utils.exceptions.UnavailablePlayerException;

public class AddPlayerInTeamUseCase {

  private PlayerDAO playerDAO;

  public AddPlayerInTeamUseCase(PlayerDAO playerDAO) {
    this.playerDAO = playerDAO;
  }

  public boolean addPlayerInTeam(Player player, Integer idTeam) throws UnavailablePlayerException {
      if (StatusEnum.AVAILABLE.compareTo(player.getStatus()) != 0) {
        throw new UnavailablePlayerException("This player is already on a team");
    }
      Player playerTeam = new Player(player.getName(), player.getCpf(), player.getGender(), idTeam);
      return playerDAO.update(playerTeam);
  }

}