package it.techacademy.fp.sample.fun;

import lombok.Data;

import java.nio.file.Path;
import java.util.Optional;
import java.util.function.Consumer;

@Data
public class Contact {

    public Optional<String> message;
    public Optional<String> phone;
    public Optional<String> email;
    public Optional<Path> url;

    private Contact(Contact.Builder builder){
        message = Optional.ofNullable(builder.message);
        email = Optional.ofNullable(builder.email);
        phone = Optional.ofNullable(builder.phone);
        url = builder.url==null?Optional.empty():Optional.of(Path.of(builder.url));
    }

    @Data
    public static class Builder {

        public String message;
        public String phone;
        public String  email;
        public  String  url;


        public Contact.Builder with(Consumer<Contact.Builder> consumer ){
            consumer.accept(this);
            return this;
        }

        public Contact build() {
            return new Contact(this);
        }
    }

}
