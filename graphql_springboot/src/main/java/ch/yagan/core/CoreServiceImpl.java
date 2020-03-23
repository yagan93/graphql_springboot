package ch.yagan.core;

import org.slf4j.Logger;

import java.util.List;
import java.util.NoSuchElementException;

public abstract class CoreServiceImpl<E extends CoreEntity> implements CoreService<E> {

    protected CoreJpaRepository<E> repository;
    protected Logger logger;

    public CoreServiceImpl(CoreJpaRepository<E> repository, Logger logger) {
        this.repository = repository;
        this.logger = logger;
    }

    @Override
    public List<E> findAll() {
        return repository.findAll();
    }

    @Override
    public E findById(String id) throws NoSuchElementException {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public boolean existsById(String id) {
        return repository.existsById(id);
    }

    @Override
    public E create(E entity) {
        entity.setId(null);
        return repository.save(entity);
    }

    @Override
    public E updateById(String id, E entity) throws NoSuchElementException {
        if(existsById(id)) {
            entity.setId(id);
            return repository.save(entity);
        } else {
            throw new NoSuchElementException(String.format("Entity with ID '%s' not found", id));
        }
    }

    @Override
    public void deleteById(String id) throws NoSuchElementException {
        if(existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new NoSuchElementException(String.format("Entity with ID '%s' not found", id));
        }
    }
}
