package application.main;


import application.repository.InMemoryMatchDAO;
import application.repository.InMemoryPlayerDAO;
import application.repository.InMemoryRoundDAO;
import application.repository.InMemoryScoreDAO;
import application.repository.InMemoryTeamDAO;
import domain.entities.match.Match;
import domain.entities.player.GenderEnum;
import domain.entities.player.Player;
import domain.entities.round.Round;
import domain.entities.score.Score;
import domain.entities.team.Team;
import domain.usecases.match.*;
import domain.usecases.player.*;
import domain.usecases.round.AddMatchInRoundUseCase;
import domain.usecases.round.CreateRoundUseCase;
import domain.usecases.round.FindRoundUseCase;
import domain.usecases.round.RoundDAO;
import domain.usecases.score.*;
import domain.usecases.team.*;
import domain.usecases.utils.exceptions.EntityAlreadyExistsException;
import domain.usecases.utils.exceptions.UnavailablePlayerException;

import java.util.Optional;

public class Main {

    private static CreatePlayerUseCase createPlayerUseCase;
    private static FindPlayerUseCase findPlayerUseCase;
    private static UpdatePlayerUseCase updatePlayerUseCase;
    private static RemovePlayerUseCase removePlayerUseCase;

    private static CreateTeamUseCase createTeamUseCase;
    private static FindTeamUseCase findTeamUseCase;
    private static UpdateTeamUseCase updateTeamUseCase;
    private static RemoveTeamUseCase removeTeamUseCase;
    private static AddPlayerInTeamUseCase addPlayerInTeamUseCase;
    private static RemovePlayerInTeamUseCase removePlayerInTeamUseCase;
    private static FindAllPlayersInTeamUseCase findAllPlayersInTeamUseCase;
    private static FindOnePlayerInTeamUseCase findOnePlayerInTeamUseCase;

    private static CreateScoreUseCase createScoreUseCase;
    private static FindScoreUseCase findScoreUseCase;
    private static RemoveScoreUseCase removeScoreUseCase;
    private static UpdateScoreUseCase updateScoreUseCase;

    private static CreateMatchUseCase createMatchUseCase;
    private static FindMatchUseCase findMatchUseCase;
    private static SetTeamPointsUseCase setTeamPointsUseCase;
    private static FindMatchByIdTeamUseCase findMatchByIdTeamUseCase;

    private static CreateRoundUseCase createRoundUseCase;
    private static FindRoundUseCase findRoundUseCase;
    private static AddMatchInRoundUseCase addMatchInRoundUseCase;


    public static void main(String[] args) throws EntityAlreadyExistsException, UnavailablePlayerException {
        configureInjection();

//         Players Use Cases
        Player player1 = new Player("Jackson", "46201548", GenderEnum.M);
        Player player2 = new Player("Gabriel", "78451296", GenderEnum.M);
        Player player3 = new Player("Amadeu", "85412047", GenderEnum.M);
        Player player4 = new Player("Fagner", "85417496", GenderEnum.M);

        createPlayerUseCase.insert(player1);
        createPlayerUseCase.insert(player2);
        createPlayerUseCase.insert(player3);
        createPlayerUseCase.insert(player4);

//        System.out.println(findPlayerUseCase.findOne("46201548"));
        Player playerUp = new Player("Jackson Almeida", player1.getCpf(), GenderEnum.M);
        updatePlayerUseCase.update(playerUp);
//        System.out.println(findPlayerUseCase.findOne("46201548"));

//        removePlayerUseCase.remove(player1.getCpf());
//        System.out.println(findPlayerUseCase.findOne("46201548"));


        // Teams Use Cases
        Team team1 = new Team(1, "Springnadando");
        Team team2 = new Team(2, "Reactirando");
        Team teamDel = new Team(3, "Vuesnão");

        createTeamUseCase.insert(team1);
        createTeamUseCase.insert(team2);
        createTeamUseCase.insert(teamDel);

//        System.out.println(findTeamUseCase.findOne(1));
        Team team1Up = new Team(1,"Angularizando");
        updateTeamUseCase.update(team1Up);
//        System.out.println(findTeamUseCase.findOne(1));

        // ADD PLAYER IN TEAM
        addPlayerInTeamUseCase.addPlayerInTeam(Optional.of(player1), team1.getId());
        addPlayerInTeamUseCase.addPlayerInTeam(Optional.of(player2), team1.getId());
        addPlayerInTeamUseCase.addPlayerInTeam(Optional.of(player3), team2.getId());
        addPlayerInTeamUseCase.addPlayerInTeam(Optional.of(player4), team2.getId());
//        addPlayerInTeamUseCase.addPlayerInTeam(Optional.of(player4), teamDel.getId());

        // REMOVENDO PLAYER DO TIME
//        System.out.println(removePlayerInTeamUseCase.removePlayerInTeam(Optional.of(player1)));

//        System.out.println(findPlayerUseCase.findAll());
//        System.out.println(findAllPlayersInTeamUseCase.findAllPlayersInTeam(team1.getId()));

        // REMOVE TEAM
//        System.out.println(findTeamUseCase.findAll());
//        removeTeamUseCase.remove(teamDel);
//        System.out.println(findTeamUseCase.findAll());

        // BUSCANDO PLAYER PELO idTeam
//        System.out.println(findOnePlayerInTeamUseCase.findOnePlayerInTeam(player1.getCpf(), team1.getId()));

        // BUSCAR TIME PELO ID && BUSCAR TODOS
//        System.out.println(findTeamUseCase.findOne(1));
//        System.out.println(findTeamUseCase.findAll());

        // ADICIONAR SCORE NOS TIMES
        Score scoreTeam1 = new Score(team1.getId());
        Score scoreTeam2 = new Score(team2.getId());
        Score scoreTeam3 = new Score(teamDel.getId());
        createScoreUseCase.insert(scoreTeam1);
        createScoreUseCase.insert(scoreTeam2);
        createScoreUseCase.insert(scoreTeam3);

        // LISTAR SCORE DO TIME
//        System.out.println(findScoreUseCase.findOne(team1.getId()));
//        System.out.println(findScoreUseCase.findAll());

        // ATUALIZAR SCORE DO TIME
//        System.out.println(findScoreUseCase.findOne(team2.getId()));
//        Score scoreTeam2Update = new Score(team2.getId());
//        scoreTeam2Update.setWins();
//        updateScoreUseCase.update(scoreTeam2Update);
//        System.out.println(findScoreUseCase.findOne(team2.getId()));

        // REMOVE SCORE DO TIME
//        System.out.println(findScoreUseCase.findOne(team2.getId()));
//        removeScoreUseCase.remove(team2.getId());
//        System.out.println(findScoreUseCase.findOne(team2.getId()));

        // CREATE MATCH
        Match match1 = new Match(1, findTeamUseCase.findOne(1).get(), findTeamUseCase.findOne(2).get());
        Match match2 = new Match(2, findTeamUseCase.findOne(2).get(), findTeamUseCase.findOne(1).get());
        Match matchTest = new Match(3, findTeamUseCase.findOne(3).get(), findTeamUseCase.findOne(2).get());

        createMatchUseCase.addMatch(match1);
        createMatchUseCase.addMatch(match2);
        createMatchUseCase.addMatch(matchTest);
//        System.out.println(findMatchUseCase.findAll());

        // DEFININDO PONTUAÇÃO DA PARTIDA
        match1.setTeamPoints(1,2);
        match2.setTeamPoints(3,3);
        matchTest.setTeamPoints(1,2);
        setTeamPointsUseCase.setTeamPoints(match2);
        setTeamPointsUseCase.setTeamPoints(match1);
        setTeamPointsUseCase.setTeamPoints(matchTest);
//        System.out.println(findMatchUseCase.findAll());
//        System.out.println(findScoreUseCase.findOne(team1.getId()));
//        System.out.println(findScoreUseCase.findOne(team2.getId()));

        // BUSCAR PARTIDA PELO ID DO TIME
//        System.out.println(findMatchByIdTeamUseCase.findMatchByIdTeam(team1.getId()));
//        System.out.println(findMatchByIdTeamUseCase.findMatchByIdTeam(teamDel.getId()));
//        System.out.println(findMatchByIdTeamUseCase.findMatchByIdTeam(team2.getId()));

        // ROUNDs
        Round round1 = new Round(1);
        createRoundUseCase.insert(round1);
//        System.out.println(findRoundUseCase.findOne(1));

        addMatchInRoundUseCase.addMatchInRound(match2.getId(), 1);
//        addMatchInRoundUseCase.addMatchInRound(Optional.of(match2), 1);
//        addMatchInRoundUseCase.addMatchInRound(Optional.of(matchTest), findRoundUseCase.findOne(1).get().getId());

        System.out.println("Find all na main: " + findRoundUseCase.findAll());
//        System.out.println(findRoundUseCase.findAll().get(1));


    }


    private static void configureInjection() {
        PlayerDAO playerDAO = new InMemoryPlayerDAO();
        createPlayerUseCase = new CreatePlayerUseCase(playerDAO);
        findPlayerUseCase = new FindPlayerUseCase(playerDAO);
        updatePlayerUseCase = new UpdatePlayerUseCase(playerDAO);
        removePlayerUseCase = new RemovePlayerUseCase(playerDAO);
        addPlayerInTeamUseCase = new AddPlayerInTeamUseCase(playerDAO);
        findAllPlayersInTeamUseCase = new FindAllPlayersInTeamUseCase(playerDAO);
        findOnePlayerInTeamUseCase = new FindOnePlayerInTeamUseCase(playerDAO);
        removePlayerInTeamUseCase = new RemovePlayerInTeamUseCase(playerDAO);

        TeamDAO teamDAO = new InMemoryTeamDAO();
        createTeamUseCase = new CreateTeamUseCase(teamDAO);
        findTeamUseCase = new FindTeamUseCase(teamDAO);
        updateTeamUseCase = new UpdateTeamUseCase(teamDAO);
        removeTeamUseCase = new RemoveTeamUseCase(teamDAO);

        ScoreDAO scoreDAO = new InMemoryScoreDAO();
        createScoreUseCase = new CreateScoreUseCase(scoreDAO);
        findScoreUseCase = new FindScoreUseCase(scoreDAO);
        removeScoreUseCase = new RemoveScoreUseCase(scoreDAO);
        updateScoreUseCase = new UpdateScoreUseCase(scoreDAO);

        MatchDAO matchDAO = new InMemoryMatchDAO();
        createMatchUseCase = new CreateMatchUseCase(matchDAO);
        findMatchUseCase = new FindMatchUseCase(matchDAO);
        setTeamPointsUseCase = new SetTeamPointsUseCase(matchDAO, scoreDAO);
        findMatchByIdTeamUseCase = new FindMatchByIdTeamUseCase(matchDAO, teamDAO);

        RoundDAO roundDAO = new InMemoryRoundDAO();
        createRoundUseCase = new CreateRoundUseCase(roundDAO);
        findRoundUseCase = new FindRoundUseCase(roundDAO);
        addMatchInRoundUseCase = new AddMatchInRoundUseCase(matchDAO, roundDAO);

    }

}