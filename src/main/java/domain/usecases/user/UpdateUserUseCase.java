package domain.usecases.user;

import domain.entities.user.User;
import domain.usecases.utils.exceptions.EntityNotFoundException;

public class UpdateUserUseCase {
    private UserDAO userDAO;

    public UpdateUserUseCase(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public boolean update(User user) {
        String username= user.getUsername();
        if(userDAO.findOne(username).isEmpty())
            throw new EntityNotFoundException("User not found.");

        return userDAO.update(user);
    }

}
