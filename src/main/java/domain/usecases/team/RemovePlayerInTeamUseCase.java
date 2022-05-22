public class RemovePlayerInTeamUseCase {

  private PlayerDAO playerDAO;
  private TeamDAO teamDAO;

  public RemovePlayerInTeamUseCase(PlayerDAO playerDAO, TeamDAO teamDAO) {
    this.playerDAO = playerDAO;
    this.teamDAO = teamDAO;
  }

  public Integer removePlayer(Player player) throws EntityAlreadyExistsException {
    if (StatusEnum.UNAVAILABLE.compareTo(playerDAO.getStatus()) == 0) {
      return teamDAO.removePlayer(playerDAO);
    }
    throw new AvailablePlayer(); // Caso o player já esteja sem time
  }

}