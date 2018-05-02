package com.prestrepoh.hermosoat.modelo.poliza;

import com.prestrepoh.hermosoat.modelo.base.Entidad;

public abstract class Poliza extends Entidad{
	private String numeroPoliza;
	
	public Poliza(String numeroPoliza) {
		super();
		this.numeroPoliza = numeroPoliza;
	}

	public String getNumeroPoliza() {
		return numeroPoliza;
	}
	
	public abstract boolean validaParaCoberturaGarantizada();
	
}
