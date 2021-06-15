package it.techacademy.fp.sample.rule;

import java.util.function.Function;
import java.util.function.Predicate;

@FunctionalInterface
public interface  Rule<T,R> {

    R accept(T t);

    default Rule<T,R> addRule(Predicate<T> predicate, Function<R,R> function){
        return (entity) -> predicate.test(entity) ? function.apply(accept(entity)) : accept(entity);
    }

    default Rule<T,R> and(Predicate<T> predicate, Function<R,Rule<T,R>> func){
        return (entity) -> predicate.test(entity) ? func.apply(accept(entity)).accept(entity) : accept(entity);
    }

    static <T,R> Rule<T,R> get(R val){
        return (entity) -> true ? val : val;
    }

    default  R apply(T entity){
        return accept(entity);
    }
}