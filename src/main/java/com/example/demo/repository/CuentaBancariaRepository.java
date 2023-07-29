package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.CuentaBancaria;
import com.example.demo.repository.modelo.Transferencia;

public interface CuentaBancariaRepository {
	
	public void agregarCuenta (CuentaBancaria ctaBancaria );
	public void agregarTransferencia (Transferencia transferencia);
	public List<CuentaBancaria> seleccionarTrasnferencias();
	public void actualizarCuenta(CuentaBancaria ctaBancaria);
}
