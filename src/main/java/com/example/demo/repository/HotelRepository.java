package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.Hotel;

public interface HotelRepository {
	public List<Hotel> seleccionarInnerJoin();
	public List<Hotel> seleccionarOuterRigthJoin();
	public List<Hotel> seleccionarOuterLeftJoin();
	public List<Habitacion> seleccionarHabitacionesOuterLeftJoin();
	public List<Hotel> seleccionarOuterFullJoin();
	public List<Hotel> seleccionarWhereJoin();
	public List<Hotel> seleccionarFetchJoin();
	public void insertar (Hotel hotel);
}
