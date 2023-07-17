package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Equipo;
import com.example.demo.repository.modelo.Hotel;
import com.example.demo.repository.modelo.Jugador;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EquipoRepositoryImpl implements EquipoRepository{

	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public List<Equipo> seleccionarInnerJoin() {
		String jpql ="SELECT e FROM Equipo e INNER JOIN e.jugadores ju";
		TypedQuery <Equipo> myQuery  = this.entityManager.createQuery(jpql,Equipo.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Jugador> seleccionarJugadoresInnerJoin() {
		String jpql ="SELECT ju FROM Equipo e INNER JOIN e.jugadores ju";
		TypedQuery <Jugador> myQuery  = this.entityManager.createQuery(jpql,Jugador.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Equipo> seleccionarOuterRigthJoin() {
		String jpql ="SELECT e FROM Equipo e RIGHT JOIN e.jugadores ju";
        TypedQuery <Equipo> myQuery  = this.entityManager.createQuery(jpql,Equipo.class);
        return myQuery.getResultList();
	}

	@Override
	public List<Jugador> seleccionarJugadoresOuterRigthJoin() {
		String jpql ="SELECT ju FROM Equipo e RIGHT JOIN e.jugadores ju";
        TypedQuery <Jugador> myQuery  = this.entityManager.createQuery(jpql,Jugador.class);
        return myQuery.getResultList();
	}

	@Override
	public List<Equipo> seleccionarOuterLeftJoin() {
		String jpql ="SELECT e FROM Equipo e LEFT JOIN e.jugadores ju";
        TypedQuery <Equipo> myQuery  = this.entityManager.createQuery(jpql,Equipo.class);
        return myQuery.getResultList();
	}

	@Override
	public List<Jugador> seleccionarJugadoresOuterLeftJoin() {
		String jpql ="SELECT ju FROM Equipo e LEFT JOIN e.jugadores ju";
        TypedQuery <Jugador> myQuery  = this.entityManager.createQuery(jpql,Jugador.class);
        return myQuery.getResultList();
	}

	@Override
	public List<Equipo> seleccionarOuterFullJoin() {
		String jpql ="SELECT e FROM Equipo e FULL JOIN e.jugadores ju";
        TypedQuery <Equipo> myQuery  = this.entityManager.createQuery(jpql,Equipo.class);
        return myQuery.getResultList();
	}

	@Override
	public List<Jugador> seleccionarJugadoresOuterFullJoin() {
		String jpql ="SELECT ju FROM Equipo e FULL JOIN e.jugadores ju";
        TypedQuery <Jugador> myQuery  = this.entityManager.createQuery(jpql,Jugador.class);
        return myQuery.getResultList();
	}

	@Override
	public List<Equipo> seleccionarWhereJoin() {
		String jpql ="SELECT e FROM Equipo e, Jugador ju WHERE e=ju.equipo";
        TypedQuery <Equipo> myQuery  = this.entityManager.createQuery(jpql,Equipo.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Jugador> seleccionarJugadoresWhereJoin() {
		String jpql ="SELECT ju FROM Equipo e, Jugador ju WHERE e=ju.equipo";
        TypedQuery <Jugador> myQuery  = this.entityManager.createQuery(jpql,Jugador.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Equipo> seleccionarFetchJoin() {
		String jpql ="SELECT e FROM Equipo e JOIN FETCH e.jugadores ju";
        TypedQuery <Equipo> myQuery  = this.entityManager.createQuery(jpql,Equipo.class);
        return myQuery.getResultList();
	}

	@Override
	public List<Equipo> seleccionarJugadoresFetchJoin() {
		String jpql ="SELECT e FROM Equipo e JOIN FETCH e.jugadores ju WHERE ju.salario > 1000";
        TypedQuery <Equipo> myQuery  = this.entityManager.createQuery(jpql,Equipo.class);
        return myQuery.getResultList();
	}

}
