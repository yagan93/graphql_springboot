package ch.yagan.core;

public interface CoreMutations<T extends CoreEntity> {

    T save(T entity);

    T updateById(String id, T entity);

    void deleteById(String id);

    boolean existsById(String id);

}
