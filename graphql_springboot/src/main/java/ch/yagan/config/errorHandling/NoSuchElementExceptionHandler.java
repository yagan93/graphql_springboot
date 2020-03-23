package ch.yagan.config.errorHandling;

import ch.yagan.config.CustomGraphQLError;
import graphql.execution.ExecutionPath;
import graphql.language.SourceLocation;
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
    public CustomGraphQLError handle(Throwable e, SourceLocation sourceLocation, ExecutionPath executionPath) {
        return new CustomGraphQLError(e, sourceLocation, executionPath, HttpStatus.NOT_FOUND);
    }
}
