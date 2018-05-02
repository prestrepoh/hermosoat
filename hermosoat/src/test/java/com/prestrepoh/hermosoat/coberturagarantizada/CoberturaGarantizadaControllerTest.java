package com.prestrepoh.hermosoat.coberturagarantizada;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.prestrepoh.hermosoat.controladores.coberturagarantizada.CoberturaGarantizadaController;
import com.prestrepoh.hermosoat.modelo.poliza.Poliza;
import com.prestrepoh.hermosoat.servicios.coberturagarantizada.CoberturaGarantizadaService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoberturaGarantizadaControllerTest {
	
	@Mock
	private CoberturaGarantizadaService servicioCoberturaGarantizadaMock;
	
	@InjectMocks
	private CoberturaGarantizadaController coberturaGarantizadaController;
	
	@Before
	public void inicializarMocks() {
		servicioCoberturaGarantizadaMock = Mockito.mock(CoberturaGarantizadaService.class);
	}
	
	@Test
	public void obtenerPolizasValidasCoberturaGarantizadaDebeFallarSiFaltanParametros() {
		ResponseEntity<List<Poliza>> respuesta = 
				coberturaGarantizadaController.obtenerPolizasValidasCoberturaGarantizada("");
		
		assertTrue(respuesta.getStatusCode() != HttpStatus.ACCEPTED);
	}
	
	@Test
	public void obtenerPolizasValidasCoberturaGarantizadaDebeLlamarServicio() {
		coberturaGarantizadaController = new CoberturaGarantizadaController(servicioCoberturaGarantizadaMock);
		coberturaGarantizadaController.obtenerPolizasValidasCoberturaGarantizada("1234");
		Mockito.verify(servicioCoberturaGarantizadaMock).obtenerPolizasValidasCoberturaGarantizada("1234");
	}
}
