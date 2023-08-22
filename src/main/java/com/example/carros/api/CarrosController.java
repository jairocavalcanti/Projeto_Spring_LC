package com.example.carros.api;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.carros.domain.Carro;
import com.example.carros.domain.CarroService;
 

@RestController
@RequestMapping("/api/v1/carros")
public class CarrosController {
    
     @Autowired
     private CarroService service;

     @GetMapping()
     public Iterable<Carro> get(){
        return service.getCarros();
     }

     //metodo "pegando" carro pelo ID atraves do optional na classe 'carroservice'
     @GetMapping("/{id}")
     public Optional<Carro> get(@PathVariable ("id") Long id){
        return service.getCarrosById(id);
     }

      //metodo "pegando" carro pelo TIPO atraves do iterable na classe 'carroservice'
     @GetMapping("/tipo/{tipo}")
     public Iterable<Carro> getCarrosByTipo(@PathVariable ("tipo") String tipo){
        return service.getCarrosByTipo(tipo);
     }

}
