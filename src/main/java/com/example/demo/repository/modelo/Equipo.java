package com.example.demo.repository.modelo;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="equipo")
public class Equipo {
	
	@Id
    @GeneratedValue(generator = "seq_equipo", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_equipo",sequenceName = "seq_equipo", allocationSize = 1 )
    @Column(name = "equi_id")
	private Integer id;
	@Column(name = "equi_nombre")
	private String nombre;
	@Column(name = "equi_ciudad")
	private String ciudad;
	@Column(name = "equi_fechaCreacion")
	private LocalDate fechaCreacion;
	@OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Jugador> jugadores;
	
	
	
	@Override
	public String toString() {
		return "Equipo [id=" + id + ", nombre=" + nombre + ", ciudad=" + ciudad + ", fechaCreacion=" + fechaCreacion
				+ "]";
	}
	//GET Y SET 
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
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public List<Jugador> getJugadores() {
		return jugadores;
	}
	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
	
	
	
}
