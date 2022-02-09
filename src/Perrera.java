import java.util.ArrayList;
import java.util.Collections;

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
