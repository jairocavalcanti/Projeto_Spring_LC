package com.example.carros.api;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.carros.domain.Carro;
import com.example.carros.domain.CarroService;
 

@RestController // Indica que esta classe é um controlador REST
@RequestMapping("/api/v1/carros") // Define o mapeamento de URL para todas as rotas neste controlador
public class CarrosController {
    
     @Autowired // Injeção de dependência: Spring irá injetar uma instância de CarroService automaticamente.
     private CarroService service;

     @GetMapping() // Mapeia a rota GET "/api/v1/carros".
     public Iterable<Carro> get(){
        return service.getCarros();
     }

     //metodos precisam ter mapeamentos diferentes
     
     //metodo "pegando" carro pelo ID atraves do optional na classe 'carroservice'
     @GetMapping("/{id}")
     public Optional<Carro> get(@PathVariable ("id") Long id){
        return service.getCarrosById(id);
     }

      // "Path Variable" serve para inserção de dados na requisição de forma mais sofisticada


      //metodo "pegando" carro pelo TIPO atraves do iterable na classe 'carroservice'
     @GetMapping("/tipo/{tipo}")
     public Iterable<Carro> getCarrosByTipo(@PathVariable ("tipo") String tipo){
        return service.getCarrosByTipo(tipo);
     }

}
