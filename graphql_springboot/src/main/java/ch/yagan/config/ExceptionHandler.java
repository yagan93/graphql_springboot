package ch.yagan.config;

import graphql.execution.ExecutionPath;
import graphql.language.SourceLocation;

public interface ExceptionHandler {

    boolean canHandle(Throwable e);

    CustomGraphQLError handle(Throwable e, SourceLocation sourceLocation, ExecutionPath executionPath);

}
