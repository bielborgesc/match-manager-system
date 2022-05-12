package domain.entities.championship;

public enum CategoryEnum {
    CHILDISH("childish"),
    JUVENILE("Juvenile"),
    ADULT("Adult");

    private String categoryEnum ;

    CategoryEnum(String categoryEnum){
        this.categoryEnum = categoryEnum;
    }

    public String getCategoryEnum(){return this.categoryEnum;}
}
