package application.main;


import application.repository.InMemoryPlayerDAO;
import domain.entities.player.GenderEnum;
import domain.entities.player.Player;
import domain.usecases.player.*;
import domain.utils.exceptions.EntityAlreadyExistsException;

public class Main {

    private static CreatePlayerUseCase createPlayerUseCase;
    private static FindPlayerUseCase findPlayerUseCase;
    private static UpdatePlayerUseCase updatePlayerUseCase;
    private static RemovePlayerUseCase removePlayerUseCase;

    public static void main(String[] args) throws EntityAlreadyExistsException {
        configureInjection();

        Player player1 = new Player("Jackson", "46201548", GenderEnum.M);
        Player player2 = new Player("Gabriel", "78451296", GenderEnum.M);
        Player player3 = new Player("Amadeu", "85412047", GenderEnum.M);
        Player player4 = new Player("Fagner", "85417496", GenderEnum.M);

        createPlayerUseCase.insert(player1);
        createPlayerUseCase.insert(player2);
        createPlayerUseCase.insert(player3);
        createPlayerUseCase.insert(player4);
        
    }

    private static void configureInjection() {
        PlayerDAO playerDAO = new InMemoryPlayerDAO();
        createPlayerUseCase = new CreatePlayerUseCase(playerDAO);
        findPlayerUseCase = new FindPlayerUseCase(playerDAO);
        updatePlayerUseCase = new UpdatePlayerUseCase(playerDAO);
        removePlayerUseCase = new RemovePlayerUseCase(playerDAO);
    }

}