package com.prestrepoh.hermosoat.modelo.vehiculo;

import com.prestrepoh.hermosoat.modelo.base.Entidad;

public abstract class Linea extends Entidad {
	private String nombre;
	private int codigoRunt;
	
	public Linea(String nombre, int codigoRunt) {
		super();
		this.nombre = nombre;
		this.codigoRunt = codigoRunt;
	}

	public String getNombre() {
		return nombre;
	}

	public int getCodigoRunt() {
		return codigoRunt;
	}
}
