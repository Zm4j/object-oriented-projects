package revija;

public class Velicina {

	public enum Oznaka {S, M, L};
	
	private Oznaka broj;

	public Oznaka dohvOznaku() {
		return broj;
	}

	public Velicina(Oznaka broj) {
		this.broj = broj;
	}
	
	public boolean manja(Velicina v) {
		if(this.broj==Oznaka.L) return false;
		if(this.broj==Oznaka.M && v.dohvOznaku()!=Oznaka.L) return false;
		if(this.broj==Oznaka.S && v.dohvOznaku()==Oznaka.S) return false;
		return true;
	}
	
	public String toString() {
		return broj.name();
	}
	
	/*public static void main(String args[]) {
		
		Velicina s = new Velicina(oznaka.S);
		Velicina m = new Velicina(oznaka.M);
		Velicina l = new Velicina(oznaka.L);
		
		System.out.println(s.manjaOd(s));
		System.out.println(s.manjaOd(m));
		System.out.println(s.manjaOd(l));
		System.out.println(m.manjaOd(s));
		System.out.println(m.manjaOd(m));
		System.out.println(m.manjaOd(l));
		System.out.println(l.manjaOd(s));
		System.out.println(l.manjaOd(m));
		System.out.println(l.manjaOd(l));
		
		System.out.println(s);
		System.out.println(m);
		System.out.println(l);
		
		
	}*/
	
}
