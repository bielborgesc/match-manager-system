package domain.usecases.admin;

import domain.entities.admin.Admin;

import java.util.List;
import java.util.Optional;

public class FindAdminUseCase {
    private AdminDAO adminDAO;

    public FindAdminUseCase(AdminDAO adminDAO) {
        this.adminDAO = adminDAO;
    }

    public Optional<Admin> findOne(String login){
        if(login == null) {
            throw new IllegalArgumentException("Argument provided is not valid");
        }
        return adminDAO.findOne(login);
    }

    public List<Admin> findAll(){
        return adminDAO.findAll();
    }
}
