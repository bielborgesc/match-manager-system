package domain.usecases.player;

import domain.entities.player.Player;
import domain.utils.exceptions.EntityNotFoundException;

public class UpdatePlayerUseCase {
    private PlayerDAO playerDAO;

    public UpdatePlayerUseCase(PlayerDAO playerDAO) {
        this.playerDAO = playerDAO;
    }

    public boolean update(Player player){
        String cpf = player.getCpf();
        if(playerDAO.findOne(cpf).isEmpty())
            throw new EntityNotFoundException("Player not found.");

        return playerDAO.update(player);
    }

}
