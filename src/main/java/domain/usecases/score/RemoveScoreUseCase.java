package domain.usecases.score;

import domain.entities.score.Score;
import domain.usecases.utils.exceptions.EntityNotFoundException;

public class RemoveScoreUseCase {
    private ScoreDAO scoreDAO;

    public RemoveScoreUseCase(ScoreDAO scoreDAO) {
        this.scoreDAO = scoreDAO;
    }

    public boolean remove(Score score) {
        if (score == null || scoreDAO.findOne(score.getIdTeam()).isEmpty()) {
            throw new EntityNotFoundException("Score not exists");
        }
        return scoreDAO.delete(score);
    }

    public boolean remove(Integer idTeam) {
        if (idTeam == null || scoreDAO.findOne(idTeam).isEmpty()) {
            throw new EntityNotFoundException("Score not exists");
        }
        return scoreDAO.deleteByKey(idTeam);
    }
}
