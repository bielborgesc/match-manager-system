package domain.usecases.score;

import domain.entities.score.Score;

import java.util.List;
import java.util.Optional;

public class FindScoreUseCase {
    private ScoreDAO scoreDAO;

    public FindScoreUseCase(ScoreDAO scoreDAO) {
        this.scoreDAO = scoreDAO;
    }

    public Optional<Score> findOne(Integer idTeam){
        if (idTeam == null) {
            throw new IllegalArgumentException("Argument provided is not valid");
        }
        return scoreDAO.findOne(idTeam);
    }

    public List<Score> findAll(){
        return scoreDAO.findAll();
    }
}
