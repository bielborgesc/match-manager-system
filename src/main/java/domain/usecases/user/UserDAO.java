package domain.usecases.user;

import domain.entities.user.User;
import domain.usecases.utils.dao.DAO;

public interface UserDAO extends DAO<String, User> {

}
