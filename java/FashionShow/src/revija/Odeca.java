package revija;

public class Odeca implements Nosivo {
	
	private String ime;
	private Velicina vel;
	
	public String dohvNaziv() {
		return ime;
	}

	public Velicina dohvVelicinu() {
		return vel;
	}
	
	public Odeca(String ime, Velicina vel) {
		this.ime = ime;
		this.vel = vel;
	}

	@Override
	public boolean odgovara(Model m) {
		return !this.vel.manja(m.v);
	}
	
	public String toString() {
		return "odeća " + ime + " " + vel;
	}
	
	/*public static void main(String args[]) {
		
		Model m = new Model(new Velicina(Velicina.oznaka.M));
		Odeca o1 = new Odeca("odelo1", new Velicina(Velicina.oznaka.L));
		Odeca o2 = new Odeca("odelo2", new Velicina(Velicina.oznaka.M));
		Odeca o3 = new Odeca("odelo3", new Velicina(Velicina.oznaka.S));
		
		System.out.println(o1.odgovara(m));
		System.out.println(o2.odgovara(m));
		System.out.println(o3.odgovara(m));

		System.out.println(o2);
	}*/
	
}
