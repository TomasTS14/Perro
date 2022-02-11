package principal;
public class Perro implements Comparable <Perro>{
	private String nombre;
	private String amo;
	private int edad;
	private String color;
	private boolean herido;
	private boolean vivo;
	

	public Perro() {
		this.nombre = "";
		this.amo = "";
		this.edad = 0;
		this.color = "";
		this.herido = false;
		this.vivo = true;
	}
	
	public Perro (String nombre, String amo, int edad, String color) {
		this.nombre = nombre;
		this.amo = amo;
		this.edad = edad;
		this.color = color;
		this.herido = false;
		this.vivo = true;
	}

	public String getNombre() {
		return nombre;
	}
	
	public boolean getVivo() {
		return vivo;
	}
	
	public boolean getHerido() {
		return herido;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAmo() {
		return amo;
	}

	public void setAmo(String amo) {
		this.amo = amo;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public void cumple() {
		this.edad++;
	}
	
	public void muerde(Perro perroMordido) {
		if (perroMordido.herido == false) {
			perroMordido.herido = true;
		} else {
			perroMordido.herido = true;
			perroMordido.vivo = false;
		}
	}

	@Override
	public int compareTo(Perro o) {
		return this.nombre.compareTo(o.nombre);
	}

	@Override
	public String toString() {
		return "Perro [nombre=" + nombre + ", amo=" + amo + ", edad=" + edad + ", color=" + color + ", herido=" + herido
				+ ", vivo=" + vivo + "]";
	}
	
	


}
