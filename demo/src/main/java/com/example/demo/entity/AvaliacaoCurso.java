package com.example.demo.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class AvaliacaoCurso {
    @EmbeddedId
    private AvaliacaoCursoKey id = new AvaliacaoCursoKey();

    @ManyToOne
    @MapsId("estudanteId")
    @JoinColumn(name = "estudante_id")
    Estudante estudante;

    @ManyToOne
    @MapsId("cursoId")
    @JoinColumn(name = "curso_id")
    Curso curso;

    int notaDaAvaliacao;
}
