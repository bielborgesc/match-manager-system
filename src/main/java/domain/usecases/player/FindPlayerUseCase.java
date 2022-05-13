package domain.usecases.player;

import domain.entities.player.Player;

import java.util.List;
import java.util.Optional;

public class FindPlayerUseCase {
    private PlayerDAO playerDAO;

    public FindPlayerUseCase(PlayerDAO playerDAO) {
        this.playerDAO = playerDAO;
    }

    public Optional<Player> findOne(String cpf){
        if(cpf == null) {
            throw new IllegalArgumentException("Argument provided is not valid");
        }
        return playerDAO.findOne(cpf);
    }

    public List<Player> findAll(){
        return playerDAO.findAll();
    }

}
