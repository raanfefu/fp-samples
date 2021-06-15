package it.techacademy.fp.sample.repository;

import it.techacademy.fp.sample.builder.Offer;

import java.util.Arrays;
import java.util.List;

public class OfferrRepository {

    public List<Offer> getAll(){
        return Arrays.asList(new Offer(1000,  "Oferta de bienvenida", "NEW", "ON-LINE"),
                             new Offer(2000, "Oferta de bienvenida", "new","CALL-CENTER"),
                             new Offer(3000, "Oferta de bienvenida", "NEW","EJECUTIVO"),

                             new Offer(1001, "Cliente Frecuente", "REGULAR","ON-LINE"),
                             new Offer(2001, "Cliente Frecuente", "regular","CALL-CENTER"),
                             new Offer(3001, "Cliente Frecuente", "REGULAR","EJECUTIVO"),

                             new Offer(1002, "Cliente Corporativo", "CORPORATE","ON-LINE"),
                             new Offer(2002, "Cliente Corporativo", "CORPORATE","CALL-CENTER"),
                             new Offer(3002, "Cliente Corporativo", "corporate", "EJECUTIVO"));
    }
}
