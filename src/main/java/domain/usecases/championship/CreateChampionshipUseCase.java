package domain.usecases.championship;

import domain.entities.championship.Championship;
import domain.usecases.utils.exceptions.EntityAlreadyExistsException;

public class CreateChampionshipUseCase {
    private ChampionshipDAO championshipDAO;

    public CreateChampionshipUseCase(ChampionshipDAO championshipDAO) {
        this.championshipDAO = championshipDAO;
    }

    public Integer insert(Championship championship) throws EntityAlreadyExistsException {
        if(championshipDAO.findOne(championship.getId()).isPresent()){
            throw new EntityAlreadyExistsException("Entity already exists");
        }
        return championshipDAO.create(championship);
    }

}
