package application.repository.inmemory;

import domain.entities.admin.Admin;
import domain.usecases.admin.AdminDAO;

import java.util.*;

public class InMemoryAdminDAO implements AdminDAO {

    private static final Map<String, Admin> db = new LinkedHashMap<>();

    @Override
    public String create(Admin admin) {
        db.put(admin.getLogin(), admin);
        return admin.getLogin();
    }

    @Override
    public Optional<Admin> findOne(String login) {
        if(db.containsKey(login))
            return Optional.of(db.get(login));
        return Optional.empty();
    }

    @Override
    public List<Admin> findAll() {
        return new ArrayList<>(db.values());
    }

    @Override
    public boolean update(Admin admin) {
        String login = admin.getLogin();
        if(db.containsKey(login)) {
            db.replace(login, admin);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteByKey(String key) {
        if(db.containsKey(key)){
            db.remove(key);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Admin admin) {
        return deleteByKey( admin.getLogin());
    }
}
