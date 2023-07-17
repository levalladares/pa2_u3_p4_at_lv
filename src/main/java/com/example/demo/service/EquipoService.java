package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Equipo;
import com.example.demo.repository.modelo.Jugador;

public interface EquipoService {
	
	public List<Equipo> buscarInnerJoin();
	public List<Jugador> buscarJugadoresInnerJoin();
	public List<Equipo> buscarOuterRigthJoin();
	public List<Jugador> buscarJugadoresOuterRigthJoin();
	public List<Equipo> buscarOuterLeftJoin();
	public List<Jugador> buscarJugadoresOuterLeftJoin();
	public List<Equipo> buscarOuterFullJoin();
	public List<Jugador> buscarJugadoresOuterFullJoin();
	public List<Equipo> buscarWhereJoin();
	public List<Jugador> buscarJugadoresWhereJoin();
	public List<Equipo> buscarFetchJoin();
	public List<Equipo> buscarJugadoresFetchJoin();

}
