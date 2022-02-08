import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Perrera {

	private ArrayList<Perro> perreras;

	public Perrera() {

		perreras = new ArrayList<>();
	}

	public void a�adePerro(Perro nuevo) {
		perreras.add(nuevo);
	}

	public void eliminaPerro(Perro p) {
		perreras.remove(p);
	}

	public void buscaDue�o() {
		String[] due�os = new String[perreras.size()]; // Creo un array de los due�os (en ejecuci�n)

		for (int i = 0; i < due�os.length; i++) // Introduzco los due�os en tiempo de ejecuci�n
			due�os[i] = (String) perreras.get(i).getAmo();

		String due�o = (String) JOptionPane.showInputDialog(null, "Elige un due�o primero", "Due�o:", 3,
				null, due�os, null);
		muestraPerroDue�o(due�o);
	}

	public void muestraPerroDue�o(String due�o) { // Busca y muestra los perros del due�o recibido
		String perros = "";
		for (Perro perro : perreras) {
			if (perro.getAmo().equals(due�o))
				perros += perro.getNombre() + "\n";
		}
		JOptionPane.showMessageDialog(null, perros, "Los perros de: " + due�o, JOptionPane.INFORMATION_MESSAGE);
	}

	public void muestraTodos() { // Muestra todos los perros de la perrera
		String perros = "";
		for (Perro perro : perreras)
			perros += perro.getNombre() + "\n";

		JOptionPane.showMessageDialog(null, perros, "Tenemos estos perros:", JOptionPane.INFORMATION_MESSAGE);
	}
}
