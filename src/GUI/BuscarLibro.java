package GUI;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BuscarLibro extends JFrame implements ActionListener {

    private JLabel lblBuscar;
    private JTextField jtxBuscar;
    private JButton boton;
    private JPanel panelFondo;

    public BuscarLibro() throws HeadlessException {

        init();
    }

    private void init() {

        this.setLayout(null);
        this.setSize(300, 300);
        this.setTitle("Buscar libro");
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.lblBuscar = new JLabel("Metadato del libro a encontrar:");
        this.lblBuscar.setBounds(50, 30, 180, 30);
        this.jtxBuscar = new JTextField();
        this.jtxBuscar.setBounds(55, 75, 170, 30);

        this.boton = new JButton("Buscar");
        this.boton.setBounds(90, 150, 100, 30);
        this.boton.addActionListener(this);

        this.panelFondo = new PanelFondoSecundario(2, 300, 400);
        panelFondo.setBounds(0, 0, 300, 400);

        add(lblBuscar);
        add(jtxBuscar);
        add(boton);
        add(panelFondo);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (jtxBuscar.getText().length() != 0) {
            ListadoLibros mostrar;
            try {
                mostrar = new ListadoLibros(2, jtxBuscar.getText());
                mostrar.setVisible(true);
                this.dispose();
            } catch (HeadlessException ex) {
                Logger.getLogger(BuscarLibro.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(BuscarLibro.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {

            JOptionPane.showMessageDialog(this, "Para mostrar el listado de libros, debe llenar el campo.");

        }

    }

}
