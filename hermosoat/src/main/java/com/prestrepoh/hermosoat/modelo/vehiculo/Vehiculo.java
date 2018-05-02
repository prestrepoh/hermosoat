package com.prestrepoh.hermosoat.modelo.vehiculo;

import com.prestrepoh.hermosoat.modelo.base.Entidad;

public abstract class Vehiculo extends Entidad {
	
	private int modelo;
	private Marca marca;
	private Linea linea;
	
	public Vehiculo(int modelo, Marca marca, Linea linea) {
		super();
		this.modelo = modelo;
		this.marca = marca;
		this.linea = linea;
	}

	public int getModelo() {
		return modelo;
	}

	public Marca getMarca() {
		return marca;
	}

	public Linea getLinea() {
		return linea;
	}
}
