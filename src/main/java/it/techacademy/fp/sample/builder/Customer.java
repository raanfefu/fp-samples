package it.techacademy.fp.sample.builder;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Optional;
import java.util.function.Consumer;

@Data
@NoArgsConstructor
public class Customer {


    public LocalDate dateOfBirth;
    public LocalDate dateOfFirstPurchase;
    public boolean isVeteran;

    public Optional<Long> minute;

    public static Builder builder(){
        return new Builder();
    }

    @Data
    public static class Builder {

        public LocalDate dateOfBirth;
        public LocalDate dateOfFirstPurchase;
        public boolean isVeteran;
        public long minute;

        public Builder with(Consumer<Builder> consumer ){
            consumer.accept(this);
            return this;
        }

        public Customer build() {
            Customer c = new Customer();
            c.dateOfBirth = dateOfBirth;
            c.dateOfFirstPurchase = dateOfFirstPurchase;
            c.isVeteran = isVeteran;
            c.minute = Optional.ofNullable(minute);
            return c;
        }
    }

}
