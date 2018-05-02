package com.prestrepoh.hermosoat.controladores.coberturagarantizada.dto;

import org.springframework.http.HttpStatus;

public class RespuestaServicioPOST extends RespuestaServicio{
	
	private int numeroRegistrosActualizados;

	public RespuestaServicioPOST(HttpStatus statusHttp, boolean operacionExitosa, int numeroRegistrosActualizados) {
		super(statusHttp, operacionExitosa);
		this.numeroRegistrosActualizados = numeroRegistrosActualizados;
	}

	public int getNumeroRegistrosActualizados() {
		return numeroRegistrosActualizados;
	}
}
