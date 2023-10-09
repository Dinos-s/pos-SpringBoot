package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.AtividadeAsyncService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/asyncs")
@AllArgsConstructor
@Slf4j
public class AtividadeAsyncController {
    private final AtividadeAsyncService atividadeAsyncService;

    @GetMapping
    public ResponseEntity<String> executarTarefa() throws InterruptedException {
        log.info("Executando tarefa no thread: " + Thread.currentThread().getName());
        atividadeAsyncService.executarTarefaAsync();
        return ResponseEntity.ok("Atividade iniciada com sucesso");
    }
}
