package com.prestrepoh.hermosoat.servicios.expedicion;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.prestrepoh.hermosoat.modelo.persona.GeneroEnum;
import com.prestrepoh.hermosoat.modelo.persona.Persona;
import com.prestrepoh.hermosoat.modelo.persona.PropietarioSOAT;
import com.prestrepoh.hermosoat.modelo.persona.TomadorSOAT;
import com.prestrepoh.hermosoat.modelo.poliza.Poliza;
import com.prestrepoh.hermosoat.modelo.poliza.PolizaSOAT;
import com.prestrepoh.hermosoat.modelo.vehiculo.Linea;
import com.prestrepoh.hermosoat.modelo.vehiculo.LineaSOAT;
import com.prestrepoh.hermosoat.modelo.vehiculo.Marca;
import com.prestrepoh.hermosoat.modelo.vehiculo.MarcaSOAT;
import com.prestrepoh.hermosoat.modelo.vehiculo.Vehiculo;
import com.prestrepoh.hermosoat.modelo.vehiculo.VehiculoSOAT;

@Service
public class ConsultasService {
	
	public List<Poliza> obtenerPolizasCliente(String id){
		
		ArrayList<Poliza> polizasCliente = new ArrayList<Poliza>();
		
		System.out.println("Accedo a la base de datos a consultar las pólizas del cliente");
		
		if(id.equals("1234")) {
			Linea linea1 = new LineaSOAT("Aveo", 2);
			Marca marca1 = new MarcaSOAT("Chevrolet", 3);
			Vehiculo vehiculo1 = new VehiculoSOAT(2010, marca1, linea1);
			LocalDate fechaNacimiento1 = LocalDate.of(1950, Month.DECEMBER, 12);
			Persona tomador1 = new TomadorSOAT(fechaNacimiento1 , GeneroEnum.MASCULINO,"1234");
			LocalDate fechaNacimiento2 = LocalDate.of(1950, Month.DECEMBER, 12);
			Persona propietario1 = new PropietarioSOAT(fechaNacimiento2, GeneroEnum.FEMENINO,"1234");
			Poliza poliza = new PolizaSOAT("123456",vehiculo1,tomador1,propietario1);
			
			polizasCliente.add(poliza); 
		}
		
		return polizasCliente;
	}
}
