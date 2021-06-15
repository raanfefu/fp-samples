package it.techacademy.fp.sample.stream;

import it.techacademy.fp.sample.repository.OfferrRepository;
import it.techacademy.fp.sample.builder.Offer;
import it.techacademy.fp.sample.builder.OfferDto;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


public class OfferService {

    OfferrRepository repository;
    public OfferService(){
        this.repository = new OfferrRepository();
    }

    public List<OfferDto> getOffer(){

        return repository.getAll()
                .stream()
                .map( mapper())
                .collect( Collectors.toList());
    }

    public Function<Offer, OfferDto> mapper(){
        return (offer) -> {
            OfferDto dto = new OfferDto();
            dto.setCode(offer.getCode());
            dto.setDescription(offer.getDescription());
            dto.setType(offer.getType()!=null? offer.getType().toUpperCase():"N/A");
            dto.setChannelName(offer.getChannelName());
            return  dto;
        };
    }
}
