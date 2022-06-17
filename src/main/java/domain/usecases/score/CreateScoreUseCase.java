package domain.usecases.score;

import domain.entities.score.Score;
import domain.utils.exceptions.EntityAlreadyExistsException;

public class CreateScoreUseCase {
    private ScoreDAO scoreDAO;

    public CreateScoreUseCase(ScoreDAO scoreDAO) {
        this.scoreDAO = scoreDAO;
    }

    public Integer insert(Score score) throws EntityAlreadyExistsException {
        if(scoreDAO.findOne(score.getIdTeam()).isPresent()){
            throw new EntityAlreadyExistsException("Entity already exists");
        }
        return scoreDAO.create(score);
    }
}
