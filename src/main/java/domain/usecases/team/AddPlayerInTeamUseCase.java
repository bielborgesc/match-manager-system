public class AddPlayerInTeamUseCase {

  private PlayerDAO playerDAO;
  private TeamDAO teamDAO;

  public AddPlayerInTeamUseCase(PlayerDAO playerDAO, TeamDAO teamDAO) {
    this.playerDAO = playerDAO;
    this.teamDAO = teamDAO;
  }

  public Integer addPlayer(Player player) throws EntityAlreadyExistsException {
    if (StatusEnum.AVAILABLE.compareTo(playerDAO.getStatus()) == 0) {
      return teamDAO.addPlayer(playerDAO);
    }
    throw new UnavailablePlayer();
  }

}