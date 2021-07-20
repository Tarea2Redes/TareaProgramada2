package GUI;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ListadoLibros extends JFrame  implements ActionListener{
    private JComboBox combo;
    private JButton boton;
     private JPanel panelFondo;

    public ListadoLibros(int opcion, String parametro) throws HeadlessException {
        
        
        init(opcion,parametro);
    }
     

    private void init(int opcion, String parametro) {

        setLayout(null);
        setSize(400, 500);
        setTitle("Listado libros");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        combo=new JComboBox();
        combo.setBounds(100, 60, 150, 40);
        llenarCombo(opcion, parametro);
        
        boton= new JButton("Mostrar contenido");
        boton.setBounds(125, 290, 150, 30);
        boton.addActionListener(this);
        
        panelFondo= new PanelFondoSecundario(2, 400, 500);
        panelFondo.setBounds(0, 0, 400, 500);
        
        add(combo);
        add(boton);
        add(panelFondo);
        

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        
        
        if(ae.getSource()== this.boton){
            
            
            
            
            //llama al dato y se lo pasa a la ventana
            
//            MostrarLibro mostrar= new MostrarLibro("contenido");
//            mostrar.setVisible(true);
//            this.dispose();
        
        
        
        
        }
        
        
    }
    
    private void llenarCombo(int opcion, String parametro){
    
        
            if(opcion==1){
            
            
                //busca con el parametro las opciones de todos
            
            }
            
            
            if(opcion==2){
            
            
                //llena con el parametro las opciones especificas
            
            }
    
    
    
    
    
    
    }

}
