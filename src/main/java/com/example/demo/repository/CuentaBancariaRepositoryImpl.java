package com.example.demo.repository;

import java.awt.datatransfer.Transferable;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.demo.repository.modelo.CuentaBancaria;
import com.example.demo.repository.modelo.Hotel;
import com.example.demo.repository.modelo.Propietario;
import com.example.demo.repository.modelo.Transferencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class CuentaBancariaRepositoryImpl implements CuentaBancariaRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void agregarCuenta(CuentaBancaria ctaBancaria) {
		// TODO Auto-generated method stub
		this.entityManager.persist(ctaBancaria);
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
		
	}

	@Override
	public void agregarTransferencia(Transferencia transferencia) {
		// TODO Auto-generated method stub
		this.entityManager.persist(transferencia);
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
	}
	
	@Override
	public List<CuentaBancaria> seleccionarTrasnferencias() {
		//>>>>>>>>>>>>>>>>>>>>AQUI <FETCH> ES DESPUES DEL JOIN NO ANTES<<<<<<<<<<<<<<<<<<<<<<<<<<<
		String jpql ="SELECT h FROM CuentaBancaria h INNER JOIN h.transferencias ha";
        TypedQuery <CuentaBancaria> myQuery  = this.entityManager.createQuery(jpql,CuentaBancaria.class);
        System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
        return myQuery.getResultList();   
        
	}

}
