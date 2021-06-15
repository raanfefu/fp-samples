package it.techacademy.fp.sample.rule;


import it.techacademy.fp.sample.builder.CustomerImperative;
import it.techacademy.fp.sample.utils.UtilsFunc;

import java.time.LocalDate;

public class ImperativeExample {

    public static void main(String[] args) {
        CustomerImperative c = new CustomerImperative(LocalDate.now());
        c.setDateOfFirstPurchase(LocalDate.now().minusYears(1));
        c.setVeteran(true);
        System.out.println( "Discount" +  calculateDiscountPercentage(c));
    }

    public static double calculateDiscountPercentage(CustomerImperative customer)
    {
        double discount = 0;
        LocalDate age65 = LocalDate.now().minusYears(65);
        if ( customer.dateOfBirth.isBefore(age65)  )
        {
            // senior discount 5%
            discount = 0.05d; //System.out.println("linea 24");
        }

        if (UtilsFunc.sameDay(customer.getDateOfBirth()))
        {
            // birthday 10%
            discount = Math.max(discount, 0.10d); //System.out.println("linea 31");
        }

        if (customer.dateOfFirstPurchase != null)
        {
            LocalDate age1= LocalDate.now().minusYears(1);
            if (customer.getDateOfFirstPurchase().isBefore(age1))
            {
                // after 1 year, loyal customers get 10%
                discount = Math.max(discount, 0.10d); //System.out.println("linea 40");
                LocalDate age5= LocalDate.now().minusYears(5);
                if (customer.getDateOfFirstPurchase().isBefore(age5))
                {
                    // after 5 years, 12%
                    discount = Math.max(discount, 0.12d); //System.out.println("linea 45");
                    LocalDate age10= LocalDate.now().minusYears(10);
                    if (customer.getDateOfFirstPurchase().isBefore(age10))
                    {
                        // after 10 years, 20%
                        discount = Math.max(discount, 0.2d); //System.out.println("linea 50");
                    }
                }

                if (UtilsFunc.sameDay(customer.getDateOfBirth()))
                {
                    // birthday additional 10%
                        discount += 0.10d; // System.out.println("linea 58");
                }
            }
        }
        else
        {
            // first time purchase discount of 15%
            discount = Math.max(discount, 0.15d); //System.out.println("linea 65");
        }
        if (customer.isVeteran())
        {
            // veterans get 10%
            discount = Math.max(discount, 0.10d); //System.out.println("linea 70");
        }

        return discount;
    }

}
