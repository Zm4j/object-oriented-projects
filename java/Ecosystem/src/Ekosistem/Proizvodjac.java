package Ekosistem;

import java.awt.Color;

public abstract class Proizvodjac extends Parcela implements Runnable {

	protected Baterija baterija;
	protected int vreme;
	private Thread t = new Thread(this);
	
	public Proizvodjac(char slovo, Color boja, Baterija baterija, int vreme) {
		super(slovo, boja);
		this.baterija=baterija;
		this.vreme=vreme;
	}
	
	public int ukupnovreme() {
		return (int) (vreme + Math.random()*300);
	}
	
	protected abstract boolean nesto1();
	
	public void run() {
		try {
			while(!t.interrupted()) {
				t.sleep(ukupnovreme());
				boolean f = nesto1();
				if(f) {
					this.setForeground(Color.RED);
					/////////////////////////
				}
				t.sleep(300);
				this.setForeground(Color.WHITE);
			}
		} catch (InterruptedException e) {}
	}
	
	public synchronized void zaustavi() {
		if(t!=null) t.interrupt();
	}
	
	public synchronized void pokreni() {
		t.start();
	}

}
