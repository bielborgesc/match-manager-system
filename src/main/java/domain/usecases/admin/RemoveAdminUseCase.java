package domain.usecases.admin;

import domain.entities.admin.Admin;
import domain.usecases.utils.exceptions.EntityNotFoundException;

public class RemoveAdminUseCase {
    private AdminDAO adminDAO;

    public RemoveAdminUseCase(AdminDAO adminDAO) {
        this.adminDAO = adminDAO;
    }

    public boolean remove(Admin admin) {
        if (admin == null || adminDAO.findOne(admin.getLogin()).isEmpty()) {
            throw  new EntityNotFoundException("Admin is not exists");
        }
        return adminDAO.delete(admin);
    }

    public boolean remove(String login) {
        if (login == null || adminDAO.findOne(login).isEmpty()) {
            throw new EntityNotFoundException("Admin is not exists");
        }
        return adminDAO.deleteByKey(login);
    }
}
