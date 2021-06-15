package it.techacademy.fp.sample.utils;

import java.util.function.Function;

public interface UncheckedFunction<T, R, E extends Throwable> {

    R apply(T t);

    static <T, R, E extends Throwable> Function<T,R> of(UncheckedFunction<T, R, E> fe) {
        return (arg) -> {
            try {
                return fe.apply(arg);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        };
    }
}
