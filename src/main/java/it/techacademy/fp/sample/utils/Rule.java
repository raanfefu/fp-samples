package it.techacademy.fp.sample.utils;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

@FunctionalInterface
public interface  Rule<T,R> {

    R accept(T entity);

    default Rule<T,R> addRule(Predicate<T> predicate, BiFunction<R,T,R> function){
        return  (entity) ->  predicate.test(entity) ? function.apply(accept(entity),entity) : accept(entity);
    }

    default Rule<T,R> and(Predicate<T> predicate, Function<R, Rule<T,R>> function){
        return  (entity) -> predicate.test(entity) ? function.apply(accept(entity)).accept(entity) : accept(entity);
    }

    static <T,R> Rule<T,R> get(R value){
        return (entity) -> false ? value : value;
    }

    default R apply(T entity){
        return accept(entity);
    }

}