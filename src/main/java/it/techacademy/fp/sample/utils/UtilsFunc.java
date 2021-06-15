package it.techacademy.fp.sample.utils;


import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.function.Function;
import java.util.function.Predicate;

public abstract class UtilsFunc {

    public static LocalDate age(int years){
        return LocalDate.now().minusYears(years);
    }

    public static <T> Predicate<T> sameDay(final LocalDate hoy, Function<T,LocalDate> extracted){
        return c -> (extracted.apply(c).getDayOfMonth() == hoy.getDayOfMonth()) &&
                (extracted.apply(c).getDayOfMonth() == hoy.getDayOfMonth());
    }

    public static boolean sameDay(LocalDate date){
        LocalDate today = LocalDate.now();
        if (date.getDayOfMonth() == today.getDayOfMonth() &&
                date.getMonth() == today.getMonth()){
            return true;
        }else{
            return false;
        }
    }



}
