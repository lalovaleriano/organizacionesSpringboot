/**
 * 
 */
package com.aplication.test.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Eduardo Valeriano
 *
 * 2 oct. 2019
 */

@Entity
@Table(name = "organizaciones")
public class Organizaciones implements Serializable {

	private static final long serialVersionUID = -2278274844502903157L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = true)
	private String nombre;
	
	@Column(nullable = true)
	private String direccion;
	
	@Column(nullable = true)
	private String telefono;
	
	@Column(nullable = true,unique = true)
	private Long idexterno;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Long getIdexterno() {
		return idexterno;
	}

	public void setIdexterno(Long idexterno) {
		this.idexterno = idexterno;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
