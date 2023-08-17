package Kladionica;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Polje extends Canvas {

	public enum status{SLOBODNO,IZABRANO};
	
	private Mreza mreza;
	private int broj;
	private Label labela = new Label();
	 
	private status statuspolja=status.SLOBODNO;
	
	public Polje(Mreza mreza, int broj) {
		this.mreza=mreza;
		this.broj=broj;
		this.setBounds(0,0,75,75);
		this.setBackground(Color.ORANGE);
		this.setForeground(Color.BLACK);
		
		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(statuspolja==status.SLOBODNO) statuspolja=status.IZABRANO;
				else statuspolja=status.SLOBODNO;
				System.out.println("klik");
				repaint();
				mreza.azuriraj();
			}
			
		});
		
		
	}
	
	public int getLabel() {
		return broj;
	}
	
	public void setStatus(status s) {
		statuspolja=s;
	}
	
	public status getStatus() {
		return statuspolja;
	}
	
	@Override
	public void paint(Graphics g) {
		Color prosla=g.getColor();
		
		if(statuspolja==status.IZABRANO) {
			g.setColor(Color.BLUE);
			g.fillOval(0, 0, this.getWidth(), this.getHeight());
			g.setColor(Color.WHITE);
		}
		else {
			g.setColor(Color.BLACK);
		}
		g.setFont(new Font("Serif",1,(int) (0.33*Math.min(this.getWidth(),this.getHeight()))));
		g.drawString(""+broj, this.getWidth()/2, this.getHeight()/2);
		g.setColor(prosla);
	}
	
	
}
