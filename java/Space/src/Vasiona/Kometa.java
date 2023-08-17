package Vasiona;

import java.awt.Color;
import java.awt.Graphics;

public class Kometa extends NebeskoTelo {

	private double ugao;
	
	public Kometa(int x, int y, int r) {
		super(x, y, Color.GRAY, r);
		ugao=Math.random()*2*Math.PI;
	}
	

	@Override
	public void paint(Graphics g) {
		int[] x1 = new int[5];
		int[] y1 = new int[5];
		Color h=g.getColor();
		g.setColor(boja);
		
		x1[0] = (int) (getX()+Math.cos(ugao)*r);
		y1[0] = (int) (getY()+Math.sin(ugao)*r);
		
		for(int i=0;i<4;i++) {
			ugao+=Math.PI*2/5;
			x1[i+1] = (int) (getX()+Math.cos(ugao)*r);
			y1[i+1] = (int) (getY()+Math.sin(ugao)*r);
		}
		
		//ugao+= 2*Math.PI/64;
		g.fillPolygon(x1, y1, 5);
		g.setColor(h);
	}

}
