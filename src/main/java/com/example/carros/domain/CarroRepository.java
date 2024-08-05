package com.example.carros.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CarroRepository extends CrudRepository<Carro, Long> {
    // Esta interface estende CrudRepository e é parametrizada com a classe Carro e
    // o tipo do ID (Long).

    // Metodo 'findbytipo' criado para busca de carros pelo tipo
    // iterable<Carro> findByTipo(String tipo);

    List<Carro> findByTipo(String tipo);

}
