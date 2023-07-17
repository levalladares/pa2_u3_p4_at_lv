package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Equipo;
import com.example.demo.repository.modelo.Hotel;
import com.example.demo.repository.modelo.Jugador;


public interface EquipoRepository {
	
	public List<Equipo> seleccionarInnerJoin();
	public List<Jugador> seleccionarJugadoresInnerJoin();
	public List<Equipo> seleccionarOuterRigthJoin();
	public List<Jugador> seleccionarJugadoresOuterRigthJoin();
	public List<Equipo> seleccionarOuterLeftJoin();
	public List<Jugador> seleccionarJugadoresOuterLeftJoin();
	public List<Equipo> seleccionarOuterFullJoin();
	public List<Jugador> seleccionarJugadoresOuterFullJoin();
	public List<Equipo> seleccionarWhereJoin();
	public List<Jugador> seleccionarJugadoresWhereJoin();
	public List<Equipo> seleccionarFetchJoin();
	public List<Equipo> seleccionarJugadoresFetchJoin();
}
