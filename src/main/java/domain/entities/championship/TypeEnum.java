package domain.entities.championship;

public enum TypeEnum {
    FUTEBOL("Futebol"),
    VOLEI("Volei");

    private String typeEnum;

    TypeEnum(String typeEnum){
        this.typeEnum = typeEnum;
    }

    public String getTypeEnum(){return this.typeEnum;}
}
