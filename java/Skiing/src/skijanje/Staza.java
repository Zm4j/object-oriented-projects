package skijanje;

import java.util.HashMap;

public class Staza {
	
	private static class Elem {
		Deonica d;
		Elem next;
		Elem(Deonica d1) {d=d1;}
	}
	
	private String ime;
	private Elem prvi, poslednji;
	private int tren=0;
	private double ukupnaDuzina=0;
	private double maksimalanNagib1=0;
	
	public Staza(String ime) {
		this.ime = ime;
	}

	public void dodaj(Deonica d) {
		
		Elem temp= new Elem(d);
		if(prvi==null) {
			prvi=temp;
			poslednji=temp;
		}
		else {
			poslednji.next=temp;
			poslednji=temp;
		}
		tren++;
		ukupnaDuzina+=poslednji.d.duzina();
		maksimalanNagib1=Math.max(maksimalanNagib1, poslednji.d.nagib());
	
	}
	
	public int broj() {
		return tren;
	}
	
	public double duzina() {
		return ukupnaDuzina;
	}
	
	public double nagib() {
		return maksimalanNagib1;
	}
	
	public char oznaka() throws GOznaka {
		
		if(broj()==0) throw new GOznaka();
		
		HashMap<Character, Integer> map = new HashMap<>();
		
		char ret='-';
		int mini=-1;
		
		Elem temp=prvi;
		for(;temp!=null;temp=temp.next){
			if(map.containsKey(temp.d.oznaka())) {
				map.put(temp.d.oznaka(),map.get(temp.d.oznaka())+1);
				if(map.get(temp.d.oznaka())>mini) {
					mini=map.get(temp.d.oznaka());
					ret=temp.d.oznaka();
				}
			}
			else {
				map.put(temp.d.oznaka(),0);
				if(mini==-1) {
					mini=0;
					ret=temp.d.oznaka();
				}
			}
		}
		
		return ret;
	}
	
	public double brzina(double Vp) {
		
		Elem temp=prvi;
		for(;temp!=null;temp=temp.next) {
			Vp=temp.d.brzina(Vp);
		}
		return Vp;
	}
	
	public double vreme(double Vp) {
		
		double t=0;
		Elem temp=prvi;
		for(;temp!=null;temp=temp.next) {
			t+=temp.d.vreme(Vp);
			Vp=temp.d.brzina(Vp);
		}
		return t;
	}
	//Gradac|2|600.0|10.0
	//[T(100.0,10.0),T(500.0,5.0)]
	public String toString() {
		StringBuilder sb= new StringBuilder();
		sb.append(ime).append('|').append(broj()).append('|').append(duzina()).append('|').append(nagib()).append('\n');
		sb.append('[');
		Elem temp=prvi;
		boolean prvii=false;
		for(;temp!=null;temp=temp.next) {
			if(prvii) sb.append(',');
			sb.append(temp.d);
			prvii=true;
		}
		sb.append(']');
		return sb.toString();
	}
	
}
