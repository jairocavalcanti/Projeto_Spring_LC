package com.example.carros.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
 /*
 Todos os webservices do spring boot devem estar anotados com "RestController"
 isso transformara a classe num webservice REST
 */

@RestController
@RequestMapping("/")
public class IndexController {

    /*
    Se uma requisição for chamada, o método abaixo será chamado  
    */
   
    
   /*  
   GetMapping tem o mesmo efeito da linha de codigo escrita abaixo:
   @RequestMapping(method = RequestMethod.GET)
   tipo do metodo GET ,POST, PUT ou DELETE sera definido ao fim da linha
   */
  
    /*
    Mapeamento padrao da classe definido pelo RequestMapping("/") 
    sendo assim metodo abaixo sera mapeado pelo mesmo
    */
   @GetMapping
   public String hello(){
        return "Hello Spring boot";
    }
    
    /* 
    Mapeamento abaixo sendo definido como ("/teste")
    para que nao haja conflitos com mapeamento do metodo acima
    */
   @GetMapping("/teste")
   public String teste(){
       return "Teste Spring boot";
   }




}
