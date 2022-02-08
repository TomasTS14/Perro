import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Perrera {

	private ArrayList<Perro> perreras;

	public Perrera() {

		perreras = new ArrayList<>();
	}

	public void añadePerro(Perro nuevo) {
		perreras.add(nuevo);
	}

	public void eliminaPerro(Perro p) {
		perreras.remove(p);
	}

	public void buscaDueño() {
		String[] dueños = new String[perreras.size()]; // Creo un array de los dueños (en ejecución)

		for (int i = 0; i < dueños.length; i++) // Introduzco los dueños en tiempo de ejecución
			dueños[i] = (String) perreras.get(i).getAmo();

		String dueño = (String) JOptionPane.showInputDialog(null, "Elige un dueño primero", "Dueño:", 3,
				null, dueños, null);
		muestraPerroDueño(dueño);
	}

	public void muestraPerroDueño(String dueño) { // Busca y muestra los perros del dueño recibido
		String perros = "";
		for (Perro perro : perreras) {
			if (perro.getAmo().equals(dueño))
				perros += perro.getNombre() + "\n";
		}
		JOptionPane.showMessageDialog(null, perros, "Los perros de: " + dueño, JOptionPane.INFORMATION_MESSAGE);
	}

	public void muestraTodos() { // Muestra todos los perros de la perrera
		String perros = "";
		for (Perro perro : perreras)
			perros += perro.getNombre() + "\n";

		JOptionPane.showMessageDialog(null, perros, "Tenemos estos perros:", JOptionPane.INFORMATION_MESSAGE);
	}
}
