package com.example.demo.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class AtividadeAsyncService {

	NotificacaoService notificacaoService;

	@Async
	public void executarTarefaAsync() throws InterruptedException {
		log.info("Executando uma tarefa que demora muito tempo na thread: ");
		
		Thread.sleep(5000);

		notificacaoService.publicar("Tarefa finalizada com sucesso");
	}
}
