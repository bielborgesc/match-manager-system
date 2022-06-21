package domain.entities.championship;

import java.util.Arrays;

public enum CategoryEnum {
    CHILDISH("Childish"),
    JUVENILE("Juvenile"),
    ADULT("Adult");

    private String categoryEnum ;

    CategoryEnum(String categoryEnum){
        this.categoryEnum = categoryEnum;
    }

    public static CategoryEnum toEnum(String categoryEnum) {
        return Arrays.stream(CategoryEnum.values())
                .filter(c -> categoryEnum.equals(c.toString()))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public String getCategoryEnum(){return this.categoryEnum;}
}
