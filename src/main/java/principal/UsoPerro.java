package principal;
import java.io.*;
import java.net.*;

import javax.swing.JOptionPane;


public class UsoPerro {

	public static void main(String[] args) throws IOException {

		
		String[] opciones = { "Salir del menu", "Aniadir perro", "Ver los perros de cada duenio", "Ver todos los perros",
				"Ordenar perros por su nombre", "Atacar a un perro" ,"Aparear a dos perros","Ver usuarios conectados"};

		boolean menu = true;
		Perrera perrera = new Perrera();
		
		while (menu) {
			int opcion2 = -1;
			String opcion = (String) JOptionPane.showInputDialog(null, "Que quieres hacer?", "MENU",
					3, null, opciones, null);

			for (int i = 0; i < opciones.length; i++) // Consigo la posicion del array segun lo que has elegido en el
														// menu
				if (opciones[i].equals(opcion))
					opcion2 = i;

			switch (opcion2) {

			case 0: // Sale del menu
				menu = false;
				break;

			case 1:
				perrera.anadePerro(perrera.anadePerroConsola());
				break;


			case 2: // Muestra los perros del duenio elegido
				perrera.buscaDueno();
				break;

			case 3: // Muestra todos los perros
				perrera.muestraTodos();
				break;

			case 4: // Ordena por nombre del perro
				perrera.ordenaNombres();
				perrera.muestraTodos();
				break;

			case 5: // Atacar a un perro
				if (!perrera.estaVacia())
					perrera.atacaPerro();
				break;
				
			case 6:
				perrera.anadePerro(perrera.procrearPerro());
				break;
				
			case 7:
				perrera.usuariosConectados();
			
			default :
			}
		}

	}


}