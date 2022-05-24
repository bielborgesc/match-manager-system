package domain.usecases.player;

import domain.entities.player.Player;

import java.util.List;

public class FindPlayerUseCase {
    private PlayerDAO playerDAO;

    public FindPlayerUseCase(PlayerDAO playerDAO) {
        this.playerDAO = playerDAO;
    }

    public Player findOne(String cpf){
        if(cpf == null) {
            throw new IllegalArgumentException("Argument provided is not valid");
        }
        return playerDAO.findOne(cpf);
    }

    public List<Player> findAll(){
        return playerDAO.findAll();
    }

}
