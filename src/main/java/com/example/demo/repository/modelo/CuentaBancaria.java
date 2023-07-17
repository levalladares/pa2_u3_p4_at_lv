package com.example.demo.repository.modelo;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="cuentaBancaria")
public class CuentaBancaria {
	
	@Id
    @GeneratedValue(generator = "seq_cuentaBancaria", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_cuentaBancaria",sequenceName = "seq_cuentaBancaria", allocationSize = 1 )
    @Column(name = "ctaB_id")
	private Integer id;
	@Column(name = "ctaB_numero")
	private String numero;
	@Column(name = "ctaB_saldo")
	private BigDecimal saldo;
	@Column(name = "ctaB_tipo")
	private String tipo;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ctaB_id_propietario")
	private Propietario propietario;
	@OneToMany(mappedBy = "ctaOrigen",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Transferencia> transferenciasOrigen;
	@OneToMany(mappedBy = "ctaDestino",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Transferencia> transferenciasDestino;
	
	//GET Y SET
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public BigDecimal getSaldo() {
		return saldo;
	}
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Propietario getPropietario() {
		return propietario;
	}
	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}
	public List<Transferencia> getTransferenciasOrigen() {
		return transferenciasOrigen;
	}
	public void setTransferenciasOrigen(List<Transferencia> transferenciasOrigen) {
		this.transferenciasOrigen = transferenciasOrigen;
	}
	public List<Transferencia> getTransferenciasDestino() {
		return transferenciasDestino;
	}
	public void setTransferenciasDestino(List<Transferencia> transferenciasDestino) {
		this.transferenciasDestino = transferenciasDestino;
	}
	
	
	
	

}
