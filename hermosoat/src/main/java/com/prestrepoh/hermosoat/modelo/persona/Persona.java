package com.prestrepoh.hermosoat.modelo.persona;

import java.time.LocalDate;

import com.prestrepoh.hermosoat.modelo.base.Entidad;

public abstract class Persona extends Entidad {
	
	private LocalDate fechaNacimiento;
	private GeneroEnum genero;
	private String id;
	
	public Persona(LocalDate fechaNacimiento, GeneroEnum genero, String id) {
		super();
		this.fechaNacimiento = fechaNacimiento;
		this.genero = genero;
		this.id = id;
	}
	
	public abstract boolean siniestrosEnElUltimoAnio();

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public GeneroEnum getGenero() {
		return genero;
	}

	public String getId() {
		return id;
	}
}
