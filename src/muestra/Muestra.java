package muestra;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ubicacion.Ubicacion;
import ubicacion.ZonaDeCobertura;
import usuario.Usuario;

public class Muestra {

	/*	a = Vinchuca;
	 *  b = Chinche Foliada
	 *  c = Phtia-Chinche
	 *  d = Ninguna
	 *  e = Imagen poco clara
	 *  
	 */

	private String tipoMuestra;
	private Ubicacion ubicacion;
	private Usuario usuario;
	private List<Verificacion> verificaciones;
	private NivelDeVerificacion nivelDeVerificacion;
	private List<ZonaDeCobertura> misZonasDeCobertura;
	
	public Muestra(String tipoMuestra, Ubicacion ubicacion, Usuario usuario, Verificacion verificacion) {
		// TODO Auto-generated constructor stub
		this.tipoMuestra = tipoMuestra;
		this.ubicacion = ubicacion;
		this.usuario = usuario;
		this.misZonasDeCobertura = new ArrayList<>();
		// Creacion y agregado de la verificacion base:
		this.setearNivelDeVerificacion(verificacion);
		this.verificaciones = new ArrayList<>();
		this.verificaciones.add(verificacion);
		
		
	}

	private void setearNivelDeVerificacion(Verificacion verificacion) {
		// TODO Auto-generated method stub
		if(verificacion.getUsuarioVerificacion().getTipoDeUsuario().esUsuarioBasico()) {
			this.nivelDeVerificacion =  new NivelDeVerificacionBajo();
		}
		else {
			this.nivelDeVerificacion = new NivelDeVerificacionAlto();
		}
		
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
		if(verificaciones.size()<3) {
		this.notificarAMisZonas(); 
		this.nivelDeVerificacion.actualizarNivelDeVerificacion(verificacion,this);
		this.verificaciones.add(verificacion);
		}
	}
	
	public Boolean usuarioNoVerifico(Usuario usuario) {
		// TODO Auto-generated method stub
		Boolean resultado = true;
		for(Verificacion verificacion: verificaciones) {
			resultado = resultado && !verificacion.getUsuarioVerificacion().equals(usuario);
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

	public Boolean estaVerificadaPorElUsuarioEnLosUltimosTreintaDias(Usuario usuario, Verificacion verificacion,
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

	public String verificar() {
		// TODO Auto-generated method stub
		// Verificar Usuarios Especialistas
		List<Verificacion> resultadoEspecialistas = this.verificaciones.stream().filter(verificacion -> verificacion.verificadorEsEspecialista()).collect(Collectors.toList());
		for(Verificacion verificacion1 : resultadoEspecialistas) {
			if(this.mayoriaVotos(verificacion1,resultadoEspecialistas)) {
				return verificacion1.getTipoMuestra();
			}
		}
		// Verificar Usuarios Expertos
		List<Verificacion> resultadoExpertos = this.verificaciones.stream().filter(verificacion -> verificacion.verificadorEsExperto()).collect(Collectors.toList());
		for(Verificacion verificacion2 : resultadoExpertos) {
			if(this.mayoriaVotos(verificacion2,resultadoExpertos)) {
				return verificacion2.getTipoMuestra();
			}
		}
		//Verificacion Usuarios Basicos
		for(Verificacion verificacion3 : this.verificaciones) {
			if(this.mayoriaVotos(verificacion3,this.verificaciones))  {
				return verificacion3.getTipoMuestra();
			}
		}
		
		return "Muestra no identificada";
}

	private Boolean mayoriaVotos(Verificacion verificacion, List<Verificacion> verificaciones) {
		// TODO Auto-generated method stub
		List<Verificacion> listaAFavor = verificaciones.stream().filter(verificacionMuestra -> verificacionMuestra.votoAFavor(verificacion)).collect(Collectors.toList());
		List<Verificacion> listaEnContra = verificaciones.stream().filter(verificacionMuestra -> verificacionMuestra.votoEnContra(verificacion)).collect(Collectors.toList());	
		return listaAFavor.size() > listaEnContra.size();
	}

	public void agregarMisZonasDeCobertura(List<ZonaDeCobertura> zonasDeCobertura) {
		// TODO Auto-generated method stub
		this.misZonasDeCobertura = zonasDeCobertura.stream().filter(zona -> zona.perteneceAZonaDeCobertura(this.ubicacion)).collect(Collectors.toList());
	}
	
	public void verificarYActualizarSiPertenezcoAZona(ZonaDeCobertura zonaDeCobertura) {
		if(zonaDeCobertura.perteneceAZonaDeCobertura(ubicacion)) {
			this.misZonasDeCobertura.add(zonaDeCobertura);
		}
	}

	public void notificarAMisZonas() {
		// TODO Auto-generated method stub
		this.misZonasDeCobertura.stream().forEach(zona-> zona.notificar(this));
	}

	public List<ZonaDeCobertura> getZonasDeCobertura() {
		// TODO Auto-generated method stub
		return this.misZonasDeCobertura;
	}

	public LocalDate getFechaCreacion() {
		// TODO Auto-generated method stub
		return this.verificaciones.get(0).getFechaVerificacion();
	}

	public LocalDate getFechaUltimaVerificacion() {
		// TODO Auto-generated method stub
		return this.verificaciones.get(this.verificaciones.size() -1).getFechaVerificacion();
	}







}
