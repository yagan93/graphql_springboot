package ch.yagan.config;

import graphql.GraphQLError;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public class NoSuchElementExceptionHandler implements ExceptionHandler {

    @Override
    public boolean canHandle(Throwable e) {
        return e instanceof NoSuchElementException;
    }

    @Override
    public GraphQLError handle(Throwable e, GraphQLError originalError) {
        return new GraphQLErrorAdapter(originalError, HttpStatus.NOT_FOUND);
    }
}
