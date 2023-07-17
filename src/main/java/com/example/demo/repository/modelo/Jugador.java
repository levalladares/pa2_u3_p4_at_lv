package com.example.demo.repository.modelo;

import java.math.BigDecimal;

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
@Table(name="jugador")
public class Jugador {
	@Id
    @GeneratedValue(generator = "seq_jugador", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_jugador",sequenceName = "seq_jugador", allocationSize = 1 )
    @Column(name = "juga_id")
	private Integer id;
	@Column(name = "juga_nombre")
	private String nombre;
	@Column(name = "juga_posicion")
	private String posicion; 
	@Column(name = "juga_salario")
	private BigDecimal salario;
	
	@ManyToOne
    @JoinColumn(name = "juga_id_equipo")
	private Equipo equipo;	
	
	@Override
	public String toString() {
		return "Jugador [id=" + id + ", nombre=" + nombre + ", posicion=" + posicion + ", salario=" + salario
				+ ", equipo=" + equipo + "]";
	}

	//get y set
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	
	
	

}
