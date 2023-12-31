package com.example.demo.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Estudante;
import com.example.demo.service.EstudanteService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("estudantes")
@AllArgsConstructor
public class EstudanteController {

    private EstudanteService estudanteService;

    @GetMapping(value = "/{id}", produces = "apllication/json")
    @ApiOperation(value = "buscar estudante por id", notes = "Listar um estudante")
    @ApiResponses({
        @ApiResponse(code = 401, message = "Acesso não autorizado."),
        @ApiResponse(code = 403, message = "Proibido."),
        @ApiResponse(code = 404, message = "Não encontrado."),
    })
    // Listando um estudante:
    public ResponseEntity<Estudante> buscarEstudantePorId(@PathVariable Long id) {
        return estudanteService.buscarEstudantePorId(id);
    }

    @GetMapping
    // Listando todos os estudantes
    public Page<Estudante> buscarTodosEstudantes(@RequestParam(defaultValue = "0") Integer pagina,
            @RequestParam(defaultValue = "5") Integer itensPorPagina) {
        return estudanteService.buscarTodosEstudantes(PageRequest.of(pagina, itensPorPagina));
    }

    @PostMapping
    // Cadastrando um estudante
    public ResponseEntity<Estudante> cadastrarEstudante(@RequestBody Estudante estudante) {
        return estudanteService.cadastrarEstudante(estudante);
    }

    @PutMapping("/{id}")
    // Atualizar estudante
    public ResponseEntity<Estudante> atualizarEstudante(@PathVariable Long id, @RequestBody Estudante estudante) {
        return estudanteService.atualizarEstudante(id, estudante);
    }

    @DeleteMapping("/{id}")
    // Removendo Estudante
    public ResponseEntity<String> removerEstudante(@PathVariable Long id) {
        return estudanteService.removerEstudante(id);
    }

    @GetMapping("/naoAvaliaram")
    public List<Estudante> buscarEstudantesQueNaoAvaliaram(){
        return estudanteService.buscarEstudantesQueNaoAvaliaram();
    }
}
