package com.prestrepoh.hermosoat.controladores.coberturagarantizada;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prestrepoh.hermosoat.modelo.poliza.Poliza;
import com.prestrepoh.hermosoat.servicios.coberturagarantizada.CoberturaGarantizadaService;

@RestController
@RequestMapping("/coberturaGarantizada")
public class CoberturaGarantizadaController {
	
	CoberturaGarantizadaService servicioCoberturaGarantizada;

	@Autowired
	public CoberturaGarantizadaController(CoberturaGarantizadaService servicioCoberturaGarantizada) {
		super();
		this.servicioCoberturaGarantizada = servicioCoberturaGarantizada;
	}

	@GetMapping("placasValidas/{idTomador}")
	public ResponseEntity<List<Poliza>> obtenerPolizasValidasCoberturaGarantizada(@PathVariable("idTomador")String idTomador) {
		try {
			
			if(parametrosFaltantes(idTomador)) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			
			return new ResponseEntity<>(servicioCoberturaGarantizada.obtenerPolizasValidasCoberturaGarantizada(idTomador),HttpStatus.ACCEPTED);
			
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	private boolean parametrosFaltantes(String idTomador) {
		return(idTomador.isEmpty() || idTomador == null);
	}
}
