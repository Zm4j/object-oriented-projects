package Vasiona;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Simulator extends Frame {
	
	private Button dugme = new Button("Pokreni!");
	private Button dugme2 = new Button("zaustavi");
	private Button dugme3 = new Button("nastavi");
	private Panel bottomPanel = new Panel();
	private Svemir svemir = new Svemir();
	private Generator generator = new Generator(svemir);
	
	private void populateWindow() {
		
		dugme2.disable();
		dugme3.disable();
		
		bottomPanel.add(dugme);
		bottomPanel.add(dugme2);
		bottomPanel.add(dugme3);
		add(bottomPanel,BorderLayout.SOUTH);
		
		add(svemir,BorderLayout.CENTER);
		
		dugme.addActionListener((ae)->{
			generator.pokrenigenerator();
			svemir.pokrenisvemir();
			dugme.disable();
			dugme2.enable();
			dugme3.disable();
		});
		
		dugme2.addActionListener((ae)->{
			generator.pause();
			svemir.pause();
			dugme2.disable();
			dugme3.enable();
		});
		
		dugme3.addActionListener((ae)->{
			generator.resumee();
			svemir.resumee();
			dugme2.enable();
			dugme3.disable();
		});
		//repaint();
	}
	
	public Simulator() {
		setBounds(0,0,200,400);
		setVisible(true);
		
		populateWindow();
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				generator.ugasi();
				svemir.ugasi();
				dispose();
				
			}
		});
	}
	
	
	public static void main(String args[]) {
		new Simulator();
	}

}
