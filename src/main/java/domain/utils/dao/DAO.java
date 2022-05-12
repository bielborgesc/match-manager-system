package domain.utils.dao;

import java.util.List;
import java.util.Optional;

public interface DAO<T, K> {
    K crete(T type);
    Optional<T> findOne(K type);
    List<T> findAll();
    boolean update(T type);
    boolean deleteByKey(K key);
    boolean delete(T type);
}
