package domain.usecases.admin;

import domain.entities.admin.Admin;
import domain.usecases.utils.exceptions.EntityAlreadyExistsException;

public class CreateAdminUseCase {
    private AdminDAO adminDAO;

    public CreateAdminUseCase(AdminDAO adminDAO) {
        this.adminDAO = adminDAO;
    }

    public String insert(Admin admin) throws EntityAlreadyExistsException {
        if(adminDAO.findOne(admin.getLogin()).isPresent()){
            throw new EntityAlreadyExistsException("Entity already exists");
        }
        return adminDAO.create(admin);
    }
}
