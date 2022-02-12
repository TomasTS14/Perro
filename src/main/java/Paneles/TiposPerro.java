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
        
        this.colores= new String[]{"marron", "negro", "dalmata", "azul","salir"};
       


    }
    public String getPanel(){
        ImageIcon perroMarron= new ImageIcon(TiposPerro.class.getResource("/perroMarronAnimadoChiqui.gif"));
        ImageIcon perroNegro= new ImageIcon(TiposPerro.class.getResource("/perroNegro.gif"));
        ImageIcon perroDalmata= new ImageIcon(TiposPerro.class.getResource("/perro dalmata.gif"));
        ImageIcon perroAzul= new ImageIcon(TiposPerro.class.getResource("/monstruoGalletas.gif"));
      //  Image perroACambiar= perroMarron.getImage();
       // Image perroFinal= perroACambiar.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
       // perroMarron= new ImageIcon(perroFinal);

       // panel.add(new JLabel(perroMarron));   aqui estuve dandole formato a las imagenes pero ya no hace falta
        // panel.add(new JLabel(perroNegro));   las estoy ya poniendo con un tamaño correcto

       // JMenu menuColores= new JMenu("asdasdasdasdas");
        //menuColores.add(new JMenuItem("Marron"));
        //menuColores.add(new JMenuItem("Negro"));      no se sacar un desplegable de este JMenu, estoy usando en cambio ComboBox
        //menuColores.add(new JMenuItem("Dalmata"));
       
       
        JComboBox lista= new JComboBox<>(colores);
        //JButton salidaBoton= new JButton("Salir"); boton aun no usado

        panel.add(lista);
      //  panel.add(salidaBoton); no usado aun, hay que agregar un actionListener o algo asi. 

        JLabel jperroMarron= new JLabel(perroMarron);
        JLabel jperroNegro = new JLabel(perroNegro);    //Aqui estoy creando cada elemento JLabel que contiene los gif
        JLabel jperroDalmata= new JLabel(perroDalmata);
       JLabel jperroAzul= new JLabel(perroAzul);

        panel.add(jperroMarron);  //Lo dejo agregado para que sea el por defecto. 

        //this.modelos.add(perroMarron);

        //JOptionPane.showMessageDialog(null, panel, "Elige color:",1);

        int index=0;
        int aux=0;
        boolean salida= true;

        while(salida){
        switch(aux){         //Un switch que recargará los paneles con gif correspondiente hasta que pueda cerrarse el while. 
            case 0:
                panel.remove(jperroNegro);
                panel.remove(jperroDalmata);
                panel.remove(jperroAzul);
                panel.add(jperroMarron);
                JOptionPane.showMessageDialog(null, panel, "Elige color:",1);
                aux= lista.getSelectedIndex();
                if(aux !=4) index=aux;
                else salida= false;
                panel.repaint();
                panel.validate();

                break;
            
            case 1:
                panel.remove(jperroMarron);
                panel.remove(jperroDalmata );
                panel.add(jperroNegro);
                JOptionPane.showMessageDialog(null, panel, "Elige color:",1);
                aux= lista.getSelectedIndex();
                if(aux !=4) index=aux;
                else salida= false;
                panel.repaint();
                panel.validate();

                break;
            
            case 2:
                panel.remove(jperroMarron);
                panel.remove(jperroNegro);
                panel.add(jperroDalmata);
                JOptionPane.showMessageDialog(null, panel, "Elige color:",1);
                aux= lista.getSelectedIndex();
                if(aux !=4) index=aux;
                else salida= false;
                panel.repaint();
                panel.validate();

                break;
            case 3:
                panel.remove(jperroMarron);
                panel.remove(jperroNegro);
                panel.remove(jperroDalmata);
                panel.add(jperroAzul);
                JOptionPane.showMessageDialog(null, panel, "Elige color:",1);
                aux= lista.getSelectedIndex();
                if(aux !=4) index=aux;
                else salida= false;
                panel.repaint();
                panel.validate();

                break;

            }
        }
        return colores[index];
    }

       
    }





