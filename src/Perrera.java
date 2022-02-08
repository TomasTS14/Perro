import java.util.HashSet;

public class Perrera {
	private HashSet<Perro> perrera;
	
	
	public Perrera() {
		perrera = new HashSet<>();
	}
	public void añadePerro(Perro nuevo) {
		perrera.add(nuevo);
	}
	public void eliminaPerro(Perro p) {
		perrera.remove(p);
	}
}
