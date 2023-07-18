package com.example.demo.repository.modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "semestre")
@Entity
public class Semestre {
	@Id
	@GeneratedValue(generator = "seq_semestre", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_semestre", sequenceName = "seq_semestre", allocationSize = 1)
	@Column(name = "seme_id")
	private Integer id;
	@Column(name = "seme_nSemestre")
	private String nSemestre;
	@Column(name = "seme_anio")
	private String anio;
	@Column(name = "seme_modalidad")
	private String modalidad;
	@OneToMany(mappedBy = "semestre")
	private List<Materia> listaM;
	
	//GET Y SET
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getnSemestre() {
		return nSemestre;
	}
	public void setnSemestre(String nSemestre) {
		this.nSemestre = nSemestre;
	}
	public String getAnio() {
		return anio;
	}
	public void setAnio(String anio) {
		this.anio = anio;
	}
	public String getModalidad() {
		return modalidad;
	}
	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}
	public List<Materia> getListaM() {
		return listaM;
	}
	public void setListaM(List<Materia> listaM) {
		this.listaM = listaM;
	}
	
	
}
