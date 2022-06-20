package application.main;

import application.repository.inmemory.*;
import domain.entities.championship.CategoryEnum;
import domain.entities.championship.Championship;
import domain.entities.championship.TypeEnum;
import domain.entities.score.Score;
import domain.entities.team.Team;
import domain.usecases.admin.*;
import domain.usecases.championship.ChampionshipDAO;
import domain.usecases.championship.CreateChampionshipUseCase;
import domain.usecases.championship.FindChampionshipUseCase;
import domain.usecases.championship.GenerateTurnAndReturnChampionshipUseCase;
import domain.usecases.match.*;
import domain.usecases.round.*;
import domain.usecases.score.*;
import domain.usecases.team.*;
import domain.utils.exceptions.EntityAlreadyExistsException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Date;

public class Main2{
    private static CreateTeamUseCase createTeamUseCase;
    private static FindTeamUseCase findTeamUseCase;
    private static UpdateTeamUseCase updateTeamUseCase;
    private static RemoveTeamUseCase removeTeamUseCase;

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

    private static AddRoundInChampionshipUseCase addRoundInChampionshipUseCase;
    private static CreateChampionshipUseCase createChampionshipUseCase;
    private static FindChampionshipUseCase findChampionshipUseCase;
    private static GenerateTurnAndReturnChampionshipUseCase generateTurnAndReturnChampionshipUseCase;

    private static FindAdminUseCase findAdminUseCase;
    private static RemoveAdminUseCase removeAdminUseCase;
    private static UpdateAdminUseCase updateAdminUseCase;
    private static CreateAdminUseCase createAdminUseCase;


    public static void main(String[] args) throws EntityAlreadyExistsException {
        configureInjection();
        // Criando Times
        createTeamUseCase.insert(new Team(1, "Corinthias"));
        createTeamUseCase.insert(new Team(2,"São Paulo"));
        createTeamUseCase.insert(new Team(3, "Bahia"));
        createTeamUseCase.insert(new Team(4, "Santos"));
        createTeamUseCase.insert(new Team(5, "Sporte"));
        createTeamUseCase.insert(new Team(6, "Juninho"));
        createTeamUseCase.insert(new Team(7, "Palmeiras"));
        createTeamUseCase.insert(new Team(8, "Renato"));

        //Criando Classificações
        createScoreUseCase.insert(new Score(1));
        createScoreUseCase.insert(new Score(2));
        createScoreUseCase.insert(new Score(3));
        createScoreUseCase.insert(new Score(4));
        createScoreUseCase.insert(new Score(5));
        createScoreUseCase.insert(new Score(6));
        createScoreUseCase.insert(new Score(7));
        createScoreUseCase.insert(new Score(8));

        //Criando campeonato
        createChampionshipUseCase.insert(new Championship(1,  "Brasileirão",  new Date(), TypeEnum.FUTEBOL, CategoryEnum.ADULT));

        //Adicionando Timems em campeonato
        findChampionshipUseCase.findOne(1).orElseThrow().addChampionshipTeams(findTeamUseCase.findOne(1).orElseThrow());
        findChampionshipUseCase.findOne(1).orElseThrow().addChampionshipTeams(findTeamUseCase.findOne(2).orElseThrow());
        findChampionshipUseCase.findOne(1).orElseThrow().addChampionshipTeams(findTeamUseCase.findOne(3).orElseThrow());
        findChampionshipUseCase.findOne(1).orElseThrow().addChampionshipTeams(findTeamUseCase.findOne(4).orElseThrow());


        //Gerando Campeonato
        Championship championship = generateTurnAndReturnChampionshipUseCase.generate(1);
//        System.out.println(championship.getRounds());

    }


    private static void configureInjection() {
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

        ChampionshipDAO championshipDAO = new InMemoryChampionshipDAO();
        addRoundInChampionshipUseCase = new AddRoundInChampionshipUseCase(roundDAO, championshipDAO);
        createChampionshipUseCase = new CreateChampionshipUseCase(championshipDAO);
        findChampionshipUseCase = new FindChampionshipUseCase(championshipDAO);
        generateTurnAndReturnChampionshipUseCase = new GenerateTurnAndReturnChampionshipUseCase(championshipDAO);


        AdminDAO adminDAO = new InMemoryAdminDAO();
        createAdminUseCase = new CreateAdminUseCase(adminDAO);
        findAdminUseCase = new FindAdminUseCase(adminDAO);
        removeAdminUseCase = new RemoveAdminUseCase(adminDAO);
        updateAdminUseCase = new UpdateAdminUseCase(adminDAO);

    }

}