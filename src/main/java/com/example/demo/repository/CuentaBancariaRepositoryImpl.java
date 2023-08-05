package com.example.demo.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.demo.repository.modelo.CuentaBancaria;
import com.example.demo.repository.modelo.Transferencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class CuentaBancariaRepositoryImpl implements CuentaBancariaRepository {
	private static final Logger LOG= LoggerFactory.getLogger(CuentaBancariaRepositoryImpl.class);

	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void agregarCuenta(CuentaBancaria ctaBancaria) {
		
		// TODO Auto-generated method stub
		LOG.info("hilo repository: "+ Thread.currentThread().getName()); //<< indica el nombre del hilo con el que se ejecuta el programa

		this.entityManager.persist(ctaBancaria);		
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void agregarTransferencia(Transferencia transferencia) {
		// TODO Auto-generated method stub
		this.entityManager.persist(transferencia);
		throw new RuntimeException();
	}
	
	@Override
	public List<CuentaBancaria> seleccionarTrasnferencias() {
		//>>>>>>>>>>>>>>>>>>>>AQUI <FETCH> ES DESPUES DEL JOIN NO ANTES<<<<<<<<<<<<<<<<<<<<<<<<<<<
		String jpql ="SELECT h FROM CuentaBancaria h INNER JOIN h.transferencias ha";
        TypedQuery <CuentaBancaria> myQuery  = this.entityManager.createQuery(jpql,CuentaBancaria.class);
        System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
        return myQuery.getResultList();   
        
	}
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void actualizarCuenta(CuentaBancaria ctaBancaria) {
		// TODO Auto-generated method stub
		this.entityManager.merge(ctaBancaria);		
	}

}
