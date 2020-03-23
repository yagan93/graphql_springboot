package ch.yagan.config.errorHandling;

import ch.yagan.config.CustomGraphQLError;
import graphql.execution.ExecutionPath;
import graphql.language.SourceLocation;

public interface ExceptionHandler {

    boolean canHandle(Throwable e);

    CustomGraphQLError handle(Throwable e, SourceLocation sourceLocation, ExecutionPath executionPath);

}
