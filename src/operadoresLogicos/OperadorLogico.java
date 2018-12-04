package operadoresLogicos;

public abstract class OperadorLogico extends Filtro {
	
		protected Filtro filtro1;
		protected Filtro filtro2;
		
		public OperadorLogico(Filtro filtro1,Filtro filtro2) {
			this.filtro1 = filtro1;
			this.filtro2 = filtro2;
		}
		
		public Filtro getFiltro1() {
			return this.filtro1;
		}
		
		public Filtro getFiltro2() {
			return this.filtro2;
		}
}
