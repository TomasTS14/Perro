package principal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.*;
import BaseDeDatos.BBDD;
import java.awt.Image;

public class Perrera {

	private List<Perro> perreras;
	static BBDD miconexion;

	public Perrera() {
		miconexion = new BBDD();

		perreras = miconexion.getAllPerros();
	}

	public void anadePerro(Perro nuevo) {
		perreras.add(nuevo);
		miconexion.insertaPerro(nuevo);
	}

	public void eliminaPerro(Perro p) {
		perreras.remove(p);
		miconexion.eliminaPerro(p);
	}

	public void buscaDueno() {
		String[] duenos = new String[perreras.size()]; // Creo un array de los duenios (en ejecucion)

		for (int i = 0; i < duenos.length; i++) // Introduzco los duenios en tiempo de ejecucinin
			duenos[i] = (String) perreras.get(i).getAmo();

		String dueno = (String) JOptionPane.showInputDialog(null, "Elige un dueno primero", "Dueno:", 3, null, duenos,
				null);
		muestraPerroDueno(dueno);
	}

	public void muestraPerroDueno(String dueno) { // Busca y muestra los perros del duenio recibido
		String perros = "";
		for (Perro perro : perreras) {
			if (perro.getAmo().equals(dueno))
				perros += "-"+perro.getNombre() + "\n";
		}
		JOptionPane.showMessageDialog(null, perros, "Los perros de: " + dueno, JOptionPane.INFORMATION_MESSAGE);

	}

	public void muestraTodos() { //FIXME Muestra todos los perros de la perrera 
		String perros = "Nombre:          Amo:            Edad:            Color:      Herido:\n\n";

		for (Perro perro : perreras)
			perros += "-" + perro.getNombre() + "            " + perro.getAmo() + "            " + perro.getEdad()
					+ "            " + perro.getColor() + "            " + perro.getHerido() + "              \n";
		// perros += "-"+ perro.getNombre() +
		// perros.format("%20s,%20s,%20s",perro.getAmo(),perro.getEdad(),perro.getColor())
		// +"\n";

		JOptionPane.showMessageDialog(null, perros, "Tenemos estos perros:", JOptionPane.INFORMATION_MESSAGE);
	}

	public void ordenaNombres() {
		Collections.sort(perreras);
	}

	public boolean estaVacia() {
		if (perreras.size() == 0)
			return true;
		return false;
	}

	public void atacaPerro() { // Un perro ataca a otro perro

		ImageIcon iconoPerro = new ImageIcon(Perrera.class.getResource("/dog.png"));
		Image iconoPerroaCambiar = iconoPerro.getImage();
		Image iconoPerroFinal = iconoPerroaCambiar.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
		iconoPerro = new ImageIcon(iconoPerroFinal);

		String[] array = new String[perreras.size()];
		for (int i = 0; i < perreras.size(); i++) // Relleno el array para poder elegir en el desplegable
			array[i] = perreras.get(i).getNombre();

		Perro atacante = buscaPerro((String) JOptionPane.showInputDialog(null, "Elige el perro que muerde", "Perro:", 3,
				null, array, null));
		Perro mordido = buscaPerro((String) JOptionPane.showInputDialog(null, "Elige el perro que es mordido", "Perro:",
				3, null, array, null));

		atacante.muerde(mordido); // Ataque

		if (!mordido.getVivo()) { // Si ha muerto o si esta herido
			JOptionPane.showMessageDialog(null, (mordido.getNombre()) + " HA MUERTO !!!", "!!!!!",JOptionPane.INFORMATION_MESSAGE, iconoPerro);
			perreras.remove(mordido);
			miconexion.eliminaPerro(mordido);
		} else
			JOptionPane.showMessageDialog(null,
					(atacante.getNombre() + " ha mordido a " + mordido.getNombre()) + " y est� herido !!!", "!!!!!",JOptionPane.INFORMATION_MESSAGE, iconoPerro);
	}

	public Perro buscaPerro(String nombre) { // Encuentra y devuelve el perro por su nombre
		for (Perro p : perreras)
			if (p.getNombre().equals(nombre))
				return p;
		return null;
	}

	public Perro anadePerroConsola() {

		String dueno = JOptionPane.showInputDialog(null, "Tu nombre:");
		JTextField nombrePeText = new JTextField(5);
		JTextField edadText = new JTextField(5);
		JTextField colorText = new JTextField(5);

		JPanel creaPerro = new JPanel();
		creaPerro.add(new JLabel("nombre: "));
		creaPerro.add(nombrePeText);
		creaPerro.add(Box.createHorizontalStrut(15));
		creaPerro.add(new JLabel("edad: "));
		creaPerro.add(edadText);
		creaPerro.add(Box.createHorizontalStrut(15));
		creaPerro.add(new JLabel("color: "));
		creaPerro.add(colorText);
		creaPerro.add(Box.createHorizontalStrut(15));

		JOptionPane.showConfirmDialog(null, creaPerro, "Datos del perro: ", JOptionPane.OK_CANCEL_OPTION);
		Perro perroNuevo = new Perro(nombrePeText.getText(), dueno, Integer.parseInt(edadText.getText()),
				colorText.getText());
		return perroNuevo;

	}

}
