package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Elemento;
@Repository
public interface ElementoRepository extends CrudRepository<Elemento, Integer>{

}
