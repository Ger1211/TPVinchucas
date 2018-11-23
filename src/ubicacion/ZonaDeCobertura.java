package ubicacion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import muestra.Muestra;
import observer.Observado;
import observer.Observador;

public class ZonaDeCobertura implements Observado {
	
	private String nombreArea;
	private Ubicacion epicentro;
	private Double radio;
	private List<Muestra> muestrasEnElArea;
	private List<Observador> observadores;
	
	public ZonaDeCobertura(String nombreArea, Ubicacion epicentro, Double radio, List<Muestra> muestras) {
		// TODO Auto-generated constructor stub
		this.nombreArea = nombreArea;
		this.epicentro = epicentro;
		this.radio = radio;
		this.muestrasEnElArea = this.filtrarMuestrasPorArea(muestras);
		this.observadores = new ArrayList<>();
	}

	private List<Muestra> filtrarMuestrasPorArea(List<Muestra> muestras) {
		// TODO Auto-generated method stub
		return muestras.stream().filter( muestra -> this.perteneceAZonaDeCobertura(muestra.getUbicacion())).collect(Collectors.toList());
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

	public List<Muestra> getMuestrasEnElArea() {
		// TODO Auto-generated method stub
		return this.muestrasEnElArea;
	}

	public Boolean seSolapaCon(ZonaDeCobertura zonaDeCobertura) {
		// TODO Auto-generated method stub
		return (this.epicentro.distanciaHasta(zonaDeCobertura.getEpicentro())) <= (this.radio + zonaDeCobertura.getRadio()) ;
	}

	@Override
	public void agregarObservador(Observador observador) {
		// TODO Auto-generated method stub
		this.observadores.add(observador);
	}

	@Override
	public void eliminarObservador(Observador observador) {
		// TODO Auto-generated method stub
		this.observadores.remove(observador);
	}

	@Override
	public void notificar() {
		// TODO Auto-generated method stub
		
	}

}
