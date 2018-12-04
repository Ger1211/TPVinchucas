package usuario;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import muestra.Muestra;
import muestra.Verificacion;

public abstract class TipoDeUsuario {
	
	public abstract Boolean esUsuarioBasico();
	public abstract Boolean esUsuarioExperto();
	public abstract Boolean esUsuarioEspecialista();
	


	public Integer cantidadDeEnvios(Usuario usuario, List<Muestra> muestras) {
		// TODO Auto-generated method stub
		Integer resultado = 0;
			for(Muestra muestra : muestras) {
				Verificacion verificacionEnvio = muestra.getVerificaciones().get(0);
				LocalDate fechaVerificacion = verificacionEnvio.getFechaVerificacion();
				if(this.usuarioEnvioMuestra(usuario,muestra) && this.enElUltimomes(fechaVerificacion)) {
					resultado += 1;
				}
			}
	
		return resultado;
	}

	public Boolean enElUltimomes(LocalDate fechaVerificacion) {
		// TODO Auto-generated method stub
		LocalDate hoy = LocalDate.now();
		Period periodo = Period.between(hoy, fechaVerificacion);
		return periodo.getMonths()<31;
	}

	private Boolean usuarioEnvioMuestra(Usuario usuario, Muestra muestra) {
		// TODO Auto-generated method stub
		return muestra.usuarioEnvioMuestra(usuario);
	}

	public Integer cantidadDeRevisiones(Usuario usuario, List<Muestra> muestras) {
		// TODO Auto-generated method stub
		Integer resultado = 0;
		for(Muestra muestra : muestras) {
			if(this.usuarioVerificoMuestraEnElUltimoMes(usuario,muestra)) {
				resultado += 1;
			}
		}

	return resultado;
}
	
	private Boolean usuarioVerificoMuestraEnElUltimoMes(Usuario usuario,Muestra muestra) {
		return muestra.usuarioVerificoEnElUltimoMes(usuario);
	}

	public abstract void ascenderUsuario(Usuario usuario);

	public abstract void descenderUsuario(Usuario usuario);

	public void verificacionAscensoODescensoDeRango(Usuario usuario,List<Muestra> muestras) {
		
			if(usuario.verificacionEnvios(muestras) && usuario.verificacionRevisiones(muestras)) {
				this.ascenderUsuario(usuario);
			}
			else {
				this.descenderUsuario(usuario);
			}
	}



}
