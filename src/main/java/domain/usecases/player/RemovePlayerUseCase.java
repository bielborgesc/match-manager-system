package domain.usecases.player;

import domain.entities.player.Player;
import domain.usecases.utils.exceptions.EntityNotFoundException;

public class RemovePlayerUseCase {
    private PlayerDAO playerDAO;

    public RemovePlayerUseCase(PlayerDAO playerDAO) {
        this.playerDAO = playerDAO;
    }

    public boolean remove(Player player) {
        if (player == null || playerDAO.findOne(player.getCpf()).isEmpty()) {
            throw  new EntityNotFoundException("Player is not exists");
        }
        return playerDAO.delete(player);
    }

    public boolean remove(String cpf) {
        if (cpf == null || playerDAO.findOne(cpf).isEmpty()) {
            throw new EntityNotFoundException("Player is not exists");
        }
        return playerDAO.deleteByKey(cpf);
    }

}
