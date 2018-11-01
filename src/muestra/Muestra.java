package muestra;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ubicacion.Ubicacion;
import usuario.Usuario;

public class Muestra {

	/*	a = Vinchuca;
	 *  b = Chinche Foliada
	 *  c = Phtia-Chinche
	 *  d = Ninguna
	 *  e = Imagen poco clara
	 */

	private String tipoMuestra;
	private Ubicacion ubicacion;
	private Usuario usuario;
	private List<Verificacion> verificaciones;
	private NivelDeVerificacion nivelDeVerificacion;

	public Muestra(String tipoMuestra, Ubicacion ubicacion, Usuario usuario, Verificacion verificacion, NivelDeVerificacion nivelDeVerificacion) {
		// TODO Auto-generated constructor stub
		this.tipoMuestra = tipoMuestra;
		this.ubicacion = ubicacion;
		this.usuario = usuario;
		this.nivelDeVerificacion = nivelDeVerificacion;
		// Creacion y agregado de la verificacion base:
		
		this.verificaciones = new ArrayList<>();
		verificaciones.add(verificacion);
		
		
	}

	public String getTipoMuestra() {
		// TODO Auto-generated method stub
		return this.tipoMuestra;
	}

	public Ubicacion getUbicacion() {
		// TODO Auto-generated method stub
		return this.ubicacion;
	}

	public Usuario getUsuarioMuestra() {
		// TODO Auto-generated method stub
		return this.usuario;
	}

	public List<Verificacion> getVerificaciones() {
		return this.verificaciones;
	}
	
	public Boolean contiene(Verificacion verificacion) {
		// TODO Auto-generated method stub
		return this.verificaciones.contains(verificacion);
	}

	public void agregarVerificacion(Verificacion verificacion) {
		// TODO Auto-generated method stub
		this.nivelDeVerificacion.agregarVerificacion(verificacion, this);
	}

	public Boolean usuarioVerifico(Usuario usuario) {
		// TODO Auto-generated method stub
		Boolean resultado = false;
		for(Verificacion verificacion: verificaciones) {
			resultado = resultado || verificacion.getUsuarioVerificacion().equals(usuario);
		}
		return resultado;
	}

	public List<Muestra> muestrasAMenosDe(Double kilometros, List<Muestra> muestras) {
		// TODO Auto-generated method stub
		ArrayList<Muestra> resultado = new ArrayList<>();
		for(Muestra muestra : muestras) {
			if(this.getUbicacion().ubicacionEstaAMenosDe(kilometros, muestra.getUbicacion())) {
				resultado.add(muestra);
			}
		}
		return resultado;
	}


	public Boolean usuarioEnvioMuestra(Usuario usuario) {
		// TODO Auto-generated method stub
		return this.verificaciones.get(0).getUsuarioVerificacion() == usuario;
	}
	
	public Boolean usuarioVerificoEnElUltimoMes(Usuario usuario) {
		Boolean resultado = false;
		List<Verificacion> revisiones = this.verificaciones.subList(1, this.verificaciones.size());
		for(Verificacion verificacion : revisiones) {
			LocalDate fechaVerificacion = verificacion.getFechaVerificacion();
			resultado = resultado || estaVerificadaPorElUsuarioEnLosUltimosTreintaDias(usuario, verificacion, fechaVerificacion);
		}
		return resultado;
	}

	public boolean estaVerificadaPorElUsuarioEnLosUltimosTreintaDias(Usuario usuario, Verificacion verificacion,
			LocalDate fechaVerificacion) {
		return verificacion.getUsuarioVerificacion().equals(usuario) && usuario.getTipoDeUsuario().enElUltimomes(fechaVerificacion);
	}

	public NivelDeVerificacion getNivelDeVerificacion() {
		// TODO Auto-generated method stub
		return this.nivelDeVerificacion;
	}

	public void setNivelDeVerificacion(NivelDeVerificacion nivelDeVerificacion) {
		// TODO Auto-generated method stub
		this.nivelDeVerificacion = nivelDeVerificacion;
	}

}
