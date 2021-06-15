package it.techacademy.fp.sample.utils;

import lombok.Data;

import java.util.Objects;
import java.util.function.Consumer;

@Data
public class ContextStrategy<T>{

    public Consumer<T> strategy;

    public ContextStrategy<T> strategy(Consumer<T> strategy){
        this.setStrategy(strategy);
        return this;
    }

    public ContextStrategy<T> execute(T message){
        Objects.requireNonNull(strategy);
        strategy.accept(message);
        return this;
    }
}
