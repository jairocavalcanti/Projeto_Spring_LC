package com.example.carros.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class CarroService {

   @Autowired
   private CarroRepository rep;

   // Retornando todos os carros
   public Iterable<Carro> getCarros() {
      return rep.findAll();
   }

   // Retornado carros pelo ID
   public Optional<Carro> getCarrosById(Long id) {
      return rep.findById(id);
   }

   // Retornando carros pelo TIPO
   public List<Carro> getCarrosByTipo(String tipo) {
      return rep.findByTipo(tipo);
   }

   public Carro save(Carro carro) {
      return rep.save(carro);
   }

   /* 
   public List<Carro> getCarrosfake() {
      List<Carro> carros = new ArrayList<>();

      carros.add(new Carro(1l, "FUSCA", "Popular"));
      carros.add(new Carro(2L, "FIAT MAREA", "Popular"));
      carros.add(new Carro(3L, "BRASILIA AMARELA", "Popular"));

      return carros;
   } */

   public Carro update(Carro carro, Long id) {
      Assert.notNull(id, "Nao foi possivel atualizar o registro");

      // Busca o carro no banco de dados
      Optional<Carro> optional = getCarrosById(id);
      if (optional.isPresent()) {
         Carro db = optional.get();

         // Copiar as propriedades
         db.setNome(carro.getNome());
         db.setTipo(carro.getTipo());
         System.out.println("Carro id " + db.getId());

         // Por fim atualiza o carrro
         rep.save(db);

         return db;

      } else {
         throw new RuntimeException("Nao foi possivel atualizar o registro");
      }
   }

   public void delete(Long id) {
      Optional<Carro> carro = getCarrosById(id);
      if (carro.isPresent()) {
         rep.deleteById(id);
      }
   }
}
