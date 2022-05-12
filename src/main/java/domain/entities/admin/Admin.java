package domain.entities.admin;

import domain.entities.championship.Championship;

public class Admin {
    private String name;
    private String login;
    private String password;

    public Admin(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

//    public Championship championshipSearch() {}
//    public void createChampionship() {}
//    public void changeChampionship() {}
//    public void excludesChampionship() {}
//    public void teamSearch() {}
//    public void createTeam() {}
//    public void modifyTeam() {}
//    public void excludeTeam() {}
}
