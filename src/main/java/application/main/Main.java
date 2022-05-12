package application.main;

import domain.entities.championship.CategoryEnum;
import domain.entities.championship.Championship;
import domain.entities.championship.TypeEnum;
import domain.entities.match.Match;
import domain.entities.player.GenderEnum;
import domain.entities.player.Player;
import domain.entities.round.Round;
import domain.entities.team.Team;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        //Criando o campeonato
        Championship championship1 = new Championship(1, "Interpool", new Date(), TypeEnum.FUTEBOL, CategoryEnum.ADULT);

        //Criando time
        Team t1 = new Team(1, "TimeA");
        Team t2 = new Team(1, "TimeB");

        //Criando jogadores
        Player player1 = new Player("Gabriel", "123456", GenderEnum.M);
        Player player2 = new Player("Amadeu", "7854924", GenderEnum.M);
        Player player3 = new Player("Jackson", "2345897", GenderEnum.M);
        Player player4 = new Player("Fagner", "7821456", GenderEnum.M);

        //Add jogadores em times
        t1.setPlayers(player1);
        t1.setPlayers(player2);
        t2.setPlayers(player3);
        t2.setPlayers(player4);

        championship1.setTeam(t1);
        championship1.setTeam(t2);

        //Criando rodada
        Round round1 = new Round(1);

        //Criando partidas
        Match match1 = new Match(t1, t2);
        Match match2 = new Match(t1, t2);

        //Adicionando partidas na rodada
        round1.setMatch(match1);
        round1.setMatch(match2);



    }
}