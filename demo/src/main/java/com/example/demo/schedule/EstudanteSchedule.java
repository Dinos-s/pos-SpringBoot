package com.example.demo.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.example.demo.repository.IEstudanteRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@AllArgsConstructor
public class EstudanteSchedule {

    private final IEstudanteRepository estudanteRepository;
    /*
	 * A tarefa sempre espera até que a anterior seja concluída. 
	 * Esta opção deve ser utilizada quando for obrigatório que a 
	 * execução anterior seja concluída antes de ser executada novamente.
	 */
//	@Scheduled(fixedDelay = 1000)
	/*
	 * “@Scheduled(cron = “1 2 3 4 5 6")”

		1: segundo (preenchido de 0 a 59)
		2: minuto (preenchido de 0 a 59)
		3 hora (preenchido de 0 a 23)
		4 dia (preenchido de 0 a 31)
		5 mês (preenchido de 1 a 12)
		6 dia da semana (preenchido de 0 a 6)
		Nessa configuração @Scheduled(cron = “0 12 21 * * *”) esse método será executado todos os dias às 21h12 em ponto.
	 */

    @Scheduled(cron = "${cron.buscar.estudantes}")
    public void executeTarefa() {
        log.info("Tarefa Executada!");
    }
}
