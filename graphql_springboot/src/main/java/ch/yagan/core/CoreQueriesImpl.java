package ch.yagan.core;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public abstract class CoreQueriesImpl<T extends CoreEntity> implements CoreQueries<T> {

    protected CoreJpaRepository<T> repository;

    public CoreQueriesImpl(CoreJpaRepository<T> repository) {
        this.repository = repository;
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public T findById(String id) {
        return findOrThrow(repository.findById(id));
    }

    protected T findOrThrow(Optional<T> optional) throws NoSuchElementException {
        if(optional.isPresent()) {
            return optional.get();
        } else {
            throw new NoSuchElementException("No value present");
        }
    }

}

