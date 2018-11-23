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
		// TODO Auto-generated constructor stub
		this.tipo = tipo;
		this.nroEmpleados = nroEmpleados;
		this.funcionalidades = funcionalidades;
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
	public void actualizar(ZonaDeCobertura zonaDeCobertura,Muestra muestra) {
		// TODO Auto-generated method stub
		this.funcionalidades.stream().forEach(funcionalidad -> funcionalidad.nuevoEvento(this, zonaDeCobertura, muestra));
	}


}
