package application.main;

import application.repository.inmemory.*;
import domain.entities.championship.CategoryEnum;
import domain.entities.championship.Championship;
import domain.entities.championship.TypeEnum;
import domain.entities.match.Match;
import domain.entities.round.Round;
import domain.entities.score.Score;
import domain.entities.team.Team;
import domain.usecases.admin.*;
import domain.usecases.championship.*;
import domain.usecases.match.*;
import domain.usecases.round.*;
import domain.usecases.score.*;
import domain.usecases.team.*;
import domain.utils.exceptions.EntityAlreadyExistsException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import view.controller.ChampionshipManagementController;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main extends Application{
    public static CreateTeamUseCase createTeamUseCase;
    public static FindTeamUseCase findTeamUseCase;
    public static UpdateTeamUseCase updateTeamUseCase;
    public static RemoveTeamUseCase removeTeamUseCase;
    
    public static CreateScoreUseCase createScoreUseCase;
    public static FindScoreUseCase findScoreUseCase;
    public static RemoveScoreUseCase removeScoreUseCase;
    public static UpdateScoreUseCase updateScoreUseCase;
    
    public static CreateMatchUseCase createMatchUseCase;
    public static FindMatchUseCase findMatchUseCase;
    public static SetTeamPointsUseCase setTeamPointsUseCase;
    public static FindMatchByIdTeamUseCase findMatchByIdTeamUseCase;
    
    public static CreateRoundUseCase createRoundUseCase;
    public static FindRoundUseCase findRoundUseCase;
    public static AddMatchInRoundUseCase addMatchInRoundUseCase;
    
    public static AddRoundInChampionshipUseCase addRoundInChampionshipUseCase;
    public static RemoveChampionshipUsecase removeChampionshipUsecase;
    public static CreateChampionshipUseCase createChampionshipUseCase;
    public static FindChampionshipUseCase findChampionshipUseCase;
    public static GenerateTurnAndReturnChampionshipUseCase generateTurnAndReturnChampionshipUseCase;
    
    public static FindAdminUseCase findAdminUseCase;
    public static RemoveAdminUseCase removeAdminUseCase;
    public static UpdateAdminUseCase updateAdminUseCase;
    public static CreateAdminUseCase createAdminUseCase;

    

    private static Scene primaryScene;

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/MainUI.fxml"));
            Parent parent = loader.load();
            primaryScene = new Scene(parent);
            primaryStage.setScene(primaryScene);
            primaryStage.setResizable(false);

            primaryStage.setTitle("Match Manager System");
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Stage changeScene(String fxml) throws IOException{
        Parent pane =  FXMLLoader.load(getClass().getResource(fxml));
        Scene scene = new Scene(pane);
        Stage thisStage = new Stage();
        thisStage.setScene(scene);
        return thisStage;
    }

    
    public static Scene getPrimaryScene() {
        return primaryScene;
    }

    public static void main(String[] args) throws ParseException, EntityAlreadyExistsException {
       
        configureInjection();
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Championship c1 = new Championship(1, "Test1", dateFormat.parse("20-02-2030"), TypeEnum.FUTEBOL, CategoryEnum.ADULT);
        Championship c2 = new Championship(2, "Test1", dateFormat.parse("20-03-2010"), TypeEnum.FUTEBOL, CategoryEnum.ADULT);
        
        Team t1 = new Team(1,"Bahia");
        Team t2 = new Team(3,"Bahia");
        Team t3 = new Team(4,"Bahia");

        createTeamUseCase.insert(t1);
        createTeamUseCase.insert(t3);
        createTeamUseCase.insert(t2);

        createChampionshipUseCase.insert(c1);
        createChampionshipUseCase.insert(c2);

        launch(args);;

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
        generateTurnAndReturnChampionshipUseCase = new GenerateTurnAndReturnChampionshipUseCase(championshipDAO, scoreDAO);
        removeChampionshipUsecase = new RemoveChampionshipUsecase(championshipDAO);

        AdminDAO adminDAO = new InMemoryAdminDAO();
        createAdminUseCase = new CreateAdminUseCase(adminDAO);
        findAdminUseCase = new FindAdminUseCase(adminDAO);
        removeAdminUseCase = new RemoveAdminUseCase(adminDAO);
        updateAdminUseCase = new UpdateAdminUseCase(adminDAO);

    }

}