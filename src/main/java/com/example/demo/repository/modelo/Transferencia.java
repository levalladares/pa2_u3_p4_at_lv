package com.example.demo.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="transferencia")
public class Transferencia {
	@Id
    @GeneratedValue(generator = "seq_transferencia", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_transferencia",sequenceName = "seq_transferencia", allocationSize = 1 )
    @Column(name = "trans_id")
	private Integer id;
	@Column(name = "trans_fecha")
	private LocalDate fecha;
	@Column(name = "trans_monto")
	private BigDecimal monto;
	@ManyToOne
	@JoinColumn(name = "transferencia_id_ctaOrigen")
	private CuentaBancaria ctaOrigen;
	@ManyToOne
	@JoinColumn(name = "transferencia_id_ctaDestino")
	private CuentaBancaria ctaDestino;
	
	//GET Y SET
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public BigDecimal getMonto() {
		return monto;
	}
	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}
	public CuentaBancaria getCtaOrigen() {
		return ctaOrigen;
	}
	public void setCtaOrigen(CuentaBancaria ctaOrigen) {
		this.ctaOrigen = ctaOrigen;
	}
	public CuentaBancaria getCtaDestino() {
		return ctaDestino;
	}
	public void setCtaDestino(CuentaBancaria ctaDestino) {
		this.ctaDestino = ctaDestino;
	}

	
	
}
