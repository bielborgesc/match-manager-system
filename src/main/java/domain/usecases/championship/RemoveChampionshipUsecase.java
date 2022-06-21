package domain.usecases.championship;

import domain.entities.championship.Championship;
import domain.utils.exceptions.EntityNotFoundException;

public class RemoveChampionshipUsecase {
    
    private ChampionshipDAO championshipDAO;


    public RemoveChampionshipUsecase(ChampionshipDAO championshipDAO) {
        this.championshipDAO = championshipDAO;
    }

    public boolean remove(Championship championship) {
        if (championship == null || championshipDAO.findOne(championship.getId()).isEmpty()) {
            throw  new EntityNotFoundException("championship not exists");
        }
        return championshipDAO.delete(championship);
    }

}