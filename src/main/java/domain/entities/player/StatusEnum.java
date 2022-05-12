package domain.entities.player;

public enum StatusEnum {
    AVAILABLE("Available"),
    UNAVAILABLE("Univailable");

    private String status;

    StatusEnum(String status){
        this.status = status;
    }

    public String getStatus(){return this.status;}

}
