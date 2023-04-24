package com.fieb.academico.service;

import java.util.Collection;

import com.fieb.academico.model.Curso;

public interface CursoService {
	Curso save(Curso curso);
	Collection<Curso> findAll();
	Curso findById(Long id);
}
