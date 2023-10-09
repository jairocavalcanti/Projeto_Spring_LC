package com.example.carros.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarroService {

    @Autowired
    private CarroRepository rep;

    //Retornando todos os carros
     public Iterable<Carro> getCarros(){
       return rep.findAll();
    }

    //Retornado carros pelo ID
    public Optional<Carro> getCarrosById(Long id) {
        return rep.findById(id);
    }
    
    //Retornando carros pelo TIPO
    public Iterable<Carro> getCarrosByTipo(String tipo) {
        return rep.findByTipo(tipo);
    }

    public Carro save(Carro carro) {
      return rep.save(carro);
    }

    public List<Carro> getCarrosfake(){
       List<Carro> carros = new ArrayList<>();

       carros.add(new Carro(1l, "FUSCA"));
       carros.add(new Carro(2L, "FIAT MAREA"));
       carros.add(new Carro(3L, "BRASILIA AMARELA"));

       return carros;
    }



  
  


  


   
    
}
