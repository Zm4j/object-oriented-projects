package Vasiona;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Svemir extends Canvas implements Runnable {
	
	private Thread t;
	private ArrayList<NebeskoTelo> niz = new ArrayList<>();
	private boolean work=true;
	
	public synchronized void setBG() {
		this.setBackground(Color.BLACK);
	}
	
	public void dodajNT(NebeskoTelo t) {
		niz.add(t);
	}
	
	public synchronized void pokrenisvemir() {
		if(t != null) return;
		t = new Thread(this);
		t.start();
	}
	
	public synchronized void ugasi() {
		if(t==null) return;
		t.interrupt();
	}
	
	public synchronized void pause() {
		if(t==null) return;
		work=false;
	}
	
	public void resumee() {
		if(t==null) return;
		work=true;
		synchronized(t) {
			t.notify();
		}
	}
	
	public void run() {
		Graphics g = getGraphics();
		try {
			while(!(t.interrupted())) {
				//repaint();
				
				synchronized(t) {
					while(!work) t.wait();
				}
				
				synchronized(t) {
					
					Thread.sleep(100);
					
					g.setColor(Color.BLACK);
					g.fillRect(0, 0, 500, 500);
					
					this.setBackground(Color.BLACK);
					for(int i=0;i<niz.size();i++) {
						niz.get(i).paint(g);
						niz.get(i).pomerajY(5);
					}
					String S = "PEDER: " + niz.size();
					g.setColor(Color.WHITE);
					g.drawString(S, 0, 10);
				}
				
			}
		} catch (InterruptedException e) {}
	}
}