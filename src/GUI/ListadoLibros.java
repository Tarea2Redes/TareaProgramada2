package GUI;

import Domain.Comunicacion;
import Domain.Libro;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ListadoLibros extends JFrame implements ActionListener {

    private JComboBox combo;
    private JButton boton;
    private JPanel panelFondo;

    public ListadoLibros(int opcion, String parametro) throws HeadlessException, IOException {

        init(opcion, parametro);
    }

    private void init(int opcion, String parametro) throws IOException {

        setLayout(null);
        setSize(400, 500);
        setTitle("Listado libros");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        combo = new JComboBox();
        combo.setBounds(100, 60, 150, 40);
        llenarCombo(combo, opcion, parametro);

        boton = new JButton("Mostrar contenido");
        boton.setBounds(125, 290, 150, 30);
        boton.addActionListener(this);

        panelFondo = new PanelFondoSecundario(2, 400, 500);
        panelFondo.setBounds(0, 0, 400, 500);

        add(combo);
        add(boton);
        add(panelFondo);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == this.boton) {

            String itemSeleccionado = String.valueOf(this.combo.getSelectedItem());

            Comunicacion comunicacion = new Comunicacion();

            try {

                String contenido = comunicacion.mostrarContenidoLibroSeleccionado(itemSeleccionado);
                String[] parts = contenido.split("-");
                MostrarLibro mostrar = new MostrarLibro(itemSeleccionado, parts[0], parts[1]);
                mostrar.setVisible(true);

            } catch (IOException ex) {
                Logger.getLogger(ListadoLibros.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    private void llenarCombo(JComboBox combo, int opcion, String parametro) throws UnknownHostException, IOException {

        if (opcion == 1) {

            Comunicacion comunicacion = new Comunicacion();

            ArrayList<Libro> libros = comunicacion.getListaLibros();

            for (int i = 0; i < libros.size(); i++) {

                combo.addItem(libros.get(i).getMetadata().getTitulo());
            }

            
        }

        if (opcion == 2) {

            Comunicacion comunicacion = new Comunicacion();
            ArrayList<Libro> libros = comunicacion.mostrarLibroMetadata(parametro);

            for (int i = 0; i < libros.size(); i++) {

                combo.addItem(libros.get(i).getMetadata().getTitulo());
            }

        }

    }

}
