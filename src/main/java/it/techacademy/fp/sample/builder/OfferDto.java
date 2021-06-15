package it.techacademy.fp.sample.builder;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.function.Consumer;

@Data
public class OfferDto {

    private Integer code;
    private String description;
    private String type;
    private String channelName;



}
