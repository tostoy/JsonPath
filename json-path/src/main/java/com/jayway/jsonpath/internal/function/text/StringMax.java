package com.jayway.jsonpath.internal.function.text;

import com.jayway.jsonpath.internal.EvaluationContext;
import com.jayway.jsonpath.internal.PathRef;
import com.jayway.jsonpath.internal.function.Parameter;
import com.jayway.jsonpath.internal.function.PathFunction;
import com.jayway.jsonpath.internal.function.numeric.AbstractAggregation;

import java.util.List;

/**
 * Defines the summation of a series of JSONArray numerical values
 *
 * Created by mattg on 6/26/15.
 */
public class StringMax implements PathFunction {

    @Override
    public Object invoke(String currentPath, PathRef parent, Object model, EvaluationContext ctx, List<Parameter> parameters) {
        String result = null;
        if(ctx.configuration().jsonProvider().isArray(model)){
            Iterable<?> objects = ctx.configuration().jsonProvider().toIterable(model);
            for (Object obj : objects) {
                if (obj instanceof String) {
                    String str= (String)obj;
                    if(result==null){
                        result = str;
                    }else{

                        if(result.compareTo(str)<0){
                            result =str;
                        }
                    }
                }
            }
        }
        return result == null ? null:result.toString();
    }
}