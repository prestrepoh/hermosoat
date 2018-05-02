package com.prestrepoh.hermosoat.modelo.persona;

import java.time.LocalDate;

public class TomadorSOAT extends Persona{

	public TomadorSOAT(LocalDate fechaNacimiento, GeneroEnum genero, String id) {
		super(fechaNacimiento, genero, id);
	}

	@Override
	public boolean siniestrosEnElUltimoAnio() {
		System.out.println("Accedo a la base de datos para buscar si el cliente tiene siniestros");
		return false;
	}
}
