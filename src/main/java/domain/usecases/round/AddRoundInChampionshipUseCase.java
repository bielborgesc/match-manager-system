package domain.usecases.round;
import domain.entities.round.Round;
import domain.usecases.championship.ChampionshipDAO;

public class AddRoundInChampionshipUseCase {
    RoundDAO roundDAO;
    ChampionshipDAO championshipDAO;

    public AddRoundInChampionshipUseCase(RoundDAO roundDAO, ChampionshipDAO championshipDAO) {
        this.roundDAO = roundDAO;
        this.championshipDAO = championshipDAO;
    }

    public void AddRoundInChampionship(Integer idRound, Integer idChampionship){
        if(roundDAO.findOne(idRound).isPresent()){
            Round round = roundDAO.findOne(idRound).get();
             championshipDAO.addRoundInChampionship(round, idChampionship);
         }
    }

}
