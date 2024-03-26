package com.example.carros.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
     public ResponseEntity<Iterable<Carro>> get(){
       return ResponseEntity.ok(service.getCarros()); 
      //return new ResponseEntity<>(service.getCarros(), HttpStatus.OK);
      }

     //metodos precisam ter mapeamentos diferentes
     
     //metodo "pegando" carro pelo ID atraves do optional na classe 'carroservice'
   
     @GetMapping("/{id}")
     public ResponseEntity get(@PathVariable ("id") Long id){
        Optional<Carro> carro = service.getCarrosById(id);

        //Formas de implementar o erro '404 not found'
        
        return  carro.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
        
       // return carro.isPresent() ?
       //      ResponseEntity.ok(carro.get()):
       //     ResponseEntity.notFound().build();

        // if(carro.isPresent()){
        //   Carro c = carro.get();
        //   return ResponseEntity.ok(carro.get());
        //  }else{
        //    return ResponseEntity.notFound().build();
      }


     // "Path Variable" serve para inserção de dados na requisição de forma mais sofisticada

     // metodo "pegando" carro pelo TIPO atraves do iterable na classe 'carroservice'
     @GetMapping("/tipo/{tipo}")
     public ResponseEntity getCarrosByTipo(@PathVariable ("tipo") String tipo){
       List<Carro> carros = service.getCarrosByTipo(tipo);

       // Se a lista de carros estiver vazia
       return carros.isEmpty() ?
              // Retornamos o "noContent().build()" que é o 204
              ResponseEntity.noContent().build() :
              // Caso contrario retorne 'ok' e passe a lista de carros
              // ':' significa caso contrario
              ResponseEntity.ok(carros);    
      }

    
     // 'RequestBody' converte o json do 'carro' para o objeto carro
     // O json precisa ter os mesmos atributos do objeto, exceto "id" que é autoincrementado
     @PostMapping
     public String post(@RequestBody Carro carro){
        Carro c = service.save(carro);
    
        return "Carro salvo com sucesso: " + c.getId();
     
      }

      //!! ALTERAÇÕES DE DADOS PODEM SER FEITAS PASSANDO O ID COMO PARAMETRO ATRAVES DO METODO "post" DA APLICAÇÃO !! 
      
      @PutMapping("{id}")
      public String put(@PathVariable("id") Long id, @RequestBody Carro carro){

         Carro c = service.update(carro, id);

         return "Carro atualizado com sucesso: " + c.getId();
      }

      @DeleteMapping("/{id}")
      public String delete(@PathVariable("id") Long id){
         
         service.delete(id);

         return "Carro deletado com sucesso";
      }
   
   }
