package Paneles;

import java.awt.*;
import javax.swing.*;

import principal.Perrera;

import java.util.ArrayList;

public class TiposPerro {
    
    private JPanel panel;
    private JButton correcto;
    private String[] colores;
    private ArrayList<ImageIcon> modelos;

    public TiposPerro(){

        modelos= new ArrayList<>();
         this.panel= new JPanel();
        
        this.colores= new String[]{"marron", "negro", "dalmata", "azul"};
       


    }
    public void getPanel(){
        ImageIcon perroMarron= new ImageIcon(TiposPerro.class.getResource("/perroMarronAnimadoChiqui.gif"));
        ImageIcon perroNegro= new ImageIcon(TiposPerro.class.getResource("/perroNegro.gif"));
      //  Image perroACambiar= perroMarron.getImage();
       // Image perroFinal= perroACambiar.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
       // perroMarron= new ImageIcon(perroFinal);

        panel.add(new JLabel(perroMarron));
        panel.add(new JLabel(perroNegro));
        panel.add(new JList<>(colores));
        this.modelos.add(perroMarron);

        JOptionPane.showMessageDialog(null, panel, "Elige color:",1);

       
    }




}
