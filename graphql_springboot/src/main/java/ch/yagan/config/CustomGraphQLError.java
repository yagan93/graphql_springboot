package ch.yagan.config;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.execution.ExecutionPath;
import graphql.language.SourceLocation;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Map;

public class CustomGraphQLError implements GraphQLError {

    private Throwable throwable;
    private SourceLocation sourceLocation;
    private ExecutionPath executionPath;
    private Status status;

    public CustomGraphQLError(Throwable throwable, SourceLocation sourceLocation, ExecutionPath executionPath, HttpStatus status) {
        this.throwable = throwable;
        this.sourceLocation = sourceLocation;
        this.executionPath = executionPath;
        this.status = new Status(status);
    }

    @Override
    public String getMessage() {
        return throwable.getMessage();
    }

    @Override
    public List<SourceLocation> getLocations() {
        return List.of(sourceLocation);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DataFetchingException;
    }

    @Override
    public List<Object> getPath() {
        return executionPath.toList();
    }

    @Override
    public Map<String, Object> getExtensions() {
        return null;
    }

    public Status getStatus() {
        return status;
    }
}
