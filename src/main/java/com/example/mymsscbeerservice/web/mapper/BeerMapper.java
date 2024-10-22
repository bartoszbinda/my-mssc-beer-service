package com.example.mymsscbeerservice.web.mapper;

import com.example.mymsscbeerservice.domain.Beer;
import com.example.mymsscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {
    BeerDto BeertoBeerDto(Beer beer);
    Beer BeerDtoToBeer(BeerDto beerDto);
}
