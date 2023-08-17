package Ekosistem;

import java.awt.Color;

public class Hidroelektrana extends Proizvodjac {

	private int brojpolja=0;
	
	public Hidroelektrana(Baterija baterija) {
		super('H', Color.BLUE, baterija, 1500);
	}

	public void setBrojpolja(int a) {
		brojpolja=a;
	}
	
	@Override
	protected synchronized boolean nesto1() {
		baterija.dodajenergiju(brojpolja);
		return brojpolja!=0;
	}

}
