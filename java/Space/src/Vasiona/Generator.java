package Vasiona;

public class Generator extends Thread {
	
	private Svemir svemir;
	private boolean work = true;
	
	public Generator (Svemir svemir) {
		this.svemir = svemir;
	}
	
	public void run() {
		try {
			while(!Thread.interrupted()) {
				
				synchronized(this) {
					while(!work) {
						wait();
					}
				}
				
				Thread.sleep(900);
				int xx=(int) (Math.random()*200);
				int yy=0;
				int rr=10 + (int) (Math.random()*20);
				svemir.dodajNT(new Kometa(xx,yy,rr));
			}
			
		} catch (InterruptedException e) {}
	}
	
	public synchronized void pokrenigenerator() {
		this.start();
	}
	
	public synchronized void ugasi() {
		this.interrupt();
	}
	
	public synchronized void pause() {
		work=false;
	}
	
	public synchronized void resumee() {
		work=true;
		notify();
	}
	
}
