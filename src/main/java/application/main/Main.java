package application.main;

import application.repository.*;
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
import domain.usecases.match.*;
import domain.usecases.round.*;
import domain.usecases.score.*;
import domain.usecases.team.*;
import domain.usecases.user.*;
import domain.usecases.utils.exceptions.EntityAlreadyExistsException;

import java.util.Date;

public class Main {
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

    private static FindUserUseCase findUserUseCase;
    private static RemoveUserUseCase removeUserUseCase;
    private static UpdateUserUseCase updateUserUseCase;
    private static CreateUserUseCase createUserUseCase;

    private static FindAdminUseCase findAdminUseCase;
    private static RemoveAdminUseCase removeAdminUseCase;
    private static UpdateAdminUseCase updateAdminUseCase;
    private static CreateAdminUseCase createAdminUseCase;

    public static void main(String[] args) throws EntityAlreadyExistsException{
        configureInjection();


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

        UserDAO userDAO = new InMemoryUserDAO();
        createUserUseCase = new CreateUserUseCase(userDAO);
        findUserUseCase = new FindUserUseCase(userDAO);
        removeUserUseCase = new RemoveUserUseCase(userDAO);
        updateUserUseCase = new UpdateUserUseCase(userDAO);

        AdminDAO adminDAO = new InMemoryAdminDAO();
        createAdminUseCase = new CreateAdminUseCase(adminDAO);
        findAdminUseCase = new FindAdminUseCase(adminDAO);
        removeAdminUseCase = new RemoveAdminUseCase(adminDAO);
        updateAdminUseCase = new UpdateAdminUseCase(adminDAO);

    }

}