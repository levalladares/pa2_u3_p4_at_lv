package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import com.example.demo.repository.modelo.CuentaBancaria;
import com.example.demo.service.CuentaBancariaService;

@SpringBootApplication
@EnableAsync
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
//		//ASINCRONO SIN RESPUESTA
//		LOG.info("hilo: "+ Thread.currentThread().getName()); //<< indica el nombre del hilo con el que se ejecuta el programa
//	
//		//inicio
//		long tiempoInicial2=System.currentTimeMillis();
//		List <CuentaBancaria> lista2= new ArrayList<>();
//		for(int i =1;i<=10;i++) {
//			CuentaBancaria CUE3 = new CuentaBancaria();
//			CUE3.setSaldo(new BigDecimal(500000));
//			CUE3.setNumero(String.valueOf(i));
//			CUE3.setTipo("Ahorros");
//			lista2.add(CUE3);
//			this.bancariaService.agregarAsincrono(CUE3);
//		}
//		
//		//fin
//		long tiempoFinal2=System.currentTimeMillis();
//		long tiempoTranscurrido2=(tiempoFinal2-tiempoInicial2)/1000;
//		LOG.info("Tiempo transcurrido: "+(tiempoFinal2-tiempoInicial2));
//		LOG.info("Tiempo transcurrido: "+tiempoTranscurrido2 );
//		
//		LOG.info("Se termino todo el proceso" );
		
		
		
		//ASINCRONO FUTURO CON RESPUESTA
		LOG.info("hilo: "+ Thread.currentThread().getName()); //<< indica el nombre del hilo con el que se ejecuta el programa
		
		//inicio
		long tiempoInicial2=System.currentTimeMillis();
		List<CompletableFuture<String>> listaRespuestas = new ArrayList<>();
		List <CuentaBancaria> lista2= new ArrayList<>();
		for(int i =1;i<=10;i++) {
			CuentaBancaria CUE3 = new CuentaBancaria();
			CUE3.setSaldo(new BigDecimal(500000));
			CUE3.setNumero(String.valueOf(i));
			CUE3.setTipo("Ahorros");
			lista2.add(CUE3);
			CompletableFuture<String> respuesta=this.bancariaService.agregarAsincrono2(CUE3);
			listaRespuestas.add(respuesta);
		}
		
		//sentencia que espera que termine de procesarce todos los hilos para obtener la respuesta 
		CompletableFuture.allOf(listaRespuestas.get(0),listaRespuestas.get(1),listaRespuestas.get(2),
				listaRespuestas.get(3),listaRespuestas.get(4),listaRespuestas.get(5),
				listaRespuestas.get(6),listaRespuestas.get(7),listaRespuestas.get(8),listaRespuestas.get(9));
		
		LOG.info("respuesta 0: "+ listaRespuestas.get(0).get()); //<< indica el nombre del hilo con el que se ejecuta el programa
		
		//fin
		long tiempoFinal2=System.currentTimeMillis();
		long tiempoTranscurrido2=(tiempoFinal2-tiempoInicial2)/1000;
		LOG.info("Tiempo transcurrido: "+(tiempoFinal2-tiempoInicial2));
		LOG.info("Tiempo transcurrido: "+tiempoTranscurrido2 );
		
		LOG.info("Se termino todo el proceso" );
	}
}
