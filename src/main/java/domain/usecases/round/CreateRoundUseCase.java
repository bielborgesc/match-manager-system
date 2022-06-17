package domain.usecases.round;

import domain.entities.round.Round;
import domain.utils.exceptions.EntityAlreadyExistsException;

public class CreateRoundUseCase {
    private RoundDAO roundDAO;

    public CreateRoundUseCase(RoundDAO roundDAO) {
        this.roundDAO = roundDAO;
    }

    public Integer insert(Round round) throws EntityAlreadyExistsException {
        if(roundDAO.findOne(round.getId()).isPresent()){
            throw new EntityAlreadyExistsException("Entity already exists");
        }
        return roundDAO.create(round);
    }
}
