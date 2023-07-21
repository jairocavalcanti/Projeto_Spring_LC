package com.example.carros.api;

//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
 
 /*
 Todos os webservices do spring boot devem estar anotados com "RestController"
 isso transformara a classe num webservice REST
 */

@RestController
@RequestMapping("/")
public class IndexController {

   
   /*  
   GetMapping tem o mesmo efeito da linha de codigo escrita abaixo:
   @RequestMapping(method = RequestMethod.GET)
   tipo do metodo GET ,POST, PUT ou DELETE sera definido ao fim da linha
   */
  
    /*
    Mapeamento padrao da classe definido pelo RequestMapping("/") 
    */
   
    /*
      Nao e recomendado passar a SENHA como parametro no get pois a senha fica visivel
      Sempre recomendado nesse tipo de caso utilizar o POS 
    */
     
    @PostMapping("/login")
     public String login(@RequestParam("login") String login, @RequestParam("senha") String senha){
        return "Login: " + login + ", Senha: " + senha;
     }







     /* 
       
     -- Exemplos basicos de operaçoes com GetMapping
     
    @GetMapping
    public String get(){
        return "Get Spring boot";
    }
    
    
    @GetMapping("/login/{login}/senha/{senha}")
    public String login(@PathVariable("login") String login, @PathVariable("senha") String senha){
        return "Login: " + login + ", Senha: " + senha;
     }
 
     @GetMapping("/carros/{id}")
     public String getcarroById(@PathVariable("id")Long id){
        return "Carro by id: " + id;
     }

     
     @GetMapping("/carros/tipo/{tipo}")
     public String getcarroByTipo(@PathVariable("tipo")String tipo){
        return "Lista Carros: " + tipo;
     }
*/

 
    /* 
   
    -- Exemplos Básicos de "operações" GET, POST , DELETE e PUT
   
    @GetMapping
    public String get(){
        return "Get Spring boot";
    }
   
    @PostMapping
    public String post(){
        return "Post Spring boot";
    }
   
    
    @DeleteMapping
    public String delete(){
        return "Delete Spring boot";
    }


   @PutMapping
   public String put(){
        return "Put Spring boot";
    }
    */



    /* 
    Mapeamento do metodo abaixo sendo definido como ("/teste")
    */
 
      //   @GetMapping("/teste")
     //    public String teste(){
    //     return "Teste Spring boot";
   //      }
    
    /* 
    Mapeamento do metodo abaixo sendo definido como ("/spring")
    */
       // @GetMapping("/spring")
      //  public String hello(){
     //   return "Hello Spring boot";
    //    }
   


}
