package it.techacademy.fp.sample.fun;

import it.techacademy.fp.sample.utils.ConsoleColor;
import it.techacademy.fp.sample.utils.ContextStrategy;
import it.techacademy.fp.sample.utils.Rule;
import it.techacademy.fp.sample.utils.UncheckedConsumer;

import java.nio.file.Files;
import java.util.function.*;

public class FunExample {

    public static void main(String[] args) {

        Contact contact = new Contact.Builder()
                                             .with( b -> {
                                                 b.message =  "Hola Functional Programming";
                                                 b.email =  "rafael.fernandez.ve@gmail.com";
                                                 b.phone =  "rafael";
                                                 b.url =  "/Users/rfernandezo/MY_File_Message.txt";
                                             })
                                             .build();
        new FunExample().sendMessageContactInfo()
                        .apply(contact);

    }

    public Rule<Contact, ContextStrategy<Contact>> sendMessageContactInfo(){
        return Rule.<Contact, ContextStrategy<Contact>>get( new ContextStrategy<Contact>() )
                .addRule( (c) -> c.getPhone().isPresent(), (ctx, dat) -> ctx.strategy(strategyWriteConsoleColor(ConsoleColor.ANSI_CYAN ))
                                                                            .execute(dat))

                .addRule( (c) -> c.getPhone().isPresent() , (ctx, dat) -> ctx.strategy(strategyWriteConsole())
                                                                            .execute(dat))

                .addRule( (c) -> !c.getUrl().isEmpty()  , (ctx, dat) -> ctx.strategy(strategyWriteFile())
                                                                           .execute(dat));
    }

    private  Consumer<Contact> strategyWriteConsole(){
        return (c) -> System.out.printf( "\n%s%s%s\n", ConsoleColor.ANSI_BLUE , c.message.orElse("N/A"), ConsoleColor.ANSI_RESET);
    }

    private  Consumer<Contact> strategyWriteConsoleColor(ConsoleColor COLOR){
        return (c) -> System.out.printf( "\n%s%s%s\n", COLOR , c.message.orElse("N/A"), ConsoleColor.ANSI_RESET);
    }

    private  Consumer<Contact> strategyWriteFile(){
        return UncheckedConsumer.of( c -> {
                                            System.out.printf("\nWrote at file %s\n\n",c.getUrl()
                                                    .get()
                                                    .getFileName());
                                            Files.writeString(c.url.get(),
                                                    c.getMessage()
                                                            .orElse("N/A"));
                                    });
    }

}





