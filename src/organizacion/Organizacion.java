package organizacion;

import muestra.Muestra;
import observer.Observador;
import ubicacion.ZonaDeCobertura;

public class Organizacion implements Observador,FuncionalidadExterna {

	private String tipo;
	private Integer nroEmpleados;

	public Organizacion(String tipo, Integer nroEmpleados) {
		// TODO Auto-generated constructor stub
		this.tipo = tipo;
		this.nroEmpleados = nroEmpleados;
	}

	public String getTipo() {
		// TODO Auto-generated method stub
		return this.tipo;
	}

	public Integer getNroEmpleados() {
		// TODO Auto-generated method stub
		return this.nroEmpleados;
	}

	@Override
	public void actualizar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void nuevoEvento(Organizacion organizacion, ZonaDeCobertura zonaDeCobertura, Muestra muestra) {
		// TODO Auto-generated method stub
		
	}

}
