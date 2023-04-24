package com.fieb.academico.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fieb.academico.model.Curso;
import com.fieb.academico.repository.CursoRepository;

@Service
public class CursoServiceImpl implements CursoService {
	@Autowired
	private CursoRepository cursoRepository;
	
	@Override
	public Curso save(Curso curso) {
		return cursoRepository.save(curso);
	}
	
	@Override
	public Collection<Curso> findAll() {
		return cursoRepository.findAll();
	}
	
	@Override
	public Curso findById(Long id) {
		return cursoRepository.getById(id);
	}
}
