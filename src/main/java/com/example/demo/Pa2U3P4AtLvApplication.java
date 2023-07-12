package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.Hotel;
import com.example.demo.service.HotelService;

@SpringBootApplication
public class Pa2U3P4AtLvApplication implements CommandLineRunner {
	
	@Autowired
	private HotelService hotelService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4AtLvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("OUTER INNER JOIN");
		List<Hotel> listaHotel = this.hotelService.buscarInnerJoin();
		for ( Hotel h : listaHotel) {
			System.out.println(h);
		}
		
		System.out.println("OUTER RIGTH JOIN");
		List<Hotel> listaHotel2 = this.hotelService.buscararOuterRigthJoin();
		for ( Hotel h : listaHotel2) {
			System.out.println(h);
		}
		
		System.out.println("OUTER LEFT JOIN");
		List<Hotel> listaHotel3 = this.hotelService.buscarOuterLeftJoin();
		for ( Hotel h : listaHotel3) {
			System.out.println(h);
		}
		
		System.out.println("HABITACION OUTER LEFT JOIN");
		List<Habitacion> listaHotel4 = this.hotelService.BuscarHabitacionesOuterLeftJoin();
		for ( Habitacion h : listaHotel4) {
			System.out.println(h);
		}
		
		System.out.println("OUTER full JOIN");
		List<Hotel> listaHotel5 = this.hotelService.buscarOuterFullJoin();
		for ( Hotel h : listaHotel5) {
			if (h == null) {
				System.out.println("no existe aun un hotel");
			}else {
				System.out.println(h.getNombre());
			}
		}
		
		
		System.out.println(" WHERE JOIN");
		List<Hotel> listaHotel6 = this.hotelService.buscarWhereJoin();
		for ( Hotel h : listaHotel6) {
			System.out.println(h);
		}
		
	}

}
