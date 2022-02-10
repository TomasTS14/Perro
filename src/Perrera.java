import java.util.ArrayList;
import java.util.Collections;

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
		String[] dueños = new String[perreras.size()]; // Creo un array de los due�os (en ejecuci�n)

		for (int i = 0; i < dueños.length; i++) // Introduzco los due�os en tiempo de ejecuci�n
			dueños[i] = (String) perreras.get(i).getAmo();

		String dueño = (String) JOptionPane.showInputDialog(null, "Elige un due�o primero", "Due�o:", 3,
				null, dueños, null);
		muestraPerroDueño(dueño);
	}

	public void muestraPerroDueño(String dueño) { // Busca y muestra los perros del due�o recibido
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
	
	public void ordenaNombres() {
		Collections.sort(perreras);
	}
	
	public boolean estaVacia() {
		if(perreras.size() == 0) return true;
		return false;
	}
	
	public void atacaPerro() {   //Un perro ataca a otro perro
		String[] array = new String [perreras.size()];	
		for(int i=0;i<perreras.size();i++) //Relleno el array para poder elegir en el desplegable
			array[i] = perreras.get(i).getNombre();
		
		Perro atacante = buscaPerro((String)JOptionPane.showInputDialog(null, "Elige el perro que muerde", "Perro:", 3,null, array, null));
		Perro mordido = buscaPerro((String)JOptionPane.showInputDialog(null, "Elige el perro que es mordido", "Perro:", 3,null, array, null));	
		
		atacante.muerde(mordido);  //Ataque
		
		if(!mordido.getVivo()) { //Si ha muerto o si est� herido
			JOptionPane.showMessageDialog(null, mordido.getNombre() + " ha sido atacado por " +atacante.getNombre() + " y ha muerto");
			perreras.remove(mordido);
		}else JOptionPane.showMessageDialog(null, mordido.getNombre() + " ha sido atacado por " + atacante.getNombre() + " ,ahora est� herido");
	} 
	
	public Perro buscaPerro(String nombre) { //Encuentra y devuelve el perro por su nombre
		for(Perro p : perreras)
			if(p.getNombre().equals(nombre)) return p;
		return null;
	}
	

}
