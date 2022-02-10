import javax.swing.JOptionPane;

public class usoPerro {

	public static void main(String[] args) {
		String[] opciones = { "Salir del menu", "Aniadir perro", "Ver los perros de cada duenio", "Ver todos los perros",
				"Ordenar perros por su nombre", "Atacar a un perro" };
		boolean menu = true;
		Perrera perrera = new Perrera();

		Perro BorderCollie = new Perro("Akira", "Angel", 2, "blanco");
		perrera.anadePerro(BorderCollie);

		Perro Ratonero = new Perro("Pincho", "Alba", 5, "marron");
		perrera.anadePerro(Ratonero);

		Perro Labrador = new Perro("Ambar", "Tomas", 1, "marron");
		perrera.anadePerro(Labrador);

		Perro Chihuahua = new Perro("Rocky", "Enrique", 8, "negro");
		perrera.anadePerro(Chihuahua);

		while (menu) {
			int opcion2 = -1;
			String opcion = (String) JOptionPane.showInputDialog(null, "Que quieres hacer?", "Elige un duenio primero",
					3, null, opciones, null);

			for (int i = 0; i < opciones.length; i++) // Consigo la posicion del array seg�n lo que has elegido en el
														// men�
				if (opciones[i].equals(opcion))
					opcion2 = i;

			switch (opcion2) {

			case 0: // Sale del men�
				menu = false;
				break;

			case 1:
				break;

			case 2: // Muestra los perros del due�o elegido
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
			}

		}

	}

}
