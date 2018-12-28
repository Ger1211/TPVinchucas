package organizacion;

import java.util.List;

import muestra.Muestra;
import observer.Observador;
import ubicacion.ZonaDeCobertura;

public class Organizacion implements Observador {

	private String tipo;
	private Integer nroEmpleados;
	private List<FuncionalidadExterna> funcionalidades;

	public Organizacion(String tipo, Integer nroEmpleados,List<FuncionalidadExterna> funcionalidades) {
		this.tipo = tipo;
		this.nroEmpleados = nroEmpleados;
		this.funcionalidades = funcionalidades;
	}

	public String getTipo() {
		return this.tipo;
	}

	public Integer getNroEmpleados() {
		return this.nroEmpleados;
	}

	@Override
	public void actualizar(ZonaDeCobertura zonaDeCobertura,Muestra muestra) {
		this.funcionalidades.stream().forEach(funcionalidad -> funcionalidad.nuevoEvento(this, zonaDeCobertura, muestra));
	}


}
