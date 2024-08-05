package com.example.carros.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // todos os webservices do spring boot precisam estar anotados com
                // "restcontroller", isso transforma a classe e um webservice rest
@RequestMapping("/") // "requestmapping" mapeia o webservice no caso para o "/"
public class IndexController {

   @GetMapping() // "getmapping" mapeia o metodo abaixo como uma requisição get
   public String get() {
      return " -- API dos carros -- ";
   }

}
