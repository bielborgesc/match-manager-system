package domain.entities.championship;

import java.util.Arrays;

public enum TypeEnum {
    FUTEBOL("Futebol"),
    VOLEI("Volei");

    private String typeEnum;

    TypeEnum(String typeEnum){
        this.typeEnum = typeEnum;
    }

    public static TypeEnum toEnum(String typeEnum) {
        return Arrays.stream(TypeEnum.values())
                .filter(c -> typeEnum.equals(c.toString()))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public String getTypeEnum(){return this.typeEnum;}
}
