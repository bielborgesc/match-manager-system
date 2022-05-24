package domain.usecases.round;

import domain.entities.match.Match;
import domain.usecases.match.MatchDAO;
import domain.usecases.utils.exceptions.UnavailablePlayerException;

import java.util.Optional;

public class AddMatchInRoundUseCase {
    private MatchDAO matchDAO;

    public AddMatchInRoundUseCase(MatchDAO matchDAO) {
        this.matchDAO = matchDAO;
    }

    public boolean addMatchInRound(Optional<Match> match, Integer idRound) throws UnavailablePlayerException {
        if (matchDAO.findOne(match.get().getId()).isPresent()) {
            return matchDAO
        }
        throw new UnavailablePlayerException("This player is already on a team");
    }
}
