package it.techacademy.fp.sample.utils;

import java.util.function.Consumer;

public interface UncheckedConsumer<T, E extends Throwable>  {

    void accept(T t) throws E;

    static < T, E extends Throwable> Consumer< T> of(UncheckedConsumer< T, E> fe) {
        return arg -> {
            try {
                fe.accept(arg);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        };
    }
}
