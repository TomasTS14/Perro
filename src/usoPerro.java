import javax.swing.JOptionPane;

public class usoPerro {

	public static void main(String[] args) {
		String[] opciones = { "Salir del menu", "Añadir perro", "Ver los perros de cada dueño",
				"Ver todos los perros" };
		boolean menu = true;
		Perrera perrera = new Perrera();

		Perro BorderCollie = new Perro("Akira", "Angel", 2, "blanco");
		perrera.añadePerro(BorderCollie);

		Perro Ratonero = new Perro("Pincho", "Alba", 5, "marron");
		perrera.añadePerro(Ratonero);

		Perro Labrador = new Perro("Ambar", "Tomas", 1, "marron");
		perrera.añadePerro(Labrador);

		Perro Chihuahua = new Perro("Rocky", "Enrique", 8, "negro");
		perrera.añadePerro(Chihuahua);

		while (menu) {
			int opcion2 = -1;
			String opcion = (String) JOptionPane.showInputDialog(null, "¿Qué quieres hacer?", "Elige un dueño primero",
					3, null, opciones, null);

			for (int i = 0; i < opciones.length; i++) // Consigo la posicion del array según lo que has elegido en el
														// menú
				if (opciones[i].equals(opcion))
					opcion2 = i;

			switch (opcion2) {

			case 0:
				menu = false;
				break;

			case 1:
				break;

			case 2:
				perrera.buscaDueño();
				break;

			case 3:
				perrera.muestraTodos();
				break;
			}

		}

	}

}
