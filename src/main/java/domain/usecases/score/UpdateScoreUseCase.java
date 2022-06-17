package domain.usecases.score;

import domain.entities.score.Score;
import domain.utils.exceptions.EntityNotFoundException;

public class UpdateScoreUseCase {
    private ScoreDAO scoreDAO;

    public UpdateScoreUseCase(ScoreDAO scoreDAO) {
        this.scoreDAO = scoreDAO;
    }

    public boolean update(Score score) {
        Integer id = score.getIdTeam();
        if(scoreDAO.findOne(id).isEmpty())
            throw new EntityNotFoundException("Score not found.");

        return scoreDAO.update(score);
    }
}
