package domain.usecases.round;

import domain.entities.round.Round;

public class CreateRoundUseCase {
    private RoundDAO roundDAO;

    public CreateRoundUseCase(RoundDAO roundDAO) {
        this.roundDAO = roundDAO;
    }

    public Integer insert(Round round){
        return roundDAO.create(round);
    }
}
