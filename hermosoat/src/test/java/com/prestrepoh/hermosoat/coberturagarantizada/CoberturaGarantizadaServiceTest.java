package com.prestrepoh.hermosoat.coberturagarantizada;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.prestrepoh.hermosoat.modelo.poliza.Poliza;
import com.prestrepoh.hermosoat.modelo.poliza.PolizaSOAT;
import com.prestrepoh.hermosoat.servicios.coberturagarantizada.CoberturaGarantizadaService;
import com.prestrepoh.hermosoat.servicios.expedicion.ConsultasService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoberturaGarantizadaServiceTest {
	
	@Mock
	private ConsultasService servicioConsultasMock;
	
	@Mock
	private PolizaSOAT polizaMock;
	
	@InjectMocks
	private CoberturaGarantizadaService servicioCoberturaGarantizada;
	
	@Before
	public void inicializarMocks() {
		servicioConsultasMock = Mockito.mock(ConsultasService.class);
		polizaMock = Mockito.mock(PolizaSOAT.class);
		servicioCoberturaGarantizada = new CoberturaGarantizadaService(servicioConsultasMock);
	}
	
	@Test
	public void obtenerPolizasValidasCoberturaGarantizadaRetornaVacioClienteSinPolizas(){
		List<Poliza> listaVacia = new ArrayList<Poliza>();
		Mockito.when(servicioConsultasMock.obtenerPolizasCliente("1234")).thenReturn(listaVacia);
		
		List<Poliza> polizasValidas = servicioCoberturaGarantizada.obtenerPolizasValidasCoberturaGarantizada("1234");
		assertTrue(polizasValidas.isEmpty());
	}
	
	@Test
	public void obtenerPolizasValidasCoberturaGarantizadaRetornaVacioClienteSinPolizasValidas() {
		
		List<Poliza> listaPolizasNoValidas = new ArrayList<Poliza>();
		Mockito.when(polizaMock.validaParaCoberturaGarantizada()).thenReturn(false);
		listaPolizasNoValidas.add(polizaMock);
		
		Mockito.when(servicioConsultasMock.obtenerPolizasCliente("1234")).thenReturn(listaPolizasNoValidas);
		
		assertTrue(servicioCoberturaGarantizada.obtenerPolizasValidasCoberturaGarantizada("1234").isEmpty());
	}
	
	@Test
	public void obtenerPolizasValidasCoberturaGarantizadaDebeRetornarPolizasValidas() {
		List<Poliza> polizasCliente = new ArrayList<Poliza>();
		PolizaSOAT polizaValidaMock = Mockito.mock(PolizaSOAT.class);
		PolizaSOAT polizaNoValidaMock = Mockito.mock(PolizaSOAT.class);
		
		Mockito.when(polizaValidaMock.validaParaCoberturaGarantizada()).thenReturn(true);
		Mockito.when(polizaNoValidaMock.validaParaCoberturaGarantizada()).thenReturn(false);
		
		polizasCliente.add(polizaValidaMock);
		polizasCliente.add(polizaNoValidaMock);
		
		Mockito.when(servicioConsultasMock.obtenerPolizasCliente("1234")).thenReturn(polizasCliente);
		
		List<Poliza> polizasValidas = servicioCoberturaGarantizada.obtenerPolizasValidasCoberturaGarantizada("1234");
		assertEquals(1,polizasValidas.size());
	}
}
