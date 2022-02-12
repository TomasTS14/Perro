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

       // panel.add(new JLabel(perroMarron));
        // panel.add(new JLabel(perroNegro));

       // JMenu menuColores= new JMenu("asdasdasdasdas");
        //menuColores.add(new JMenuItem("Marron"));
        //menuColores.add(new JMenuItem("Negro"));
        //menuColores.add(new JMenuItem("Dalmata"));
        JComboBox lista= new JComboBox<>(colores);
        panel.add(lista);
        int index= lista.getSelectedIndex();

        switch(index){
            case 0:
                
                panel.add(new JLabel(perroMarron));
                panel.repaint();
                break;
            
            case 1:
                
                perroMarron= perroNegro;
                panel.repaint();
                break;

        
        }

        this.modelos.add(perroMarron);

        JOptionPane.showMessageDialog(null, panel, "Elige color:",1);

       
    }




}
