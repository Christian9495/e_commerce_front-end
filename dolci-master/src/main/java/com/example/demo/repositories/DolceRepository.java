package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Dolce;

@Repository
public interface DolceRepository extends CrudRepository<Dolce, Integer>{

}
