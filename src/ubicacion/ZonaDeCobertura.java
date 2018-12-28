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
		this.nombreArea = nombreArea;
		this.epicentro = epicentro;
		this.radio = radio;
	}


	public String getNombreZona() {
		return this.nombreArea;
	}

	public Ubicacion getEpicentro() {
		return this.epicentro;
	}

	public Double getRadio() {
		return this.radio;
	}

	public Boolean perteneceAZonaDeCobertura(Ubicacion ubicacion) {
		return this.epicentro.ubicacionEstaAMenosDe(radio, ubicacion);
	}


	public Boolean seSolapaCon(ZonaDeCobertura zonaDeCobertura) {
		return (this.epicentro.distanciaHasta(zonaDeCobertura.getEpicentro())) <= (this.radio + zonaDeCobertura.getRadio()) ;
	}

	
	public List<Observador> getObservadores() {
		return this.observadores;
	}


	@Override
	public void notificar(Muestra muestra) {
		this.observadores.stream().forEach(observador -> observador.actualizar(this, muestra));
	}

}
