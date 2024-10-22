package com.example.mymsscbeerservice.web.service;

import com.example.mymsscbeerservice.domain.Beer;
import com.example.mymsscbeerservice.repository.BeerRepository;
import com.example.mymsscbeerservice.web.model.BeerDto;
import com.example.mymsscbeerservice.web.model.BeerPagedList;
import com.example.mymsscbeerservice.web.model.BeerStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class BeerService {
    final BeerRepository beerRepository;

    public BeerService(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    public BeerDto getBeer(UUID beerId) {
        return beerRepository.findById(beerId).map(beer -> BeerDto.builder()
                .id(beer.getId())
                .beerName(beer.getBeerName())
                .beerStyle(BeerStyle.valueOf(beer.getBeerStyle()))
                .price(beer.getPrice())
                .upc(beer.getUpc())
                .build()).orElse(null);
    }
    public BeerPagedList getBeers() {
        List<Beer> beers = new ArrayList<>();
        beerRepository.findAll().forEach(beers::add);
        return new BeerPagedList(beers.stream().map(beer -> BeerDto.builder()
                .id(beer.getId())
                .beerName(beer.getBeerName())
                .beerStyle(BeerStyle.valueOf(beer.getBeerStyle()))
                .price(beer.getPrice())
                .upc(beer.getUpc())
                .build()).toList());
    }

}
