package com.example.carros.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CarroService {

    public List<Carro> getCarros(){
       List<Carro> carros = new ArrayList<>();

       carros.add(new Carro(1l, "FUSCA"));
       carros.add(new Carro(2L, "FIAT MAREA"));
       carros.add(new Carro(3L, "BRASILIA AMARELA"));

       return carros;
    }
    
}
