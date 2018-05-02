package com.prestrepoh.hermosoat.modelo;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.prestrepoh.hermosoat.modelo.persona.GeneroEnum;
import com.prestrepoh.hermosoat.modelo.persona.PropietarioSOAT;
import com.prestrepoh.hermosoat.modelo.persona.TomadorSOAT;
import com.prestrepoh.hermosoat.modelo.poliza.PolizaSOAT;
import com.prestrepoh.hermosoat.modelo.vehiculo.MarcaSOAT;
import com.prestrepoh.hermosoat.modelo.vehiculo.VehiculoSOAT;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PolizaSOATTest {
	
	@Mock
	TomadorSOAT tomadorMock;
	
	@Mock
	PropietarioSOAT propietarioMock;
	
	@Mock
	VehiculoSOAT vehiculoMock;
	
	@Mock
	MarcaSOAT marcaMock; 
	
	private PolizaSOAT poliza;
	
	@Before
	public void inicializarMocks() {
		tomadorMock = Mockito.mock(TomadorSOAT.class);
		propietarioMock = Mockito.mock(PropietarioSOAT.class);
		vehiculoMock = Mockito.mock(VehiculoSOAT.class);
		marcaMock = Mockito.mock(MarcaSOAT.class);
		poliza = new PolizaSOAT("1234", vehiculoMock, tomadorMock, propietarioMock);
	}
	
	@Test
	public void polizaNoDebeSerValidaParaCoberturaGarantizadaSiTomadorTieneSiniestros(){
		Mockito.when(tomadorMock.siniestrosEnElUltimoAnio()).thenReturn(true);
		assertFalse(poliza.validaParaCoberturaGarantizada());
	}
	
	@Test
	public void polizaNoDebeSerValidaParaCoberturaGarantizadaSiVehiculoEsAKT(){
		Mockito.when(vehiculoMock.getMarca()).thenReturn(marcaMock);
		Mockito.when(marcaMock.getNombreMarca()).thenReturn("AKT");
		assertFalse(poliza.validaParaCoberturaGarantizada());
	}
	
	@Test
	public void polizaDebeSerValidaParaCoberturaGarantizadaSiVehiculoCumpleCondiciones(){
		Mockito.when(vehiculoMock.getMarca()).thenReturn(marcaMock);
		Mockito.when(marcaMock.getNombreMarca()).thenReturn("Chevrolet");
		
		Mockito.when(tomadorMock.siniestrosEnElUltimoAnio()).thenReturn(false);
		
		assertTrue(poliza.validaParaCoberturaGarantizada());
	}
}
