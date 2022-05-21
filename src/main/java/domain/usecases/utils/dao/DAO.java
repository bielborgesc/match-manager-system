package domain.usecases.utils.dao;

import java.util.List;
import java.util.Optional;

public interface DAO<K, T> {
    K create(T type);
    Optional<T> findOne(K type);
    List<T> findAll();
    boolean update(T type);
    boolean deleteByKey(K key);
    boolean delete(T type);
}
