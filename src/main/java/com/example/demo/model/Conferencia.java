package com.example.demo.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="conferencias")
public class Conferencia implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id_conferencia;
	String nombre;
	Date Fecha_inicio;
	Date Fecha_fin;
	String descripcion;
	String lugar;
	
	@OneToMany
	private List<Articulo> articulos;

}
