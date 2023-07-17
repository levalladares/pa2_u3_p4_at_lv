package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.CuentaBancaria;
import com.example.demo.repository.modelo.Equipo;
import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.Hotel;
import com.example.demo.repository.modelo.Jugador;
import com.example.demo.repository.modelo.Propietario;
import com.example.demo.repository.modelo.Transferencia;
import com.example.demo.service.CuentaBancariaService;
import com.example.demo.service.EquipoService;

@SpringBootApplication
public class Pa2U3P4AtLvApplication implements CommandLineRunner {
	
	@Autowired
	private CuentaBancariaService bancariaService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4AtLvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Propietario propietario= new Propietario();
		propietario.setNombre("Luis");
		propietario.setApellido("Valladares");
		propietario.setCedula("1723973796");
		
		Propietario propietario2= new Propietario();
		propietario2.setNombre("Luissss");
		propietario2.setApellido("Valladaresssssss");
		propietario2.setCedula("1723973796");
		
		CuentaBancaria bancaria = new CuentaBancaria();
		bancaria.setNumero("00001");
		bancaria.setSaldo(new BigDecimal(5000));
		bancaria.setTipo("Ahorro");
		bancaria.setPropietario(propietario);
		this.bancariaService.guardarCuenta(bancaria);
		System.out.println("guardo cuenta1");
		
		CuentaBancaria bancaria2 = new CuentaBancaria();
		bancaria2.setNumero("00002");
		bancaria2.setSaldo(new BigDecimal(5000));
		bancaria2.setTipo("Ahorro");
		bancaria2.setPropietario(propietario2);
		this.bancariaService.guardarCuenta(bancaria2);
		System.out.println("guardo cuenta2");
		
		System.out.println("creo transferencia");
		this.bancariaService.crearTransferencia(bancaria, bancaria2, new BigDecimal(50));
		
		
		System.out.println("SQL Join Fetch");
		List<CuentaBancaria> listaHotelf = this.bancariaService.seleccionarTrasnferencias();
		for ( CuentaBancaria h : listaHotelf) {
			System.out.println(h.getPropietario().getNombre());
			System.out.println("tiene los siguientes transferencias");
			for(Transferencia t : h.getTransferenciasDestino()) {
				System.out.println(t.getMonto());
			}
		}
		
		
	}
}
