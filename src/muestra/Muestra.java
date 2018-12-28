package muestra;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ubicacion.Ubicacion;
import ubicacion.ZonaDeCobertura;
import usuario.Usuario;

public class Muestra {
	
	private String tipoMuestra;
	private Ubicacion ubicacion;
	private Usuario usuario;
	private List<Verificacion> verificaciones;
	private NivelDeVerificacion nivelDeVerificacion;
	private List<ZonaDeCobertura> misZonasDeCobertura;
	
	public Muestra(String tipoMuestra, Ubicacion ubicacion, Usuario usuario, Verificacion verificacion) {
		this.tipoMuestra = tipoMuestra;
		this.ubicacion = ubicacion;
		this.usuario = usuario;
		this.misZonasDeCobertura = new ArrayList<>();
		
		this.setearELNivelDeLaVerificacionInicial(verificacion);
		this.verificaciones = new ArrayList<>();
		this.verificaciones.add(verificacion);
		
		
	}

	private void setearELNivelDeLaVerificacionInicial(Verificacion verificacion) {
		if(esVerificacionHechaPorUnUsuarioBasico(verificacion)) {
			this.nivelDeVerificacion =  new NivelDeVerificacionBajo();
		}
		else {
			this.nivelDeVerificacion = new NivelDeVerificacionAlto();
		}
		
	}

	private Boolean esVerificacionHechaPorUnUsuarioBasico(Verificacion verificacion) {
		return verificacion.getUsuarioVerificacion().getTipoDeUsuario().esUsuarioBasico();
	}

	public String getTipoMuestra() {
		return this.tipoMuestra;
	}

	public Ubicacion getUbicacion() {
		return this.ubicacion;
	}

	public Usuario getUsuarioMuestra() {
		return this.usuario;
	}

	public List<Verificacion> getVerificaciones() {
		return this.verificaciones;
	}
	
	public Boolean contiene(Verificacion verificacion) {
		return this.verificaciones.contains(verificacion);
	}

	public void agregarVerificacion(Verificacion verificacion) {
		if(esMaximaCantidadDeVerificaciones()) {
		this.notificarAMisZonas(); 
		this.nivelDeVerificacion.actualizarNivelDeVerificacion(verificacion,this);
		this.verificaciones.add(verificacion);
		}
	}

	private boolean esMaximaCantidadDeVerificaciones() {
		return verificaciones.size()<3;
	}
	
	public Boolean usuarioNoVerifico(Usuario usuario) {
		Boolean resultado = true;
		for(Verificacion verificacion: verificaciones) {
			resultado = resultado && usuarioNoEsElVerificadorInicialDeLaMuestra(usuario, verificacion);
		}
		return resultado;
	}

	private boolean usuarioNoEsElVerificadorInicialDeLaMuestra(Usuario usuario, Verificacion verificacion) {
		return !verificacion.getUsuarioVerificacion().equals(usuario);
	}

	public List<Muestra> muestrasAMenosDe(Double kilometros, List<Muestra> muestras) {
		ArrayList<Muestra> resultado = new ArrayList<>();
		for(Muestra muestra : muestras) {
			if(miUbicacionActualEstaAMenosKilometrosDeLaUbicacionDeLaMuestra(kilometros, muestra)) {
				resultado.add(muestra);
			}
		}
		return resultado;
	}

	private Boolean miUbicacionActualEstaAMenosKilometrosDeLaUbicacionDeLaMuestra(Double kilometros, Muestra muestra) {
		return this.getUbicacion().ubicacionEstaAMenosDe(kilometros, muestra.getUbicacion());
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
		return this.nivelDeVerificacion;
	}

	public void setNivelDeVerificacion(NivelDeVerificacion nivelDeVerificacion) {
		this.nivelDeVerificacion = nivelDeVerificacion;
	}

	public String verificar() {
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
		List<Verificacion> listaAFavor = verificaciones.stream().filter(verificacionMuestra -> verificacionMuestra.votoAFavor(verificacion)).collect(Collectors.toList());
		List<Verificacion> listaEnContra = verificaciones.stream().filter(verificacionMuestra -> verificacionMuestra.votoEnContra(verificacion)).collect(Collectors.toList());	
		return listaAFavor.size() > listaEnContra.size();
	}

	public void agregarMisZonasDeCobertura(List<ZonaDeCobertura> zonasDeCobertura) {
		this.misZonasDeCobertura = zonasDeCobertura.stream().filter(zona -> zona.perteneceAZonaDeCobertura(this.ubicacion)).collect(Collectors.toList());
	}
	
	public void verificarYActualizarSiPertenezcoAZona(ZonaDeCobertura zonaDeCobertura) {
		if(zonaDeCobertura.perteneceAZonaDeCobertura(ubicacion)) {
			this.misZonasDeCobertura.add(zonaDeCobertura);
		}
	}

	public void notificarAMisZonas() {
		this.misZonasDeCobertura.stream().forEach(zona-> zona.notificar(this));
	}

	public List<ZonaDeCobertura> getZonasDeCobertura() {
		return this.misZonasDeCobertura;
	}

	public LocalDate getFechaCreacion() {
		// TODO Auto-generated method stub
		return this.verificaciones.get(0).getFechaVerificacion();
	}

	public LocalDate getFechaUltimaVerificacion() {
		return this.verificaciones.get(this.verificaciones.size() -1).getFechaVerificacion();
	}







}
