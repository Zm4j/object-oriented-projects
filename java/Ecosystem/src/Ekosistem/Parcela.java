package Ekosistem;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Parcela extends Label {
	
	protected char slovo;
	protected Color boja;
	
	public Parcela(char slovo, Color boja) {
		this.slovo=slovo;
		this.boja=boja;
		
		this.setForeground(Color.WHITE);
		this.setFont(new Font("Serif", Font.BOLD, 14));
		this.setText(slovo+"");
		this.setAlignment(CENTER);
		this.setBackground(boja);
		
		addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseClicked(MouseEvent e) {
	        	((Plac)getParent()).izabrana(Parcela.this);
	       }
	    });
	}
	
	public void pozadina(Color c) {
		boja=c;
		this.setBackground(c);
	}
	
	
	
}
