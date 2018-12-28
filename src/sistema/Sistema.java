package sistema;

import java.util.List;

import muestra.Muestra;
import ubicacion.ZonaDeCobertura;
import usuario.Usuario;

public class Sistema {
	private List<Muestra> muestras;
	private List<Usuario> usuarios; 
	private List<ZonaDeCobertura> zonasDeCobertura;
	
	public Sistema(List<Usuario>usuarios, List<Muestra> muestras,List<ZonaDeCobertura> zonasDeCobertura) {
		this.muestras = muestras;
		this.usuarios = usuarios;
		this.zonasDeCobertura = zonasDeCobertura;
	}

	public void enviarMuestraAlSistema(Muestra muestra) {
		muestra.agregarMisZonasDeCobertura(this.zonasDeCobertura);
		muestra.notificarAMisZonas();
		this.muestras.add(muestra);
	}

	public List<Muestra> getMuestras() {
		return this.muestras;
	}
	
	public void agregarZonaDeCobertura(ZonaDeCobertura zonaDeCobertura) {
		muestras.stream().forEach(muestra->muestra.verificarYActualizarSiPertenezcoAZona(zonaDeCobertura));
		this.zonasDeCobertura.add(zonaDeCobertura);
	}



}
