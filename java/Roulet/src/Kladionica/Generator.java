package Kladionica;

public class Generator {
	
	public int broj(int dole, int gore) {
		return (int) (Math.random() * (gore+1) + dole);
	}
	
}
