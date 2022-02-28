package main.service;

import java.util.List;

import main.dto.Pieza;

public interface IPiezaService {
	
	public List<Pieza> listarPiezas();
	
	public Pieza guardarPieza(Pieza pieza);
	
	public Pieza piezaXID(Long codigo); 
	
	public Pieza actualizarPieza(Pieza pieza); 
	
	public void eliminarPieza(Long codigo);
	
}
