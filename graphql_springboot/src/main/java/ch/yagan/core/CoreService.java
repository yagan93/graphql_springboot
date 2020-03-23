package ch.yagan.core;

import java.util.List;
import java.util.NoSuchElementException;

public interface CoreService<E extends CoreEntity> {

    List<E> findAll();

    E findById(String id) throws NoSuchElementException;

    boolean existsById(String id);

    E create(E entity);

    E updateById(String id, E entity) throws NoSuchElementException;

    void deleteById(String id) throws NoSuchElementException;

}
