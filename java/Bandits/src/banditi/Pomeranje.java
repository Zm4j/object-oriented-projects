package banditi;

public class Pomeranje extends Akcija {

	Smer smer1;
	
	public Pomeranje(Kompozicija k,Smer s1) {
		super(k);
		smer1=s1;
	}

	@Override
	public void izvrsi(Bandit b) {
		// TODO Auto-generated method stub
		
		try {
			Vagon vTren= k.dohvatiVagon(b); //trenutni vagon
			Vagon vNext = k.dohvatiSusedniVagon(vTren,smer1); //sledeci vagon
			
			vTren.ukloniBandita(b);
			vNext.dodajBandita(b);
			
		} catch (GNepostojeciVagon e) {
			return;
		}
		
	}
	
	@Override
	public String toString() {
		// TODO tvoja keva
		
		return "Pomeranje: " + smer1.name();
		
	}

}
