package it.techacademy.fp.sample.optional;


import it.techacademy.fp.sample.builder.CustomerImperative;

public class TarifaServiceImperative {

    public static void main(String[] args) {
        TarifaServiceImperative tarifaService = new TarifaServiceImperative();
        System.out.println("tarifa(100) = " + tarifaService.getTarifa(new CustomerImperative(100L)));
        System.out.println("tarifa(50)  = " + tarifaService.getTarifa(new CustomerImperative(50L)));
        System.out.println("tarifa(10)  = " + tarifaService.getTarifa(new CustomerImperative()));
    }

    public Double getTarifa(CustomerImperative customer){
        if(customer.minute == null){
            return 0d;
        }else{
            Double porc = getPorcentaje(customer.minute);
            if(porc==null){
                return 0d;
            }else{
                return customer.minute * (porc);
            }

        }
    }

    private Double getPorcentaje(Long minute){
        if(minute >= 100){
            return 1.10;
        }
        if(minute >= 50){
            return 1.02;
        }
        return null;
    }

}
