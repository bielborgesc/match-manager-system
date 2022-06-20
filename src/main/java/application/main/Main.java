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
import domain.usecases.championship.ChampionshipDAO;
import domain.usecases.championship.CreateChampionshipUseCase;
import domain.usecases.championship.FindChampionshipUseCase;
import domain.usecases.championship.GenerateTurnAndReturnChampionshipUseCase;
import domain.usecases.match.*;
import domain.usecases.round.*;
import domain.usecases.score.*;
import domain.usecases.team.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.Date;

public class Main extends Application{
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

    public static void main(String[] args) {
       
        configureInjection();

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
        generateTurnAndReturnChampionshipUseCase = new GenerateTurnAndReturnChampionshipUseCase(championshipDAO);


        AdminDAO adminDAO = new InMemoryAdminDAO();
        createAdminUseCase = new CreateAdminUseCase(adminDAO);
        findAdminUseCase = new FindAdminUseCase(adminDAO);
        removeAdminUseCase = new RemoveAdminUseCase(adminDAO);
        updateAdminUseCase = new UpdateAdminUseCase(adminDAO);

    }

}