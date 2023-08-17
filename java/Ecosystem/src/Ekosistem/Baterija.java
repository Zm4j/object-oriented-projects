package Ekosistem;

public class Baterija {

	public int kolicina;
	public int makskapacitet;
	
	public Baterija(int kol) {
		kolicina=kol;
		makskapacitet=kol;
	}
	
	public void dodajenergiju(int kol) {
		kolicina=Math.max(makskapacitet,kolicina+kol);
	}
	
	public void praznjenjebaterije() {
		kolicina=0;
	}
	
	public boolean provera() {
		return kolicina==makskapacitet;
	}
}
