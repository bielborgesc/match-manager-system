package domain.usecases.championship;

import domain.entities.championship.Championship;
import domain.entities.match.Match;
import domain.entities.round.Round;
import domain.entities.score.Score;
import domain.entities.team.Team;
import domain.usecases.score.ScoreDAO;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class GenerateTurnAndReturnChampionshipUseCase {

    private ChampionshipDAO championshipDAO;
    private ScoreDAO scoreDAO;

    public GenerateTurnAndReturnChampionshipUseCase(ChampionshipDAO championshipDAO, ScoreDAO scoreDAO) {
        this.championshipDAO = championshipDAO;
        this.scoreDAO = scoreDAO;
    }

     private void generateScore(Match match){
        if(match.getTeamPointsA() > match.getTeamPointsB()){
            scoreDAO.findOne(match.getTeamA().getId()).orElseThrow().addWin();
            scoreDAO.findOne(match.getTeamB().getId()).orElseThrow().addLose();
        }
        else if(match.getTeamPointsA() < match.getTeamPointsB()){
            scoreDAO.findOne(match.getTeamB().getId()).orElseThrow().addWin();
            scoreDAO.findOne(match.getTeamA().getId()).orElseThrow().addLose();
        }
        else{
            scoreDAO.findOne(match.getTeamB().getId()).orElseThrow().addEven();
            scoreDAO.findOne(match.getTeamA().getId()).orElseThrow().addEven();
        }
     }

    private Match generateMatchWithPoints(Integer idMatch, Team team1, Team team2) {
        Random random = new Random();
        Match match = new Match(idMatch, team1, team2);
        int pointsA = random.nextInt(10);
        int pointsB = random.nextInt(10);
        match.setTeamPoints(pointsA, pointsB);
        return match;
    }

    public List<Score> generateResult(int idChampionship){
        List<Score> resultTable = new ArrayList<>();
        Championship championshipResult =  generate(idChampionship);
        List<Team> teams = championshipResult.getChampionshipTeams();
        for (Team team : teams) {
            resultTable.add(scoreDAO.findOne(team.getId()).orElseThrow());
        }
        resultTable.sort(Comparator.comparingInt(Score::getPoints).reversed());
        return resultTable;
    }

    private Championship generate(Integer idChampionship) {
        Championship championship = championshipDAO.findOne(idChampionship).orElseThrow();
        List<Team> teams = championship.getChampionshipTeams();
        int countMatches = 0;
        int idRound = 1;
        int idMatch = 1;
        Round round = new Round(idRound);
        for (Team team1 : teams) {
            for (Team team2 : teams) {
                if (team1 != team2) {
                    Match match = generateMatchWithPoints(idMatch, team1, team2);
                    countMatches++;
                    generateScore(match);
                    round.addNewMatch(match);
                    if (countMatches == (teams.size() / 2)) {
                        championship.addRounds(round);
                        idRound++;
                        round = new Round(idRound);
                        countMatches = 0;
                    }
                }
            }
        }
        return championship;
    }

}
