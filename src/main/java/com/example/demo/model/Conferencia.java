package com.example.demo.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@Table(name = "conferencias")
@ToString
// @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
// property = "id_conferencia")
public class Conferencia implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_conferencia;
	private String nombre;
	private Date Fecha_inicio;
	private Date Fecha_fin;
	private String descripcion;
	private String lugar;
	private String estado;

	@OneToMany(mappedBy = "conferencia", fetch = FetchType.LAZY)
	@JsonIgnore
	@ToString.Exclude
	private List<Topico> topicos;

	@OneToMany(mappedBy = "conferencia", fetch = FetchType.LAZY)
	@JsonIgnore
	@ToString.Exclude
	private List<Comite> comites;

	@OneToMany(mappedBy = "conferencia", fetch = FetchType.LAZY)
	@JsonIgnore
	@ToString.Exclude
	private List<Inscripcion> inscripciones;

	@OneToMany(mappedBy = "conferencia", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	@ToString.Exclude
	private List<Convocatoria> convocatorias;

	@OneToMany(mappedBy = "conferencia", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	@ToString.Exclude
	private List<Precio> precios;

	@OneToMany(mappedBy = "conferencia", fetch = FetchType.LAZY)
	@JsonIgnore
	@ToString.Exclude
	private List<Sesion> sesiones;

	@ManyToOne
	@JoinColumn(name = "id_chair")
	private Usuario chair;

	private String imagenUrl;

	/* @OneToOne
	@JoinColumn(name = "id_cuenta_bancaria")
	private CuentaBancaria cuentaBancaria; */

}
