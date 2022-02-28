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

import main.dto.Suministra;
import main.service.SuministraServiceImpl;

@RestController
@RequestMapping("/api")
public class SuministraController{
	
	@Autowired
	SuministraServiceImpl suministraServiceImpl;
	
	@GetMapping("/suministras")
	public List<Suministra> listarSuministra() {

		return suministraServiceImpl.listarSuministra();
		
	}

	@PostMapping("/suministras")
	public Suministra guardarSuministra(Suministra suministra) {

		return suministraServiceImpl.guardarSuministra(suministra);
		
	}

	@GetMapping("/suministras/{id}")
	public Suministra suministraXID(Long id) {

		Suministra suministraXID = new Suministra();
		
		suministraXID = suministraServiceImpl.suministraXID(id);
		
		return suministraXID;
		
	}

	@PutMapping("/suministras/{id}")
	public Suministra actualizarSuministra(@PathVariable(name="id")Long id, Suministra suministra) {

		Suministra suministra_seleccionado = new Suministra();
		Suministra suministra_actualizado = new Suministra();
		
		suministra_seleccionado = suministraServiceImpl.suministraXID(id);
		
		suministra_seleccionado.setPieza(suministra.getPieza());
		suministra_seleccionado.setPrecio(suministra.getPrecio());
		suministra_seleccionado.setProveedor(suministra.getProveedor());
		
		suministra_actualizado = suministraServiceImpl.actualizarSuministra(suministra_seleccionado);
		
		return suministra_actualizado;
		
	}

	@DeleteMapping("/suministras/{id}")
	public void eliminarSuministra(@PathVariable(name="id") Long id) {

		suministraServiceImpl.eliminarSuministra(id);
		
	}
	
}
