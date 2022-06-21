package domain.usecases.championship;

import domain.entities.championship.Championship;

import java.util.List;
import java.util.Optional;

public class FindChampionshipUseCase {
    private ChampionshipDAO championshipDAO;

    public FindChampionshipUseCase(ChampionshipDAO championshipDAO) {
        this.championshipDAO = championshipDAO;
    }

    public Optional<Championship> findOne(Integer id){
        if(id == null) {
            throw new IllegalArgumentException("Argument provided is not valid");
        }
        return championshipDAO.findOne(id);
    }

    public List<Championship> findAll(){
        return championshipDAO.findAll();
    }

}