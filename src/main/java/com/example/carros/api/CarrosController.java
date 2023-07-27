package com.example.carros.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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



}
