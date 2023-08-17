package Vasiona;

import java.awt.Color;

public abstract class NebeskoTelo extends Objekat {

	protected int r;
	
	public NebeskoTelo(int x, int y, Color boja,int r) {
		super(x, y, boja);
		this.r=r;
	}

}
