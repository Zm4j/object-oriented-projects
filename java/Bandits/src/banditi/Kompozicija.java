package banditi;

public class Kompozicija {
	
	// proizvoljan broj vagona
	// pokazivac na prvi i poslednji elemnt liste
	private static class Elem{
		Vagon v;
		Elem next;
		Elem prev;
		Elem(Vagon v1) {v=v1;}
	}
	private Elem prvi,poslednji;
	// konstruktor prazna lista
	//
	// dodavanje vagona u listu na kraju
	public void dodajVagon(Vagon v) {
		Elem temp=new Elem(v);
		if(prvi==null) {
			prvi=temp;
			poslednji=temp;
		}
		else {
			poslednji.next=temp;
			poslednji.next.prev=poslednji;
			poslednji=temp;
		}
	}
	// dohvatanje vagona gde se nalazi odredjeni bandit, ako ne postoji baca se greska GNepostojeciVagon
	public Vagon dohvatiVagon(Bandit b) throws GNepostojeciVagon {
		
		Elem temp=prvi;
		for(;temp!=null;temp=temp.next) {
			if(temp.v.sadrziBandita(b)==true) return temp.v;
		}
		throw new GNepostojeciVagon();
		
	}
	// dohvatanje vagona koji je ispred ili iza zadatog zavisno od enum tipa smer(ISPRED,IZA), greska GNepostojecivagon
	public Vagon dohvatiSusedniVagon(Vagon v,Smer a) throws GNepostojeciVagon {
		
		Elem temp=prvi;
		for(;temp!=null;temp=temp.next) {
			if(v==temp.v) break;
		}
		if(temp==null || (temp==prvi && a==Smer.ISPRED) || (temp==poslednji && a==Smer.IZA)) throw new GNepostojeciVagon();
		
		if(a==Smer.IZA) {
			return temp.next.v;
		}
		else {
			return temp.prev.v;
		}
	}
	// tostring metoda svi vagoni odvojeni donjim crtama
	public String toString() {
		StringBuilder sb= new StringBuilder();
		boolean prvii=false;
		Elem temp=prvi;
		for(;temp!=null;temp=temp.next) {
			if(prvii) sb.append('_');
			prvii=true;
			sb.append(temp.v);
		}
		
		return sb.toString();
	}
	
	/*public static void main(String args[]) {
		
		Kompozicija k= new Kompozicija();
		Vagon v1= new Vagon();
		Vagon v2= new Vagon();
		Vagon v3= new Vagon();
		Bandit b1= new Bandit(Bandit.Tim.A);
		b1.dodajkolicinu(10);
		Bandit b2= new Bandit(Bandit.Tim.B);
		b2.dodajkolicinu(20);
		Bandit b3= new Bandit(Bandit.Tim.A);
		b3.dodajkolicinu(30);
		Bandit b4= new Bandit(Bandit.Tim.B);
		b4.dodajkolicinu(40);
		Bandit b5= new Bandit(Bandit.Tim.A);
		b5.dodajkolicinu(50);
		Bandit b6= new Bandit(Bandit.Tim.A);
		b6.dodajkolicinu(60);
		Bandit b7= new Bandit(Bandit.Tim.A);
		b7.dodajkolicinu(70);
		b1.dodajkolicinu(10);
		v1.dodajBandita(b1);
		v1.dodajBandita(b3);
		v1.dodajBandita(b5);
		v2.dodajBandita(b2);
		v2.dodajBandita(b4);
		v3.dodajBandita(b6);
		k.dodajVagon(v1);
		k.dodajVagon(v2);
		k.dodajVagon(v3);
		
		try {
			System.out.println(k.dohvatiVagon(b7));
		} catch (GNepostojeciVagon e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
		try {
			System.out.println(k.dohvatiVagonSmer(smer.IZA, v3));
		} catch (GNepostojeciVagon e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
		System.out.println(k);
		Pomeranje p=new Pomeranje(k,smer.IZA);
		p.operacija(b6);
		System.out.println(k);
		
	}*/
	
}
