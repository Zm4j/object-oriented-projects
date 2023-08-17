package banditi;

public abstract class Akcija {
	
	Kompozicija k;
	
	public abstract void izvrsi(Bandit b);
	
	public Akcija(Kompozicija k) {
		this.k = k;
	}
	
}
