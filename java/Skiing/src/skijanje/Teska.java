package skijanje;

public class Teska extends Deonica {

	public Teska(double duzina, double nagib) {
		super(duzina, nagib);
		// TODO tvoja keva
		oznaka = 'T';
		ubrzanje=9.81*Math.sin(nagib*Math.PI/180);
	}
	
	public char oznaka() {
		return oznaka;
	}

	public double ubrzanje() {
		return ubrzanje;
	}
	
}
