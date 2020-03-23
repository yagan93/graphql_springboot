package ch.yagan.config;

import graphql.execution.DataFetcherExceptionHandler;
import graphql.execution.DataFetcherExceptionHandlerParameters;
import graphql.execution.ExecutionPath;
import graphql.language.SourceLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CustomDataFetcherExceptionHandler implements DataFetcherExceptionHandler {

    private ExceptionHandler[] exceptionHandlers;

    @Autowired
    public CustomDataFetcherExceptionHandler(ExceptionHandler[] exceptionHandlers) {
        this.exceptionHandlers = exceptionHandlers;
    }

    @Override
    public void accept(DataFetcherExceptionHandlerParameters handlerParameters) {
        Throwable exception = handlerParameters.getException();
        SourceLocation sourceLocation = handlerParameters.getField().getSourceLocation();
        ExecutionPath path = handlerParameters.getPath();

        for(ExceptionHandler exceptionHandler : exceptionHandlers) {
            if(exceptionHandler.canHandle(exception)) {
                handlerParameters.getExecutionContext().addError(exceptionHandler.handle(exception, sourceLocation, path));
            }
        }

        handlerParameters.getExecutionContext().addError(new CustomGraphQLError(exception, sourceLocation, path, HttpStatus.INTERNAL_SERVER_ERROR));
    }
}
