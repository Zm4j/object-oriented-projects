package banditi;

public class Vagon {
	
	// proizvoljan broj bandita
	// pokazivac na prvi i poslednji element liste
	private Elem prvi, poslednji;
	private static class Elem {
		Bandit b; 
		Elem next; 
		Elem prev;
		Elem(Bandit b1) {b = b1;}
	}
	// int vrednost broja bandita u vagonu
	private int brBandita = 0;
	// konstruktor pravi praznu listu
	//
	// metoda koja dodaje bandit u vagon
	public void dodajBandita(Bandit b) {
		
		Elem temp=new Elem(b);
		if(prvi==null) {
			prvi=temp;
			poslednji=temp;
		}
		else {
			poslednji.next=temp;
			poslednji.next.prev=poslednji;
			poslednji=temp;
		}
		brBandita++;
		
	}
	// ispitava dal je bandit u vagonu
	public boolean sadrziBandita(Bandit b) {
		
		Elem temp=prvi;
		for(;temp!=null;temp=temp.next) {
			if(temp.b==b) return true;
		}
		return false;
		
	}
	// uklanjanje bandita iz vagona
	
	public void ukloniBandita(Bandit b) {
		
		if(sadrziBandita(b)==false) return;
		if(brBandita==1 && prvi.b==b) {
			prvi=null;
			poslednji=null;
			return;
		}
		
		Elem temp=prvi;
		for(;temp.b!=b;temp=temp.next);
		//temp je koji se uklanja
		if(temp.next!=null) {
			temp.next.prev=temp.prev;
		}
		else {
			poslednji=poslednji.prev;
			poslednji.next=null;
		}
		if(temp.prev!=null) {
			temp.prev.next=temp.next;
		}
		else {
			prvi=prvi.next;
			prvi.prev=null;
		}
		brBandita--;
	}
	
	// dohvatanje broja bandita u vagonu
	public int dohvatiBrojBandita() {
		return brBandita;
	}
	// dohvatanje bandita sa zadatim indeksom
	public Bandit dohvatiBandita(int ind) {
		
		if(ind<0 || ind>=brBandita) return null;
		
		Elem temp=prvi;
		for(int i=0;i<ind;i++,temp=temp.next);
		return temp.b;
	}
	// tostring metoda je fazon: "[(bandit), ... (bandit)]"
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append('[');
		Elem temp=prvi;
		boolean prrvi=false;
		for(;temp!=null;temp=temp.next) {
			if(prrvi==true) sb.append(", ");
			sb.append(temp.b);
			prrvi=true;
		}
		sb.append(']');
		
		return sb.toString();		
	}
	
	/*public static void main(String args[]) {
		
		Vagon v1 = new Vagon();
		Bandit b1 = new Bandit(Bandit.Tim.A);
		Bandit b2 = new Bandit(Bandit.Tim.B);
		Bandit b3 = new Bandit(Bandit.Tim.B);
		Bandit b4 = new Bandit(Bandit.Tim.A);
		b3.dodajkolicinu(-20);
		b4.dodajkolicinu(20);
		v1.dodajBandita(b1);
		v1.dodajBandita(b2);
		v1.dodajBandita(b3);
		
		
		v1.brisiBandita(b2);
		System.out.println(v1.nadjiBandita(b2));
		System.out.println(v1.nadjiBandita(b3));
		v1.dodajBandita(b4);
		System.out.println(v1.dohvatiBrojBandita());
		
		System.out.println(v1.dohvatiBandita(2));
		
		System.out.println(v1);
	}*/
}
