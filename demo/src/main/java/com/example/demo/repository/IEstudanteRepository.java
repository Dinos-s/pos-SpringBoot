package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Estudante;

@Repository
public interface IEstudanteRepository extends JpaRepository<Estudante, Long>{
    
}
