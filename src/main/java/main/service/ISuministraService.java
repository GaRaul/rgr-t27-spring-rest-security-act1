package main.service;

import java.util.List;

import main.dto.Suministra;

public interface ISuministraService {
	
	public List<Suministra> listarSuministra();
	
	public Suministra guardarSuministra(Suministra suministra);
	
	public Suministra suministraXID(Long id); 
	
	public Suministra actualizarSuministra(Suministra suministra); 
	
	public void eliminarSuministra(Long id);
	
}
