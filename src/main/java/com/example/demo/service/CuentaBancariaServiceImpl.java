package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.management.RuntimeErrorException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.demo.Pa2U3P4AtLvApplication;
import com.example.demo.repository.CuentaBancariaRepository;
import com.example.demo.repository.modelo.CuentaBancaria;
import com.example.demo.repository.modelo.Transferencia;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;
@Service
public class CuentaBancariaServiceImpl implements CuentaBancariaService {
	private static final Logger LOG= LoggerFactory.getLogger(CuentaBancariaServiceImpl.class);

	@Autowired
	CuentaBancariaRepository bancariaRepository;
	
	@Autowired
	PruebaService pruebaService;
	@Override
	@Transactional
	public void guardarCuenta(CuentaBancaria ctaBancaria) {
		// TODO Auto-generated method stub
		LOG.info("hilo service: "+ Thread.currentThread().getName()); //<< indica el nombre del hilo con el que se ejecuta el programa
		//sumar, restar, multiplicar: logica que demora 1 segundo
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.bancariaRepository.agregarCuenta(ctaBancaria);
	}
	
	@Override
	public String guardarCuenta2(CuentaBancaria ctaBancaria) {
		LOG.info("hilo service: "+ Thread.currentThread().getName()); //<< indica el nombre del hilo con el que se ejecuta el programa
		//sumar, restar, multiplicar: logica que demora 1 segundo
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.bancariaRepository.agregarCuenta(ctaBancaria);
		return ctaBancaria.getNumero();
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void crearTransferencia(CuentaBancaria ctaOrigen, CuentaBancaria ctaDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		Transferencia trans = new Transferencia();
		trans.setCtaOrigen(ctaOrigen);
		trans.setCtaDestino(ctaDestino);
		trans.setFecha(LocalDate.now());
		trans.setMonto(monto);
		if(trans.getMonto().compareTo(ctaOrigen.getSaldo())==1) {
			System.out.println("EL SALDO ES INSUFICIENTE");
			
		}else {
			ctaOrigen.setSaldo(ctaOrigen.getSaldo().subtract(monto));
			ctaDestino.setSaldo(ctaDestino.getSaldo().add(monto));
			this.bancariaRepository.actualizarCuenta(ctaDestino);
			this.bancariaRepository.actualizarCuenta(ctaOrigen);
		}
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
		this.bancariaRepository.agregarTransferencia(trans);
		throw new RuntimeException();
	}

	@Override
	public List<CuentaBancaria> seleccionarTrasnferencias() {
		// TODO Auto-generated method stub
		return this.bancariaRepository.seleccionarTrasnferencias();
	}

	@Override
	@Transactional(value = TxType.NEVER)
	public void prueba() {
		// TODO Auto-generated method stub
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("metodo de prueba");
		
	}



}
