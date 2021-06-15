package it.techacademy.fp.sample.utils;

import java.util.function.BiConsumer;

public interface UncheckedBiConsumer<T, R, E extends Throwable>  {

    void accept(T t, R r) throws E;

    static <T, R, E extends Throwable> BiConsumer<T,R> of(UncheckedBiConsumer<T, R, E> fe) {
        return (arg, arg2) -> {
            try {
                fe.accept(arg, arg2);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        };
    }
}
