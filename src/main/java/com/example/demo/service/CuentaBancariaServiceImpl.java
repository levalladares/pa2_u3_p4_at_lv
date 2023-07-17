package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.CuentaBancariaRepository;
import com.example.demo.repository.modelo.CuentaBancaria;
import com.example.demo.repository.modelo.Transferencia;
@Service
public class CuentaBancariaServiceImpl implements CuentaBancariaService {
	@Autowired
	CuentaBancariaRepository bancariaRepository;
	@Override
	public void guardarCuenta(CuentaBancaria ctaBancaria) {
		// TODO Auto-generated method stub
		this.bancariaRepository.agregarCuenta(ctaBancaria);
		
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
		this.bancariaRepository.agregarTransferencia(trans);	
	}

	@Override
	public List<CuentaBancaria> seleccionarTrasnferencias() {
		// TODO Auto-generated method stub
		return this.bancariaRepository.seleccionarTrasnferencias();
	}

}
