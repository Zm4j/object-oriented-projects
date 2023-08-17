package Vasiona;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Objekat {
	
	private int x,y;
	Color boja;
	
	public Objekat(int x, int y, Color boja) {
		this.x = x;
		this.y = y;
		this.boja = boja;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public void pomerajX(int k) {
		x+=k;
	}
	public void pomerajY(int k) {
		y+=k;
	}
	
	public abstract void paint(Graphics g);
	
}
