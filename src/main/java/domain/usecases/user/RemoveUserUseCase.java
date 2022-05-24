package domain.usecases.user;

import domain.entities.user.User;
import domain.usecases.utils.exceptions.EntityNotFoundException;

public class RemoveUserUseCase {
    private UserDAO userDAO;

    public RemoveUserUseCase(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public boolean remove(User user) {
        if (user == null || userDAO.findOne(user.getUsername()).isEmpty()) {
            throw  new EntityNotFoundException("User is not exists");
        }
        return userDAO.delete(user);
    }

    public boolean remove(String username) {
        if (username == null || userDAO.findOne(username).isEmpty()) {
            throw new EntityNotFoundException("User is not exists");
        }
        return userDAO.deleteByKey(username);
    }

}
