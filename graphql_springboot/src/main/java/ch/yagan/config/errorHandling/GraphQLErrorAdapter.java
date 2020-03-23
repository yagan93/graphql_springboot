package ch.yagan.config;

import graphql.ErrorType;
import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.language.SourceLocation;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Map;

public class GraphQLErrorAdapter implements GraphQLError {

    private static final long serialVersionUID = 1308954323465652533L;

    private GraphQLError error;
    private HttpStatus status;

    public GraphQLErrorAdapter(GraphQLError error, HttpStatus status) {
        this.error = error;
        this.status = status;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return error.getExtensions();
    }

    @Override
    public List<SourceLocation> getLocations() {
        return error.getLocations();
    }

    @Override
    public ErrorType getErrorType() {
        return error.getErrorType();
    }

    @Override
    public List<Object> getPath() {
        return error.getPath();
    }

    @Override
    public Map<String, Object> toSpecification() {
        return error.toSpecification();
    }

    @Override
    public String getMessage() {
        if (error instanceof ExceptionWhileDataFetching) {
            return ((ExceptionWhileDataFetching) error).getException().getMessage();
        }
        return error.getMessage();
    }

    public Status getStatus() {
        return new Status(status);
    }
}
