package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.CuentaBancaria;
import com.example.demo.service.CuentaBancariaService;

@SpringBootApplication
public class Pa2U3P4AtLvApplication implements CommandLineRunner {
	private static final Logger LOG= LoggerFactory.getLogger(Pa2U3P4AtLvApplication.class);
	@Autowired
	private CuentaBancariaService bancariaService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4AtLvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		LOG.info("hilo: "+ Thread.currentThread().getName()); //<< indica el nombre del hilo con el que se ejecuta el programa
		
		
		/*//inicio
		long tiempoInicial=System.currentTimeMillis();
		for(int i =1;i<=30;i++) {
			CuentaBancaria CUE2 = new CuentaBancaria();
			CUE2.setSaldo(new BigDecimal(500000));
			CUE2.setNumero(String.valueOf(i));
			CUE2.setTipo("Ahorros");
			this.bancariaService.guardarCuenta(CUE2);
		}
		//fin
		long tiempoFinal=System.currentTimeMillis();
		long tiempoTranscurrido=(tiempoFinal-tiempoInicial)/1000;
		LOG.info("Tiempo transcurrido: "+(tiempoFinal-tiempoInicial));
		LOG.info("Tiempo transcurrido: "+tiempoTranscurrido );*/
		
//		//inicio
//		long tiempoInicial=System.currentTimeMillis();
//		List <CuentaBancaria> lista= new ArrayList<>();
//		for(int i =1;i<=100;i++) {
//			CuentaBancaria CUE2 = new CuentaBancaria();
//			CUE2.setSaldo(new BigDecimal(500000));
//			CUE2.setNumero(String.valueOf(i));
//			CUE2.setTipo("Ahorros");
//			lista.add(CUE2);
//		}
////		lista.stream().forEach(cta-> this.bancariaService.guardarCuenta(cta));
//		lista.parallelStream().forEach(cta-> this.bancariaService.guardarCuenta(cta));  //sirve para poner en multihilos
//		//fin
//		long tiempoFinal=System.currentTimeMillis();
//		long tiempoTranscurrido=(tiempoFinal-tiempoInicial)/1000;
//		LOG.info("Tiempo transcurrido: "+(tiempoFinal-tiempoInicial));
//		LOG.info("Tiempo transcurrido: "+tiempoTranscurrido );
		
		
		//inicio
		long tiempoInicial2=System.currentTimeMillis();
		List <CuentaBancaria> lista2= new ArrayList<>();
		for(int i =1;i<=100;i++) {
			CuentaBancaria CUE3 = new CuentaBancaria();
			CUE3.setSaldo(new BigDecimal(500000));
			CUE3.setNumero(String.valueOf(i));
			CUE3.setTipo("Ahorros");
			lista2.add(CUE3);
		}
//		lista.stream().forEach(cta-> this.bancariaService.guardarCuenta(cta));
		Stream<String>listaFinal=lista2.parallelStream().map(cta-> this.bancariaService.guardarCuenta2(cta));  //sirve para poner en multihilos
		LOG.info("Se guardaron las siguientes cuentas: ");
		listaFinal.forEach(cadena-> LOG.info(cadena));
		//fin
		long tiempoFinal2=System.currentTimeMillis();
		long tiempoTranscurrido2=(tiempoFinal2-tiempoInicial2)/1000;
		LOG.info("Tiempo transcurrido: "+(tiempoFinal2-tiempoInicial2));
		LOG.info("Tiempo transcurrido: "+tiempoTranscurrido2 );
		
	}
}
