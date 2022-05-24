package domain.usecases.admin;

import domain.entities.admin.Admin;
import domain.usecases.utils.exceptions.EntityNotFoundException;

public class UpdateAdminUseCase {
    private AdminDAO adminDAO;

    public UpdateAdminUseCase(AdminDAO adminDAO) {
        this.adminDAO = adminDAO;
    }

    public boolean update(Admin admin) {
        String login = admin.getLogin();
        if(adminDAO.findOne(login).isEmpty())
            throw new EntityNotFoundException("Admin not found.");

        return adminDAO.update(admin);
    }
}
