package ch.yagan.config;

import graphql.ErrorType;
import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.language.SourceLocation;
import graphql.servlet.GraphQLErrorHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Configuration
public class GraphQLConfig {

    @Bean
    public GraphQLErrorHandler errorHandler() {
        return new GraphQLErrorHandler() {

            @Override
            public List<GraphQLError> processErrors(List<GraphQLError> errors) {
                List<GraphQLError> clientErrors = errors.stream()
                        .filter(this::isClientError)
                        .collect(Collectors.toList());

                List<GraphQLError> serverErrors = errors.stream()
                        .filter(e -> !isClientError(e))
                        .collect(Collectors.toList());

                List<GraphQLError> e = new ArrayList<>();
                e.addAll(clientErrors);
                e.addAll(serverErrors);
                return e;
            }

            protected boolean isClientError(GraphQLError error) {
                if (error instanceof ExceptionWhileDataFetching) {
                    return ((ExceptionWhileDataFetching) error).getException() instanceof GraphQLError;
                }
                return !(error instanceof Throwable);
            }
        };
    }

    private class GraphQLErrorAdapter implements GraphQLError {

        private static final long serialVersionUID = 1308954323465652533L;

        private GraphQLError error;

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
    }
}