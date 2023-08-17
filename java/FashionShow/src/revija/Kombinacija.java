package revija;

public class Kombinacija {
	
	private int kap;
	private int tren;
	private Nosivo[] niz;
	
	public Kombinacija(int kap) {
		this.kap = kap;
		niz = new Nosivo[kap];
		tren=0;
	}
	
	public void dodaj(Nosivo n) throws GDodavanje {
		
		if(tren>=kap) {
			throw new GDodavanje();
		}
		else {
			niz[tren++]=n;
		}
	}
	
	public int dohvBrStvari() {
		return tren;
	}
	
	public int dohvMaxBrStvari() {
		return kap;
	}
	
	public Nosivo dohvStvar(int ind) throws GIndeks {
		if(ind < 0 || ind >= tren) throw new GIndeks();
		
		return niz[ind];		
	}
	
	public String toString() {
		
		StringBuilder sb= new StringBuilder();
		sb.append('[');
		for(int i=0;i<tren;i++) {
			if(i>0) sb.append(", ");
			sb.append(niz[i]);
		}
		sb.append(']');
		
		return sb.toString();
	}
	
	/*public static void main(String args[]) {
		
		Kombinacija k = new Kombinacija(5);
		Odeca o1 = new Odeca("odelo1", new Velicina(Velicina.oznaka.L));
		Odeca o2 = new Odeca("odelo2", new Velicina(Velicina.oznaka.M));
		Odeca o3 = new Odeca("odelo3", new Velicina(Velicina.oznaka.S));
		Odeca o4 = new Odeca("odelo4", new Velicina(Velicina.oznaka.M));
		Odeca o5 = new Odeca("odelo5", new Velicina(Velicina.oznaka.L));
		Odeca o6 = new Odeca("odelo6", new Velicina(Velicina.oznaka.L));

		try {
			k.dodajNosivo(o1);
			k.dodajNosivo(o5);
			k.dodajNosivo(o6);
			
			System.out.println(k.maksBrojStvari());
			System.out.println(k.brojStvari());
			try {
				System.out.println(k.dohvati(1));
				System.out.println(k.dohvati(3));
			} catch (GIndeks e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
			System.out.println(k);
			k.dodajNosivo(o2);
			k.dodajNosivo(o3);
			System.out.println(k);
			k.dodajNosivo(o4);
			
		} catch (GDodavanje e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
	}*/
	
}
