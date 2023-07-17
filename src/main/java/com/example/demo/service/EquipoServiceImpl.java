package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.EquipoRepository;
import com.example.demo.repository.modelo.Equipo;
import com.example.demo.repository.modelo.Jugador;
@Service
public class EquipoServiceImpl implements EquipoService{
	@Autowired
	private EquipoRepository equipoRepository;
	@Override
	public List<Equipo> buscarInnerJoin() {
		// TODO Auto-generated method stub
		return this.equipoRepository.seleccionarInnerJoin();
	}

	@Override
	public List<Jugador> buscarJugadoresInnerJoin() {
		// TODO Auto-generated method stub
		return this.equipoRepository.seleccionarJugadoresInnerJoin();
	}

	@Override
	public List<Equipo> buscarOuterRigthJoin() {
		// TODO Auto-generated method stub
		return this.equipoRepository.seleccionarOuterRigthJoin();
	}

	@Override
	public List<Jugador> buscarJugadoresOuterRigthJoin() {
		// TODO Auto-generated method stub
		return this.equipoRepository.seleccionarJugadoresOuterRigthJoin();
	}

	@Override
	public List<Equipo> buscarOuterLeftJoin() {
		// TODO Auto-generated method stub
		return this.equipoRepository.seleccionarOuterLeftJoin();
	}

	@Override
	public List<Jugador> buscarJugadoresOuterLeftJoin() {
		// TODO Auto-generated method stub
		return this.equipoRepository.seleccionarJugadoresOuterLeftJoin();
	}

	@Override
	public List<Equipo> buscarOuterFullJoin() {
		// TODO Auto-generated method stub
		return this.equipoRepository.seleccionarOuterFullJoin();
	}

	@Override
	public List<Jugador> buscarJugadoresOuterFullJoin() {
		// TODO Auto-generated method stub
		return this.equipoRepository.seleccionarJugadoresOuterFullJoin();
	}

	@Override
	public List<Equipo> buscarWhereJoin() {
		// TODO Auto-generated method stub
		return this.equipoRepository.seleccionarWhereJoin();
	}

	@Override
	public List<Jugador> buscarJugadoresWhereJoin() {
		// TODO Auto-generated method stub
		return this.equipoRepository.seleccionarJugadoresWhereJoin();
	}

	@Override
	public List<Equipo> buscarFetchJoin() {
		// TODO Auto-generated method stub
		return this.equipoRepository.seleccionarFetchJoin();
	}

	@Override
	public List<Equipo> buscarJugadoresFetchJoin() {
		// TODO Auto-generated method stub
		return this.equipoRepository.seleccionarJugadoresFetchJoin();
	}

}
