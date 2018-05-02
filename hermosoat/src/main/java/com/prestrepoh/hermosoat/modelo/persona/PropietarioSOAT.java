package com.prestrepoh.hermosoat.modelo.persona;

import java.time.LocalDate;

public class PropietarioSOAT extends Persona{

	public PropietarioSOAT(LocalDate fechaNacimiento, GeneroEnum genero, String id) {
		super(fechaNacimiento, genero, id);
	}

	@Override
	public boolean siniestrosEnElUltimoAnio() {
		return false;
	}

}
