package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.HotelRepository;
import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.Hotel;

@Service
public class HotelServiceImpl implements HotelService{
	
	@Autowired
	private HotelRepository hotelRepository;
	@Override
	public List<Hotel> buscarInnerJoin() {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarInnerJoin();
	}
	
	@Override
	public List<Hotel> buscararOuterRigthJoin() {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarOuterRigthJoin();
	}

	@Override
	public List<Hotel> buscarOuterLeftJoin() {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarOuterLeftJoin();
	}

	@Override
	public List<Habitacion> BuscarHabitacionesOuterLeftJoin() {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarHabitacionesOuterLeftJoin();
	}

	@Override
	public List<Hotel> buscarOuterFullJoin() {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarOuterFullJoin();
	}

	@Override
	public List<Hotel> buscarWhereJoin() {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarWhereJoin();
	}

	@Override
	public List<Hotel> buscarJoinFetch() {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarFetchJoin();
	}

	@Override
	public void guardar(Hotel hotel) {
		// TODO Auto-generated method stub
		List <Habitacion> habitaciones = hotel.getHabitaciones();
		for(Habitacion h :habitaciones ) {
			BigDecimal iva =  new BigDecimal(1.12);
			h.setValorIncluidoIva(iva.multiply(h.getValor()));
		}
		this.hotelRepository.insertar(hotel);
	}

}
