package domain.entities.modality;

import domain.entities.championship.CategoryEnum;
import domain.entities.championship.Championship;
import domain.entities.player.Player;

import java.util.HashMap;



public class Modality {

    private TypeEnum typeEnum;
    private CategoryEnum categoryEnum;
    private HashMap<String, Championship> championship;

    private HashMap<String, Player> players;

    public TypeEnum getTypeEnum() {
        return typeEnum;
    }

    public void setTypeEnum(TypeEnum typeEnum) {
        this.typeEnum = typeEnum;
    }

    public CategoryEnum getCategoryEnum() {
        return categoryEnum;
    }

    public void setCategoryEnum(CategoryEnum categoryEnum) {
        this.categoryEnum = categoryEnum;
    }

    public Championship getChampionship(String key) {
        return championship.get(key) ;
    }

    public void setChampionship(Championship championship) {
        this.championship.put(championship.getName(), championship);
    }

    public Player getPlayers(Player player) {
        return this.players.get(player.getCpf());
    }

    public void setPlayers(Player player) {
        this.players.put(player.getCpf(), player);
    }
    //TODO: Implementar remover campeonato e players com confirmação
}
