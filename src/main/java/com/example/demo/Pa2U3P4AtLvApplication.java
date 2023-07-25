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
	
	@Autowired
	private PruebaService pruebaService;
	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4AtLvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		CuentaBancaria CUE = new CuentaBancaria();
		CUE.setSaldo(new BigDecimal(5000));
		CUE.setNumero("001");
		CUE.setTipo("Ahorros");
		System.out.println("main: "+TransactionSynchronizationManager.isActualTransactionActive());
		this.bancariaService.guardarCuenta(CUE);
		
	}
}
