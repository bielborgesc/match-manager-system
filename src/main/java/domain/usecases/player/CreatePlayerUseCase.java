package domain.usecases.player;

import domain.entities.player.Player;
import domain.utils.exceptions.EntityAlreadyExistsException;

public class CreatePlayerUseCase {
    private PlayerDAO playerDAO;

    public CreatePlayerUseCase(PlayerDAO playerDAO) {
        this.playerDAO = playerDAO;
    }

    public String insert(Player player) throws EntityAlreadyExistsException {
        if(playerDAO.findOne(player.getCpf()).isEmpty()){
            throw new EntityAlreadyExistsException("Entity already exists");
        }
        return playerDAO.crete(player);
    }

}
