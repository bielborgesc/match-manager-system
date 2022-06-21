package domain.usecases.championship;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import domain.entities.championship.Championship;
import domain.entities.match.Match;
import domain.entities.round.Round;
import domain.entities.team.Team;

public class GenerateTDMChampionshipUseCase {

    private ChampionshipDAO championshipDAO;

    public GenerateTDMChampionshipUseCase(ChampionshipDAO championshipDAO) {

        this.championshipDAO = championshipDAO;
    }

    private Match generateMatchWithPoints(Integer idMatch, Team team1, Team team2) {
        Random random = new Random();
        Match match = new Match(idMatch, team1, team2);
        int pointsA = random.nextInt(10);
        int pointsB = random.nextInt(10);
        match.setTeamPoints(pointsA, pointsB);
        return match;
    }

    public Championship generateTDMChampionship(Integer idChampionship) {
        Championship championship = championshipDAO.findOne(idChampionship).orElseThrow();
        List<Team> teams = championship.getChampionshipTeams();
        int countMatches = 0;
        int idRound = 1;
        int idMatch = 1;
        Round round = new Round(idRound);
        List<Team> teamsNextRound = new ArrayList<>();
        while (teamsNextRound.size() != 1) {
            if (idRound == 1) {
                for (int i = 0; i < teams.size(); i = i + 2) {
                    Team team1 = teams.get(i);
                    try {
                        Team team2 = teams.get(i + 1);
                        Match match = generateMatchWithPoints(idMatch, team1, team2);
                        countMatches++;
                        while (match.getTeamPointsA() == match.getTeamPointsB()) {
                            Random random = new Random();
                            int pointsA = random.nextInt(10);
                            int pointsB = random.nextInt(10);
                            match.setTeamPoints(pointsA, pointsB);
                        }
                        if (match.getTeamPointsA() > match.getTeamPointsB()) {
                            teamsNextRound.add(team1);
                        } else if (match.getTeamPointsB() > match.getTeamPointsA()) {
                            teamsNextRound.add(team2);
                        }
                        round.addNewMatch(match);
                        if (countMatches == (teams.size() / 2)) {
                            championship.addRounds(round);
                            idRound++;
                            round = new Round(idRound);
                            countMatches = 0;
                        }
                    } catch (IndexOutOfBoundsException e) {
                        teamsNextRound.add(team1);
                    }
                }
            }
            else{
                List<Team> teamsNextRoundtemp = new ArrayList<>();
                for (int i = 0; i < teamsNextRound.size(); i = i + 2) {
                    Team team1 = teams.get(i);
                    try {
                        Team team2 = teams.get(i + 1);
                        Match match = generateMatchWithPoints(idMatch, team1, team2);
                        countMatches++;
                        while (match.getTeamPointsA() == match.getTeamPointsB()) {
                            Random random = new Random();
                            int pointsA = random.nextInt(10);
                            int pointsB = random.nextInt(10);
                            match.setTeamPoints(pointsA, pointsB);
                        }
                        if (match.getTeamPointsA() > match.getTeamPointsB()) {
                            teamsNextRoundtemp.add(team1);
                        } else if (match.getTeamPointsB() > match.getTeamPointsA()) {
                            teamsNextRoundtemp.add(team2);
                        }
                        round.addNewMatch(match);
                        if (countMatches == (teams.size() / 2)) {
                            championship.addRounds(round);
                            idRound++;
                            round = new Round(idRound);
                            countMatches = 0;
                        }
                    } catch (IndexOutOfBoundsException e) {
                        teamsNextRound.add(team1);
                    }
                }  
            }
             
        }

        return championship;
    }

}
