package domain.usecases.user;

import domain.entities.user.User;

import java.util.List;
import java.util.Optional;

public class FindUserUseCase {
    private UserDAO userDAO;

    public FindUserUseCase(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public Optional<User> findOne(String username){
        if(username == null) {
            throw new IllegalArgumentException("Argument provided is not valid");
        }
        return userDAO.findOne(username);
    }

    public List<User> findAll(){
        return userDAO.findAll();
    }

}
