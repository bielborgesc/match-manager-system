package domain.usecases.round;

import domain.entities.match.Match;
import domain.entities.player.Player;
import domain.entities.player.StatusEnum;
import domain.entities.round.Round;
import domain.usecases.match.MatchDAO;
import domain.usecases.player.PlayerDAO;
import domain.usecases.utils.exceptions.EntityNotFoundException;
import domain.usecases.utils.exceptions.UnavailablePlayerException;

import java.util.Optional;

public class AddMatchInRoundUseCase {
    private MatchDAO matchDAO;
    private RoundDAO roundDAO;

//    public AddMatchInRoundUseCase(MatchDAO matchDAO) {
//        this.matchDAO = matchDAO;
//    }

    public AddMatchInRoundUseCase(MatchDAO matchDAO, RoundDAO roundDAO) {
        this.matchDAO = matchDAO;
        this.roundDAO = roundDAO;
    }

    public boolean addMatchInRound(Integer idMatch, Integer idRound) {
        if (matchDAO.findOne(idMatch).isPresent()) {
            Round roundUp = roundDAO.findOne(idRound).get();
            return roundUp.addNewMatch(matchDAO.findOne(idMatch).get());
        }

        throw new EntityNotFoundException("Entity Not Found");
    }
}
