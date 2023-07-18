package com.example.demo.repository;

import com.example.demo.repository.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public interface EstudianteRepository {
	
	public void insertar(Estudiante estudiante);
	

}
