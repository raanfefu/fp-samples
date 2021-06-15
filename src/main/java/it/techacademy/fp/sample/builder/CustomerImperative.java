package it.techacademy.fp.sample.builder;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;


// Construir un builder para esta clase
@Data
public class CustomerImperative {

    public LocalDate dateOfBirth;
    public LocalDate dateOfFirstPurchase;
    public boolean isVeteran;

    public Long minute;

    public CustomerImperative(){
    }

    public CustomerImperative(LocalDate dateOfBirth){
        this.dateOfBirth = dateOfBirth;
    }

    public CustomerImperative(Long minute){
        this.minute = minute;
    }

    // Gettter & Setters
}
