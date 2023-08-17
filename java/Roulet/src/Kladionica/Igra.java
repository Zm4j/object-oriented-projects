package Kladionica;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Igra extends Frame {
	
	private Mreza mreza;
	private Panel desni = new Panel();
	private Panel traka = new Panel();
	
	private Label labela0 = new Label();
	private Label labela2 = new Label("0");
	private TextField labela4 = new TextField("100");
	private Label labela6 = new Label("0");
	private Label labela8 = new Label("0");
	private Button labela10 = new Button("igraj");
	private double Balans = 0;
	
	public Mreza getMreza() {return mreza;}
	
	private float kvota;
	private float dobitak;
	
	public void Azuriraj() {
		int h=0;
		for(int i=0;i<mreza.getNiz().size();i++) {
			if(mreza.getNiz().get(i)==Polje.status.IZABRANO) h++;
		}
		kvota=((float)mreza.getNiz().size()/h);
		dobitak = Float.parseFloat(labela4.getText())*kvota;
		
		if(h>0) labela10.enable(true);
		else labela10.enable(false);
		
		labela6.setText(""+kvota);
		labela8.setText(""+dobitak);
		
		revalidate();
		
	}
	
	public Igra() {
		
		traka.add(labela0);
		traka.setBackground(Color.gray);
		
		desni.setLayout(new GridLayout(5,1));
		//desni.setLayout(new Borderayout());
		Panel red1 = new Panel();
		red1.setLayout(new GridLayout(1,0));
		red1.add(new Label("Balans: "),BorderLayout.WEST);
		red1.add(labela2,BorderLayout.WEST);
		desni.add(red1);
		Panel red2 = new Panel();
		red2.add(new Label("Ulog: "),BorderLayout.WEST);
		red2.add(labela4,BorderLayout.WEST);
		desni.add(red2);
		Panel red3 = new Panel();
		red3.add(new Label("Kvota: "),BorderLayout.WEST);
		red3.add(labela6,BorderLayout.WEST);
		desni.add(red3);
		Panel red4 = new Panel();
		red4.add(new Label("Dobitak: "),BorderLayout.WEST);
		red4.add(labela8,BorderLayout.WEST);
		desni.add(red4);
		Panel red5 = new Panel();
		labela10.enable(false);
		red5.add(labela10,BorderLayout.EAST);
		desni.add(red5);
		desni.setBackground(Color.LIGHT_GRAY);
		
		mreza= new Mreza(this);
		this.add(mreza,BorderLayout.CENTER);
		this.add(desni,BorderLayout.EAST);
		this.add(traka,BorderLayout.SOUTH);
		this.pack();
		
		labela10.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				Azuriraj();
				
				int h = new Generator().broj(0,19);
				labela0.setText(""+h);
				if(mreza.getNiz().get(h)==Polje.status.IZABRANO) h=1;
				else h=-1;
				
				if(h==1) labela2.setText(""+(Float.parseFloat(labela2.getText())+dobitak-Float.parseFloat(labela4.getText())));
				else labela2.setText(""+(Float.parseFloat(labela2.getText())-Float.parseFloat(labela4.getText())));
				
				if(h==1) {traka.setBackground(Color.GREEN);labela0.setBackground(Color.GREEN);}
				else {traka.setBackground(Color.RED);labela0.setBackground(Color.RED);}
				revalidate();
			}
			
		});
		
		Igra ovaj = this;
		
		labela4.addTextListener(new TextListener() {

			@Override
			public void textValueChanged(TextEvent e) {
				// TODO Auto-generated method stub
				ovaj.Azuriraj();
			}
			
		});
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				dispose();
				
			}
		});
		
		this.setVisible(true);
	}
	
	public double F(double a, double b, double c) {
		double p = (1 - Math.pow(Math.E, -0.7631 * b)) - (1 - Math.pow(Math.E, -0.7631 * a));
		return Math.pow(c-60*p,2)/(60*p);
	}
	
	public static void main(String str[]) {
		Igra i = new Igra();
		System.out.println(i.F(0, 0.75, 11));
		System.out.println(i.F(0.75, 1.25, 24));
		System.out.println(i.F(1.25, 1.75, 13));
		System.out.println(i.F(1.75, 2.75, 8));
		System.out.println(i.F(2.75, 999999999, 4));
		
	}
}
