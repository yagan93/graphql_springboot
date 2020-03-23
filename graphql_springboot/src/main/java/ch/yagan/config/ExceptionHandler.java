package ch.yagan.config;

import graphql.GraphQLError;

public interface ExceptionHandler {

    boolean canHandle(Throwable e);

    GraphQLError handle(Throwable e, GraphQLError originalError);

}
