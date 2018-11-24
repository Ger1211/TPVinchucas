package operadoresLogicos;

import java.util.List;


public abstract class OperadorLogico extends Filtro {
	
		protected List<Filtro> operadores;
		
		public OperadorLogico(List<Filtro> operadores) {
			this.operadores = operadores;
		}
		
		public List<Filtro> getOperadores() {
			return this.operadores;
		}
			
}
