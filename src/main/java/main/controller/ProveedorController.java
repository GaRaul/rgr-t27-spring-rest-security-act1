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

import main.dto.Proveedor;
import main.service.ProveedorServiceImpl;

@RestController
@RequestMapping("/api")
public class ProveedorController{
	
	@Autowired
	ProveedorServiceImpl proveedorServiceImpl;
	
	@GetMapping("/proveedores")
	public List<Proveedor> listarProveedores() {

		return proveedorServiceImpl.listarProveedores();
		
	}

	@PostMapping("/proveedores")
	public Proveedor guardarProveedor(Proveedor proveedor) {

		return proveedorServiceImpl.guardarProveedor(proveedor);
		
	}

	@GetMapping("/proveedores/{id}")
	public Proveedor proveedorXID(Long codigo) {

		Proveedor proveedorXID = new Proveedor();
		
		proveedorXID = proveedorServiceImpl.proveedorXID(codigo);
		
		return proveedorXID;
		
	}

	@PutMapping("/proveedores/{id}")
	public Proveedor actualizarProveedor(@PathVariable(name="codigo")Long codigo, Proveedor proveedor) {

		Proveedor proveedor_seleccionado = new Proveedor();
		Proveedor proveedor_actualizado = new Proveedor();
		
		proveedor_seleccionado = proveedorServiceImpl.proveedorXID(codigo);
		
		proveedor_seleccionado.setNombre(proveedor.getNombre());
		
		proveedor_actualizado = proveedorServiceImpl.actualizarProveedor(proveedor_seleccionado);
		
		return proveedor_actualizado;
		
	}

	@DeleteMapping("/proveedores/{id}")
	public void eliminarProveedor(@PathVariable(name="codigo") Long codigo) {

		proveedorServiceImpl.eliminarProveedor(codigo);
		
	}
	
}