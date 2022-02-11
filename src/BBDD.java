import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class BBDD {

	private Connection connection;
	
	public BBDD() {

		String URL = "jdbc:mysql://192.168.8.25:3306/perrera";
		try {
			connection = DriverManager.getConnection(URL,"admin","admin");
			System.out.println("Conectado a la BDDD exitosamente");
		} catch (SQLException e) {
			System.out.println("No se ha podido conectar a la BBDD");
			e.printStackTrace();
		}
	}
	
	public List<Perro> getAllPerros(String sql) {
		List<Perro> perros = new ArrayList<>();
		try {
			ResultSet rs = connection.createStatement().executeQuery(sql);
			while(rs.next()) {
				String nombre = "", amo, color;
				int edad = rs.getInt("edad");
				nombre = rs.getString("nombre");
				amo = rs.getString("amo");
				color = rs.getString("color");
				perros.add(new Perro(nombre,amo,edad,color));
			}
			System.out.println(perros);
			return perros;
		}
		catch(Exception e) {
			return null;
		}
	}
	
	public void insertPerro(Perro perro) {
		try {
		connection.createStatement().execute("insert into perros () values ('','') ");
	
		}
		catch(Exception e) {
			
		}
		
	}
}
