package com.fieb.academico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fieb.academico.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long>{
	
}
