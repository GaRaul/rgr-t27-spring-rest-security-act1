package main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.dto.Pieza;
import main.service.PiezaServiceImpl;

@RestController
@RequestMapping("/api")
public class PiezaController{
	
	@Autowired
	PiezaServiceImpl piezaServiceImpl;
	
	@GetMapping("/piezas")
	public List<Pieza> listarPiezas() {

		return piezaServiceImpl.listarPiezas();
		
	}

	@PostMapping("/piezas")
	public Pieza guardarPieza(Pieza pieza) {

		return piezaServiceImpl.guardarPieza(pieza);
		
	}

	@GetMapping("/piezas/{id}")
	public Pieza piezaXID(Long codigo) {

		Pieza piezaXID = new Pieza();
		
		piezaXID = piezaServiceImpl.piezaXID(codigo);
		
		return piezaXID;
		
	}

	@PutMapping("/piezas/{id}")
	public Pieza actualizarPieza(@PathVariable(name="codigo")Long codigo, Pieza pieza) {

		Pieza pieza_seleccionado = new Pieza();
		Pieza pieza_actualizado = new Pieza();
		
		pieza_seleccionado = piezaServiceImpl.piezaXID(codigo);
		
		pieza_seleccionado.setNombre(pieza.getNombre());
		
		pieza_actualizado = piezaServiceImpl.actualizarPieza(pieza_seleccionado);
		
		return pieza_actualizado;
		
	}

	@DeleteMapping("/piezas/{id}")
	public void eliminarPieza(@PathVariable(name="codigo") Long codigo) {

		piezaServiceImpl.eliminarPieza(codigo);
		
	}
	
}