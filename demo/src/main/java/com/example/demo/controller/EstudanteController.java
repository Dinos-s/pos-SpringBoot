package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Estudante;
import com.example.demo.service.EstudanteService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("estudantes")
@AllArgsConstructor
public class EstudanteController {

    private EstudanteService estudanteService;

    @GetMapping("/{id}")
    // Listando um estudante:
    public ResponseEntity<Estudante> buscarEstudantePorId(@PathVariable Long id) {
        return estudanteService.buscarEstudantePorId(id);
    }

    @GetMapping
    // Listando todos os estudantes
    public List<Estudante> buscarTodosEstudantes() {
        return estudanteService.buscarTodosEstudantes();
    }

    @PostMapping
    // Cadastrando um estudante
    public ResponseEntity<Estudante> cadastrarEstudante(@RequestBody Estudante estudante){
        return estudanteService.cadastrarEstudante(estudante);
    }

    @PutMapping("/{id}")
    // Atualizar estudante
    public ResponseEntity<Estudante> atualizarEstudante(@PathVariable Long id, @RequestBody Estudante estudante){
        return estudanteService.atualizarEstudante(estudante);
    }

    @DeleteMapping("/{id}")
    // Removendo Estudante
    public ResponseEntity<String> removerEstudante(@PathVariable Long id){
        return estudanteService.removerEstudante(id);
    }
}