package com.prestrepoh.hermosoat.modelo.base;

import org.springframework.stereotype.Repository;

@Repository
public abstract class Entidad {
	
	public void insert(Entidad entidad) {
	}
	
	public Entidad select(Entidad entidad) {
		return null;
	}
	
	public Entidad update(Entidad entidad) {
		return null;
	}
}