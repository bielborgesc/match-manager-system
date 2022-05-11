package domain.entities.player;

public enum Gender {
    M("Male"),
    F("Famale");

    private String gender;

    Gender(String sexo){
        this.gender = sexo;
    }

    public String getGender(){return this.gender;}

}
