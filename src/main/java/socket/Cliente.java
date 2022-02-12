package socket;

import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import io.socket.client.IO;
import io.socket.emitter.Emitter;

import principal.Perrera;

public class Cliente {
		private String evento = "chat mensaje";
	    private static io.socket.client.Socket mSocket;
	    
	public Cliente() {

	///////////////////////////////AQUI DEBAJO LO QUE ENVIAMOS AL SERVIDOR/////////////////////////////

		try {
	        mSocket = IO.socket("https://servidorclaseperro.herokuapp.com/");
			System.out.println("Conexion establecida con el servidor");
	    } catch (URISyntaxException e) {
	    	System.out.println(e.getMessage());
	    }
		
	
		mSocket.connect(); 	//Conectamos y permanecemos a la escucha

	    mSocket.on(evento, new Emitter.Listener() { //Esperamos si recibimos un evento
	        public void call(Object... args) {
	            System.out.println("Mensaje recibido: ");
	            for (int i = 0; i < args.length; i++) {
	                System.out.println(args[i]);
	            }
	            
				JOptionPane.showMessageDialog(null,args, "!!!!!",JOptionPane.INFORMATION_MESSAGE, Perrera.devuelveIcono()); 
	        }
	    });
	    
	}
	
	public void enviaMensaje(String mensaje) { //Enviamos un mensaje al servidor
	    mSocket.emit(evento, mensaje);
	}

	
}




