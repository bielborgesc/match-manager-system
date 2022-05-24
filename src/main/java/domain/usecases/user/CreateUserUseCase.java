package domain.usecases.user;

import domain.entities.player.Player;
import domain.entities.user.User;
import domain.usecases.player.PlayerDAO;
import domain.usecases.utils.exceptions.EntityAlreadyExistsException;

public class CreateUserUseCase {
    private UserDAO userDAO;

    public CreateUserUseCase(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public String insert(User user) throws EntityAlreadyExistsException {
        if (userDAO.findOne(user.getUser()).isPresent()) {
            throw new EntityAlreadyExistsException("Entity already exists");
        }
        return userDAO.create(user);
    }
}
