package Kladionica;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Mreza extends Panel {
	
	private Polje[][] matrica;
	private ArrayList <Polje.status> niz = new ArrayList<>();
	
	private int n=4,m=5;
	private Igra igra;
	
	
	
	public Mreza(Igra igra, int n, int m) {
		this.igra=igra;
		this.n=n;
		this.m=m;
		
		matrica=new Polje[n][m];
		
		this.setLayout(new GridLayout(n,m,3,3));
		this.setBackground(Color.BLACK);
		//matrica = Polje[n][m];
		int cnt=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				Polje p = new Polje(this,cnt++);
				matrica[i][j]=p;
				niz.add(p.getStatus());
				this.add(p);
			}
		}
		
	}
	
	public Mreza(Igra igra) {
		this(igra,4,5);
	}
	
	public ArrayList getNiz() {
		return niz;
	}
	
	public void azuriraj() {
		ArrayList<Polje.status> niz2 = new ArrayList<>();
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++) 
				niz2.add(matrica[i][j].getStatus());
		
		niz=niz2;
		igra.Azuriraj();
	}
	
	
	
}
