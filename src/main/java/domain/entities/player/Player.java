package domain.entities.player;

public class Player {
    private String name;
    private String cpf;
    private Gender gender;

    public Player(String name, String cpf, Gender gender) {
        this.name = name;
        this.cpf = cpf;
        this.gender = gender;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Player: ");
        sb.append("name='").append(name).append('\'');
        sb.append(", cpf='").append(cpf).append('\'');
        sb.append(", gender=").append(gender);
        return sb.toString();
    }
}
