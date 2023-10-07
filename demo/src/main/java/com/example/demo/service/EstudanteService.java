package com.example.demo.service;

// import java.util.Map;
// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Estudante;
import com.example.demo.repository.IEstudanteRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EstudanteService {
    private IEstudanteRepository estudanteRepository;

    // Listando um estudante:
    public ResponseEntity<Estudante> buscarEstudantePorId(Long id) {
        if (estudanteRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.OK).body(estudanteRepository.findById(id).get());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    // Listando todos os estudantes
    public Page<Estudante> buscarTodosEstudantes(PageRequest page) {
        return estudanteRepository.findAll(page);
    }

    // Cadastrando um estudante
    public ResponseEntity<Estudante> cadastrarEstudante(Estudante estudante){
        Estudante estudantesSalvo = estudanteRepository.save(estudante);
        return ResponseEntity.status(HttpStatus.CREATED).body(estudantesSalvo);
    }

    // Atualizar estudante
    public ResponseEntity<Estudante> atualizarEstudante(Long id, Estudante estudante){
        if (estudanteRepository.existsById(id)) {
            Estudante estudantesSalvo = estudanteRepository.save(estudante);
            return ResponseEntity.status(HttpStatus.OK).body(estudantesSalvo);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    // Removendo estudante
    public ResponseEntity<String> removerEstudante(Long id){
        if (estudanteRepository.existsById(id)) {
            estudanteRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Estudante Deletado com  SUCESSO!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
}
