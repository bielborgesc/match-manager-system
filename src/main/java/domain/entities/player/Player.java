package domain.entities.player;

public class Player {
    private String name;
    private String cpf;
    private GenderEnum gender;
    private StatusEnum status = StatusEnum.AVAILABLE;
    private Integer idTeam = null;

    public Player(String name, String cpf, GenderEnum gender) {
        this.name = name;
        this.cpf = cpf;
        this.gender = gender;
    }

    public Player(String name, String cpf, GenderEnum gender, Integer idTeam) {
        this.name = name;
        this.cpf = cpf;
        this.gender = gender;
        this.idTeam = idTeam;
        status =  idTeam != null ? StatusEnum.UNAVAILABLE : StatusEnum.AVAILABLE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public StatusEnum getStatus() {
        return status;
    }
    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public Integer getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(Integer idTeam) {
        this.idTeam = idTeam;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Player{");
        sb.append("name='").append(name).append('\'');
        sb.append(", cpf='").append(cpf).append('\'');
        sb.append(", gender=").append(gender);
        sb.append(", status=").append(status);
        sb.append(", idTeam=").append(idTeam);
        sb.append('}');
        return sb.toString();
    }
}
