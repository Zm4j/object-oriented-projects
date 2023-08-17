package revija;

public class Model {
	
	private static int brr=0;
	private int id = brr++;
	
	Velicina v;

	public Model(Velicina v) {
		this.v = v;
	}

	public int dohvId() {
		return id;
	}

	public Velicina dohvVelicinu() {
		return v;
	}
	
	public String toString() {
		return "Model " + id + " (" + v + ')';
	}
	
	/*public static void main(String args[]) {
		
		Velicina v=new Velicina(Velicina.oznaka.M);
		Model m1 = new Model(v);
		Model m2 = new Model(v);
		
		System.out.println(m1);
		System.out.println(m2);
		
	}*/
	
}
