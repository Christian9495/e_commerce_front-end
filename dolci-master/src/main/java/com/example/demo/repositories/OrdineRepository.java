package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Ordine;

@Repository
public interface OrdineRepository extends CrudRepository<Ordine, Integer>{

}
