package skijanje;

public abstract class Deonica {
	
	double duzina;
	double nagib;
	char oznaka;
	double ubrzanje;
	
	// konstruktor za duzina i nagib
	
	public Deonica(double duzina, double nagib) {
		this.duzina = duzina;
		this.nagib = nagib;
	}
	
	// geteri za sva 4
	
	public double duzina() {
		return duzina;
	}

	public double nagib() {
		return nagib;
	}
	
	public abstract char oznaka();

	public abstract double ubrzanje();
	
	public double brzina(double Vp) {
		return Math.sqrt(2*ubrzanje*duzina+Vp*Vp);	
	}

	public double vreme(double Vp) {
		return (brzina(Vp)-Vp)/ubrzanje;
	}
	
	public String toString() {
		return oznaka() + "(" + duzina + "," + nagib + ")";
	}
	
}