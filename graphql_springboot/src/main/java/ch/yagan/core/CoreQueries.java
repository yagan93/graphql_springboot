package ch.yagan.core;

import java.util.List;

public interface CoreQueries<T extends CoreEntity> {

    List<T> findAll();

    T findById(String id);

}