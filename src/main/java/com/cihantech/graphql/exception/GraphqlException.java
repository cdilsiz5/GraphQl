package com.cihantech.graphql.exception;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.stereotype.Component;

@Component
public class GraphqlException extends DataFetcherExceptionResolverAdapter {
    @Override
    protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
        if(ex instanceof UserNotFoundException){
            return toGraphQlError(ex);
        } else if (ex instanceof Exception) {
            return toGraphQlError(ex);
        }
        return super.resolveToSingleError(ex, env);
    }

    private GraphQLError toGraphQlError(Throwable throwable){
        return GraphQLError.newError().message(throwable.getMessage()).errorType(ErrorType.DataFetchingException).build();
    }
}
