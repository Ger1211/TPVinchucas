package operadoresLogicos;

import java.util.List;

import muestra.Muestra;

public abstract class OperadorLogico extends Filtro {
	
		protected List<Filtro> operadores;
		
		public OperadorLogico(List<Filtro> operadores) {
			this.operadores = operadores;
		}
			
}
