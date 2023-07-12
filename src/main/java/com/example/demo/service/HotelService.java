package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.Hotel;

public interface HotelService {
	
	public List<Hotel> buscarInnerJoin();
	public List<Hotel> buscararOuterRigthJoin();
	public List<Hotel> buscarOuterLeftJoin();
	public List<Habitacion> BuscarHabitacionesOuterLeftJoin();
	public List<Hotel> buscarOuterFullJoin();
	public List<Hotel> buscarWhereJoin();
}
