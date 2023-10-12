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

    @Scheduled(cron = "${cron.buscar.estudantes}")
    public void executeTarefa() {
        log.info("Tarefa Executada!");
    }
}
