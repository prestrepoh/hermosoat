package com.prestrepoh.hermosoat.modelo.vehiculo;

import com.prestrepoh.hermosoat.modelo.base.Entidad;

public abstract class Marca extends Entidad {
	private String nombre;
	private int codigoRunt;
	
	public Marca(String nombreMarca, int codigoRunt) {
		super();
		this.nombre = nombreMarca;
		this.codigoRunt = codigoRunt;
	}

	public String getNombreMarca() {
		return nombre;
	}

	public int getCodigoRunt() {
		return codigoRunt;
	}
}
