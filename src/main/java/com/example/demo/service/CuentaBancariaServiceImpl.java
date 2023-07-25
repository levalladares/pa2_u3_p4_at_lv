package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.demo.repository.CuentaBancariaRepository;
import com.example.demo.repository.modelo.CuentaBancaria;
import com.example.demo.repository.modelo.Transferencia;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;
@Service
public class CuentaBancariaServiceImpl implements CuentaBancariaService {
	@Autowired
	CuentaBancariaRepository bancariaRepository;
	
	@Autowired
	PruebaService pruebaService;
	@Override
	@Transactional
	public void guardarCuenta(CuentaBancaria ctaBancaria) {
		// TODO Auto-generated method stub
		//this.bancariaRepository.agregarCuenta(ctaBancaria);
		System.out.println("service: "+TransactionSynchronizationManager.isActualTransactionActive());
//		this.pruebaService.prueba();
//		this.pruebaService.prueba2();
//		this.pruebaService.pruebaSupports();
//		this.pruebaService.pruebaNotSupports();
//		this.pruebaService.pruebaRequired();
		this.pruebaService.pruebaRequiresNew();
	}

	@Override
	public void crearTransferencia(CuentaBancaria ctaOrigen, CuentaBancaria ctaDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		Transferencia trans = new Transferencia();
		trans.setCtaOrigen(ctaOrigen);
		trans.setCtaDestino(ctaDestino);
		trans.setFecha(LocalDate.now());
		trans.setMonto(monto);
		if(trans.getMonto().compareTo(ctaOrigen.getSaldo())==-1) {
			System.out.println("EL SALDO ES INSUFICIENTE");
			
		}else {
			ctaOrigen.getSaldo().subtract(monto);
			ctaDestino.getSaldo().add(monto);
		}
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
		this.bancariaRepository.agregarTransferencia(trans);	
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
