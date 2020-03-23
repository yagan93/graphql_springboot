package ch.yagan.core;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.NoSuchElementException;
import java.util.Optional;

public abstract class CoreMutationsImpl<T extends CoreEntity> implements CoreMutations<T>, GraphQLQueryResolver {

    protected CoreJpaRepository<T> repository;

    public CoreMutationsImpl(CoreJpaRepository<T> repository) {
        this.repository = repository;
    }

    @Override
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    public void deleteById(String id) throws NoSuchElementException {
        if(repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new NoSuchElementException(String.format("Entity with ID '%s' could not be found", id));
        }
    }

    @Override
    public T updateById(String id, T entity) throws NoSuchElementException {
        if(repository.existsById(id)) {
            entity.setId(id);
            return repository.save(entity);
        } else {
            throw new NoSuchElementException(String.format("Entity with ID '%s' could not be found", id));
        }
    }

    @Override
    public boolean existsById(String id) {
        return repository.existsById(id);
    }

    protected T findOrThrow(Optional<T> optional) throws NoSuchElementException {
        if(optional.isPresent()) {
            return optional.get();
        } else {
            throw new NoSuchElementException("No value present");
        }
    }


}

