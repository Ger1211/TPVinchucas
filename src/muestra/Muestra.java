package muestra;

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

	public Muestra(String tipoMuestra, Ubicacion ubicacion, Usuario usuario, Verificacion verificacion) {
		// TODO Auto-generated constructor stub
		this.tipoMuestra = tipoMuestra;
		this.ubicacion = ubicacion;
		this.usuario = usuario;
		
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

	public Boolean contiene(Verificacion verificacion) {
		// TODO Auto-generated method stub
		return this.verificaciones.contains(verificacion);
	}

	public void agregarVerificacion(Verificacion verificacion) {
		// TODO Auto-generated method stub
		this.verificaciones.add(verificacion);
	}

	public Boolean usuarioVerifico(Usuario usuario) {
		// TODO Auto-generated method stub
		Boolean resultado = false;
		for(Verificacion verificacion: verificaciones) {
			resultado = resultado || verificacion.getUsuarioVerificacion() == usuario;
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
}
