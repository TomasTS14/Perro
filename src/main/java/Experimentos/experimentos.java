package Experimentos;

import Paneles.TiposPerro;
import javax.swing.*;

public class experimentos {
    
    public static void main(String[] args) {
        
        TiposPerro tipos= new TiposPerro();

        String color=tipos.getPanel();

        System.out.println(color);

    }
}
