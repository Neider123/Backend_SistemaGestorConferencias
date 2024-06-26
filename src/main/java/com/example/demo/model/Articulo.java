package com.example.demo.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="articulos")
public class Articulo implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_articulo;
	private String url;
	private String estado;
	
	@ManyToOne
	@JoinColumn(name = "id_conferencia")
	private Conferencia conferencia;
	
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name= "id_autor")
	private Usuario autor;
	
	

}
