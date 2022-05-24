package domain.usecases.round;
import domain.entities.round.Round;

import java.util.List;
import java.util.Optional;


public class FindRoundUseCase {
    
    private RoundDAO roundDAO;

    public FindRoundUseCase(RoundDAO roundDAO) {
        this.roundDAO = roundDAO;
    }

    public Optional<Round> findOne(Integer id){
        if(id == null) {
            throw new IllegalArgumentException("Argument provided is not valid");
        }
        return roundDAO.findOne(id);
    }

    public List<Round> findAll(){
        return roundDAO.findAll();
    }

}

