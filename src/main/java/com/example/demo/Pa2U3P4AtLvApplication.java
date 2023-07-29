package com.example.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.demo.repository.modelo.CuentaBancaria;
import com.example.demo.repository.modelo.Propietario;
import com.example.demo.service.CuentaBancariaService;
import com.example.demo.service.PruebaService;

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
		CuentaBancaria CUE2 = new CuentaBancaria();
		CUE2.setSaldo(new BigDecimal(500000));
		CUE2.setNumero("008");
		CUE2.setTipo("Ahorros");
		this.bancariaService.guardarCuenta(CUE2);
		
		CuentaBancaria CUE = new CuentaBancaria();
		CUE.setSaldo(new BigDecimal(5000));
		CUE.setNumero("009");
		CUE.setTipo("Ahorros");
		this.bancariaService.guardarCuenta(CUE);
		
		this.bancariaService.crearTransferencia(CUE2, CUE, new BigDecimal(10));;
		
	}
}
