package domain.usecases.round;

import domain.entities.match.Match;
import domain.entities.player.Player;
import domain.entities.player.StatusEnum;
import domain.usecases.match.MatchDAO;
import domain.usecases.player.PlayerDAO;
import domain.usecases.utils.exceptions.UnavailablePlayerException;

import java.util.Optional;

public class AddMatchInRoundUseCase {
    private MatchDAO matchDAO;

    public AddMatchInRoundUseCase(MatchDAO matchDAO) {
        this.matchDAO = matchDAO;
    }

//    public boolean addMatchInRound(Optional<Match> match, Integer idRound) {
//        if (matchDAO.findOne(player.get().getCpf()).isPresent()) {
//            Player playerTeam = new Player(player.get().getName(), player.get().getCpf(), player.get().getGender(), idTeam);
//            return playerDAO.update(playerTeam);
//        }
//        throw new UnavailablePlayerException("This player is already on a team");
//    }
}
