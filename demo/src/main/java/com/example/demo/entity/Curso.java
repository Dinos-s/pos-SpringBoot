package com.example.demo.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Curso {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String nome;

	@OneToMany(mappedBy = "curso")
    private Set<AvaliacaoCurso> avaliacaoCursos;
}
