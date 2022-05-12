package domain.entities.player;

public enum GenderEnum {
    M("Male"),
    F("Famale");

    private String gender;

    GenderEnum(String sexo){
        this.gender = sexo;
    }

    public String getGender(){return this.gender;}

}
