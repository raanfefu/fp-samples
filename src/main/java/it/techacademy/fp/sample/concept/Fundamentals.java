package it.techacademy.fp.sample.concept;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Fundamentals {

    public static void main(String[] args) {



        Function<Long, Long> cuadros = (a) -> a * a;
        Function<String,String> concat = (s) -> s+"";

        Function<Long,Long> cuadrados = new Function<Long, Long>() {
            @Override
            public Long apply(Long aLong) {
                return aLong * aLong;
            }
        };



    }

    public Long cuadros(long a){
        return a * a;
    }

}




