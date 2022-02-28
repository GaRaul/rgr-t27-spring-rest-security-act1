package main.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="suministra")
public class Suministra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int precio;
	
	@ManyToOne
	@JoinColumn(name="codigo_proveedor")
	private Proveedor proveedor;
	
	@ManyToOne
	@JoinColumn(name="codigo_pieza")
	private Pieza pieza;

	public Suministra() {
	}

	public Suministra(int precio, Proveedor proveedor, Pieza pieza) {
		this.precio = precio;
		this.proveedor = proveedor;
		this.pieza = pieza;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public Pieza getPieza() {
		return pieza;
	}

	public void setPieza(Pieza pieza) {
		this.pieza = pieza;
	}

	@Override
	public String toString() {
		return "Suministra [precio=" + precio + ", proveedor=" + proveedor + ", pieza=" + pieza + "]";
	}
	
}
