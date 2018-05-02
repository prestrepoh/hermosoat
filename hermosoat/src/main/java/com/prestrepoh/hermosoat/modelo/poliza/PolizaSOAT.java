package com.prestrepoh.hermosoat.modelo.poliza;

import com.prestrepoh.hermosoat.modelo.persona.Persona;
import com.prestrepoh.hermosoat.modelo.vehiculo.Vehiculo;

public class PolizaSOAT extends Poliza {
	
	private Vehiculo vehiculo;
	private Persona tomador;
	private Persona propietario;
	
	public PolizaSOAT(String numeroPoliza, Vehiculo vehiculo, Persona tomador, Persona propietario) {
		super(numeroPoliza);
		this.vehiculo = vehiculo;
		this.tomador = tomador;
		this.propietario = propietario;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public Persona getTomador() {
		return tomador;
	}

	public Persona getPropietario() {
		return propietario;
	}

	@Override
	public boolean validaParaCoberturaGarantizada() {
		
		if(tomador.siniestrosEnElUltimoAnio()) {
			return false;
		}
		
		if(vehiculo.getMarca().getNombreMarca().equals("AKT")) {
			return false;
		}
		
		return true;
	}
}
