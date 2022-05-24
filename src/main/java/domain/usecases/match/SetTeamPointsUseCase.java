package domain.usecases.match;

import domain.entities.match.Match;
import domain.entities.score.Score;
import domain.usecases.score.ScoreDAO;
import domain.usecases.utils.exceptions.EntityNotFoundException;

import java.util.Optional;

public class SetTeamPointsUseCase {
    private MatchDAO matchDAO;
    private ScoreDAO scoreDAO;

    public SetTeamPointsUseCase(MatchDAO matchDAO, ScoreDAO scoreDAO) {
        this.matchDAO = matchDAO;
        this.scoreDAO = scoreDAO;
    }

    public boolean setTeamPoints(Match match)  {
        if(matchDAO.findOne(match.getId()).isEmpty()){
            throw new EntityNotFoundException("Match is not found");
        }
        match.setTeamPoints(match.getTeamPointsA(), match.getTeamPointsB());
        setScore(match);
        return matchDAO.update(match);
    }

    private void setScore(Match match){
        Integer idTeamA = match.getTeamA().getId();
        Integer idTeamB = match.getTeamB().getId();
        Score scoreTeamA = new Score(idTeamA);
        scoreTeamA.setLoses(scoreDAO.findOne(idTeamA).get().getLoses());
        scoreTeamA.setEven(scoreDAO.findOne(idTeamA).get().getEven());
        scoreTeamA.setWins(scoreDAO.findOne(idTeamA).get().getWinds());
        Score scoreTeamB = new Score(idTeamB);
        scoreTeamB.setLoses(scoreDAO.findOne(idTeamB).get().getLoses());
        scoreTeamB.setEven(scoreDAO.findOne(idTeamB).get().getEven());
        scoreTeamB.setWins(scoreDAO.findOne(idTeamB).get().getWinds());

        if(match.getTeamPointsA() > match.getTeamPointsB()){
            scoreTeamA.setWins( scoreTeamA.getWinds() + 1);
            scoreTeamB.setLoses(scoreTeamB.getLoses() + 1);
        } else if(match.getTeamPointsA()  < match.getTeamPointsB()){
            scoreTeamA.setLoses(scoreTeamA.getLoses() + 1);
            scoreTeamB.setWins(scoreTeamB.getWinds() + 1);
        } else {
            scoreTeamA.setEven(scoreTeamA.getEven() + 1);
            scoreTeamB.setEven(scoreTeamB.getEven() + 1);
        }

        scoreDAO.update(scoreTeamA);
        scoreDAO.update(scoreTeamB);
    }
}
