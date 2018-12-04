package ubicacion;


import java.util.List;

import muestra.Muestra;
import observer.Observado;
import observer.Observador;

public class ZonaDeCobertura extends Observado {
	
	private String nombreArea;
	private Ubicacion epicentro;
	private Double radio;
	
	public ZonaDeCobertura(String nombreArea, Ubicacion epicentro, Double radio) {
		// TODO Auto-generated constructor stub
		this.nombreArea = nombreArea;
		this.epicentro = epicentro;
		this.radio = radio;
	}


	public String getNombreZona() {
		// TODO Auto-generated method stub
		return this.nombreArea;
	}

	public Ubicacion getEpicentro() {
		// TODO Auto-generated method stub
		return this.epicentro;
	}

	public Double getRadio() {
		// TODO Auto-generated method stub
		return this.radio;
	}

	public Boolean perteneceAZonaDeCobertura(Ubicacion ubicacion) {
		// TODO Auto-generated method stub
		return this.epicentro.ubicacionEstaAMenosDe(radio, ubicacion);
	}


	public Boolean seSolapaCon(ZonaDeCobertura zonaDeCobertura) {
		// TODO Auto-generated method stub
		return (this.epicentro.distanciaHasta(zonaDeCobertura.getEpicentro())) <= (this.radio + zonaDeCobertura.getRadio()) ;
	}

	
	public List<Observador> getObservadores() {
		// TODO Auto-generated method stub
		return this.observadores;
	}


	@Override
	public void notificar(Muestra muestra) {
		// TODO Auto-generated method stub
		this.observadores.stream().forEach(observador -> observador.actualizar(this, muestra));
	}

}
