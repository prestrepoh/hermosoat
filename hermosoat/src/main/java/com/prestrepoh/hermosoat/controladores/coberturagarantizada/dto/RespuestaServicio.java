package com.prestrepoh.hermosoat.controladores.coberturagarantizada.dto;

import org.springframework.http.HttpStatus;

public abstract class RespuestaServicio {
	private HttpStatus statusHttp;
	private boolean operacionExitosa;
	
	public RespuestaServicio(HttpStatus statusHttp, boolean operacionExitosa) {
		super();
		this.statusHttp = statusHttp;
		this.operacionExitosa = operacionExitosa;
	}

	public HttpStatus getStatusHttp() {
		return statusHttp;
	}

	public boolean isOperacionExitosa() {
		return operacionExitosa;
	}
}
