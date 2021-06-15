package it.techacademy.fp.sample.strategy;

import it.techacademy.fp.sample.fun.Contact;
import it.techacademy.fp.sample.utils.ConsoleColor;

import java.util.function.Consumer;

public class StrategyExample {

    public static void main(String[] args) {

        Contact contact = new Contact.Builder()
                                     .with( c -> {
                                         c.setEmail("rafael.fernandez@telefonica");
                                     }).build();

        ContextMessage<Contact> ctx = new ContextMessage();
        ctx.send(contact, (c) -> System.out.println("sendMessage " + c.getEmail().orElse("")) );
        ctx.send(contact, (c) -> System.out.println(("call to " + c.phone.orElse("N/A"))));

        ContextMessage<String> ctx2 = new ContextMessage();
        ctx2.send("Hola", (s) -> System.out.printf("%s%s", ConsoleColor.ANSI_PURPLE,s ));
    }

}

class ContextMessage<T>{

    void send(T contact, Consumer<T> con){
        con.accept(contact);
    }
}



