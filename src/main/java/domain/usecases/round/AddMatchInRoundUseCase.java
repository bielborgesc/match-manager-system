package domain.usecases.round;
import domain.entities.round.Round;
import domain.usecases.match.MatchDAO;
import domain.utils.exceptions.EntityNotFoundException;

public class AddMatchInRoundUseCase {
    private MatchDAO matchDAO;
    private RoundDAO roundDAO;


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
