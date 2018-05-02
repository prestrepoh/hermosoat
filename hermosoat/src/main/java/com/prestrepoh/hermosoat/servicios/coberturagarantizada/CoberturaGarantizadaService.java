package com.prestrepoh.hermosoat.servicios.coberturagarantizada;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.prestrepoh.hermosoat.modelo.poliza.Poliza;
import com.prestrepoh.hermosoat.servicios.expedicion.ConsultasService;

@Service
public class CoberturaGarantizadaService {
	
	ConsultasService servicioConsultas;
	
	@Autowired
	public CoberturaGarantizadaService(ConsultasService servicioConsultas) {
		super();
		this.servicioConsultas = servicioConsultas;
	}

	public List<Poliza> obtenerPolizasValidasCoberturaGarantizada(@PathVariable("idTomador")String idTomador){
		List<Poliza> polizas = servicioConsultas.obtenerPolizasCliente(idTomador);
		polizas.removeIf(poliza -> !poliza.validaParaCoberturaGarantizada());
		return polizas;
	}
}


