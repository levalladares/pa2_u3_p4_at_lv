package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.repository.modelo.CuentaBancaria;
import com.example.demo.repository.modelo.Transferencia;

public interface CuentaBancariaService {
	public void guardarCuenta (CuentaBancaria ctaBancaria );
	public String guardarCuenta2 (CuentaBancaria ctaBancaria );
	public void crearTransferencia (CuentaBancaria ctaOrigen, CuentaBancaria ctaDestino, BigDecimal monto);
	public List<CuentaBancaria> seleccionarTrasnferencias(); 
	public void prueba();
}
