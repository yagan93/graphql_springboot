package ch.yagan.config;

import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.servlet.GraphQLErrorHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomGraphQLErrorHandler implements GraphQLErrorHandler {

    private ExceptionHandler[] exceptionHandlers;

    @Autowired
    public CustomGraphQLErrorHandler(ExceptionHandler[] exceptionHandlers) {
        this.exceptionHandlers = exceptionHandlers;
    }

    @Override
    public List<GraphQLError> processErrors(List<GraphQLError> errors) {

        List<GraphQLError> thrownErrors = errors.stream()
                .filter(error -> error instanceof ExceptionWhileDataFetching)
                .map(error -> {
                    for(ExceptionHandler handler : exceptionHandlers) {
                        Throwable throwable = ((ExceptionWhileDataFetching) error).getException();

                        if(handler.canHandle(throwable)) {
                            return handler.handle(throwable, error);
                        }
                    }

                    return error;
                })
                .collect(Collectors.toList());

        List<GraphQLError> otherErrors = errors.stream().filter(error -> !(error instanceof ExceptionWhileDataFetching)).collect(Collectors.toList());

        List<GraphQLError> graphQLErrors = new ArrayList<>(errors.size());
        graphQLErrors.addAll(thrownErrors);
        graphQLErrors.addAll(otherErrors);

        return graphQLErrors;
    }
}
