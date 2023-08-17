package banditi;

public class Bandit {
	
	// neki tip A,B???
	public enum Tim{A,B};
	private Tim tima;
	
	// kolicinazlatnika
	private int kolicinaZlatnika;
	
	// konstruktor sa tipom A,B i kolicinaZlatnika=50 default
	public Bandit(Tim a) {
		this.tima=a;
		this.kolicinaZlatnika = 50;
	}
	
	// getteri i setteri
	public Tim dohvatiTim() {
		return tima;
	}

	public void setTim(Tim tima) {
		this.tima = tima;
	}

	public int dohvatiBrojZlatnika() {
		return kolicinaZlatnika;
	}

	public void setKolicinaZlatnika(int kolicinaZlatnika) {
		this.kolicinaZlatnika = kolicinaZlatnika;
	}
	
	// metoda koja menja kolicinu zlatnika za n
	public void promeniBrojZlatnika(int n) {
		kolicinaZlatnika+=n;
	}
	
	// tostring metoda oblika: "[tip][kolicinaZlatnika]"
	public String toString() {
		return this.tima.name() + this.kolicinaZlatnika;
	}
	
	/*public static void main(String args[]) {
		Bandit b1 = new Bandit(Tim.A);
		Bandit b2 = new Bandit(Tim.B);
		b1.dodajkolicinu(20);
		System.out.println("Banditi su: " + b1 + ", " + b2 );
	}*/
}
