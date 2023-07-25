package com.example.carros.domain;

import java.util.ArrayList;
import java.util.List;

public class CarroService {

    public List<Carro> getCarros(){
       List<Carro> carros = new ArrayList<>();

       carros.add(new Carro(1l, "FUSCA"));
       carros.add(new Carro(2L, "MAREA"));
       carros.add(new Carro(3L, "BRASILIA AMARELA"));

       return carros;
    }
    
}
