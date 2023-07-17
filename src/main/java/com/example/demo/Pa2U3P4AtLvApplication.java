package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Equipo;
import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.Hotel;
import com.example.demo.repository.modelo.Jugador;
import com.example.demo.service.EquipoService;

@SpringBootApplication
public class Pa2U3P4AtLvApplication implements CommandLineRunner {
	
	@Autowired
	private EquipoService equipoService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4AtLvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		
		System.out.println(">>>>>>>>>>OUTER INNER JOIN");
		List<Equipo> listaEquipos5 = this.equipoService.buscarInnerJoin();
		for ( Equipo e :listaEquipos5 ) {
			System.out.println(e);
		}
		
		System.out.println(">>>>>>>>>>OUTER INNER JOIN 2");
		List<Jugador> listaJugadores5 = this.equipoService.buscarJugadoresInnerJoin();
		for ( Jugador ju :listaJugadores5 ) {
			System.out.println(ju);
		}
		
		System.out.println(">>>>>>>>>>OUTER RIGTH JOIN");
		List<Equipo> listaEquipos = this.equipoService.buscarOuterRigthJoin();
		for ( Equipo e :listaEquipos ) {
			System.out.println(e);
		}
		
		System.out.println(">>>>>>>>>>OUTER RIGTH JOIN 2");
		List<Jugador> listaJugadores = this.equipoService.buscarJugadoresOuterRigthJoin();
		for ( Jugador ju :listaJugadores ) {
			System.out.println(ju);
		}
		
		System.out.println(">>>>>>>>>>OUTER LEFT JOIN");
		List<Equipo> listaEquipos2 = this.equipoService.buscarOuterLeftJoin();
		for ( Equipo e :listaEquipos2 ) {
			System.out.println(e);
		}
		
		System.out.println(">>>>>>>>>>OUTER LEFT JOIN 2");
		List<Jugador> listaJugadores2 = this.equipoService.buscarJugadoresOuterLeftJoin();
		for ( Jugador ju :listaJugadores2 ) {
			System.out.println(ju);
		}
		
		
		System.out.println(">>>>>>>>>>OUTER full JOIN");
		List<Equipo> listaEquipos3 = this.equipoService.buscarOuterFullJoin();
		for ( Equipo e :listaEquipos3 ) {
			System.out.println(e);
		}
		
		System.out.println(">>>>>>>>>>OUTER full JOIN 2");
		List<Jugador> listaJugadores3 = this.equipoService.buscarJugadoresOuterFullJoin();
		for ( Jugador ju :listaJugadores3 ) {
			System.out.println(ju);
		}
		
		System.out.println(">>>>>>>>>>WHERE JOIN");
		List<Equipo> listaEquipos4 = this.equipoService.buscarWhereJoin();
		for ( Equipo e :listaEquipos4 ) {
			System.out.println(e);
		}
		
		System.out.println(">>>>>>>>>>WHERE JOIN 2");
		List<Jugador> listaJugadores4 = this.equipoService.buscarJugadoresWhereJoin();
		for ( Jugador ju :listaJugadores4 ) {
			System.out.println(ju);
		}
		
		System.out.println(">>>>>>>>>>Join Fetch");
		List<Equipo> listaEquipo6 = this.equipoService.buscarFetchJoin();
		for ( Equipo e : listaEquipo6) {
			System.out.println(e.getNombre());
			System.out.println("FETCH Tiene los siguientes jugadores:");
			for(Jugador ju: e.getJugadores()) {
				System.out.println(ju.getNombre());
			}
		}
		
		System.out.println(">>>>>>>>>>Join Fetch 2");
		List<Equipo> listaEquipo7 = this.equipoService.buscarJugadoresFetchJoin();
		for ( Equipo e : listaEquipo7) {
			System.out.println(e.getNombre());
			System.out.println("tiene jugadores que su salario es mayor a 1000");
			for(Jugador ju: e.getJugadores()) {
				System.out.println(ju.getNombre());
			}
		}
		
	
		
		
		
	}
}
