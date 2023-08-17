package Ekosistem;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EnergetskiSistem extends Frame {
	
	private Plac plac;
	private Baterija baterija;
	private Button dugme1 = new Button("Dodaj");
	
	public EnergetskiSistem(int n, int m, int kap) {	
		
		this.baterija=new Baterija(kap);
		setBounds(0,0,500,500);
		setResizable(false);
		setTitle("HIDROELEKTRANA DJERDAP");
		
		plac = new Plac(n,m);
		
		populatewindow();
		
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				plac.zaustavi();
				dispose();
			}
		});
		setVisible(true);
	}

	private void populatewindow() {
		
		Panel panel = new Panel();
		panel.add(dugme1, BorderLayout.CENTER);

		dugme1.addActionListener((ae)->{
			Hidroelektrana h = new Hidroelektrana(baterija);
			h.pokreni();
			plac.dodajproizvodjaca(h);
		});
		
		add(panel, BorderLayout.NORTH);
		add(plac, BorderLayout.CENTER);

		
	}



	public static void main(String args[]) {
		new EnergetskiSistem(10,10,100);
	}
	
}
