package it.techacademy.fp.sample.builder;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Offer implements Serializable {

    private Integer code;
    private String description;
    private String type;
    private String channelName;


}
