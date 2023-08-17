package Ekosistem;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Plac extends Panel {

	private int n,m;
	private ArrayList<Parcela> niz1 = new ArrayList<>();
	private Parcela izabranaParcela=null;
	
	public void izabrana(Parcela c) {
		if(izabranaParcela!=null) {
			izabranaParcela.setFont(new Font("Serif", Font.BOLD, 14));
		}
        izabranaParcela=(Parcela)c;
        izabranaParcela.setFont(new Font("Serif", Font.BOLD, 20));
	}
	
	public Plac(int n,int m) {
		this.n=n;
		this.m=m;
		this.setLayout(new GridLayout(n,m,4,4));
		for(int i=0;i<m*n;i++) {
			if(Math.random()<0.7) {
				niz1.add(new TravnaPovrs());
				this.add(niz1.get(i));
			}
			else {
				niz1.add(new VodenaPovrs());
				this.add(niz1.get(i));
			}
		}
	}
	
	private int pomocna1(int i,int j) {
		return i+j*n;
	}
	
	public void dodajproizvodjaca(Proizvodjac c) {
		if(izabranaParcela==null) return;
		int indeks=niz1.indexOf(izabranaParcela);
		izabranaParcela=null;
		niz1.set(indeks, c);
		this.remove(indeks);
		this.add(c,indeks);
		revalidate();
		
		for(int i1=0;i1<n*m;i1++) {
            if(niz1.get(i1) instanceof Hidroelektrana) {
                int j0 = i1 / n;
                int i0 = i1 % n;
                int broj=0;
                for(int i=-1;i<2;i++) {
                    for(int j=-1;j<2;j++) {
                        if(i0+i>=0 && i0+i<=n-1 && j0+j>=0 && j0+j<=m-1) {
                            if(niz1.get(pomocna1(i+i0,j+j0)) instanceof VodenaPovrs) {
                                broj++;
                            }
                        }
                    }
                }
                ((Hidroelektrana) niz1.get(i1)).setBrojpolja(broj);
            }
        }
	}
	
	public synchronized void zaustavi() {
		for(int i1=0;i1<n*m;i1++) {
			if(niz1.get(i1) instanceof Proizvodjac) {
				((Proizvodjac)niz1.get(i1)).zaustavi();
			}
		}
	}
	
	
}
