package com.example.demo.service;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IAvaliacaoCursoRepository;
import com.example.demo.repository.ICursoRepository;
import com.example.demo.repository.IEstudanteRepository;
import com.example.demo.entity.Curso;
import com.example.demo.entity.Estudante;
import com.example.demo.entity.AvaliacaoCurso;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AvaliacaoCursoService {
    private final IAvaliacaoCursoRepository avaliacaoRepository;
    private final IEstudanteRepository estudanteRepository;
    private final ICursoRepository cursoRepository;

    public ResponseEntity<String> avaliar(Long idEstudante, String nomeCurso, Integer notaAvaliacao){
        Optional<Estudante> estudanteOpt = estudanteRepository.findById(idEstudante);
        if(!estudanteOpt.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estudante não encontrado!");
        }

        Optional<Curso> cursoOpt = cursoRepository.findByNome(nomeCurso);
        if(!cursoOpt.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Curso não encontrado!");
        }

        AvaliacaoCurso avaliacaoCurso = new AvaliacaoCurso();
		avaliacaoCurso.setEstudante(estudanteOpt.get());
		avaliacaoCurso.setCurso(cursoOpt.get());
		avaliacaoCurso.setNotaDaAvaliacao(notaAvaliacao);
		
		avaliacaoRepository.save(avaliacaoCurso);
		return ResponseEntity.ok("Avaliação salva com sucesso!");
	}
}
