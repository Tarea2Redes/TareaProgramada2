package GUI;

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

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class VentanaPrincipal extends JFrame implements ActionListener {

    private JDesktopPane desktoPane;
    private JMenuBar jmbMenu;
    private JMenu jmArchivo;
    private JMenuItem insertarLibros;
    private JMenuItem buscarLibros;
    private JMenuItem mostrarLibros;

    private JPanel panelFondo;

    public VentanaPrincipal() throws IOException {
        super();

        init();

    }//contructor

    private void init() throws IOException {

        this.setSize(800, 600);
        this.setLayout(null);
        this.setTitle("Libros");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.desktoPane = new JDesktopPane();
        //this.desktoPane.setSize(800, 600);
        this.desktoPane.setBounds(0, 20, 800, 600);
        add(desktoPane);

        this.jmbMenu = new JMenuBar();
        this.jmArchivo = new JMenu("Abrir");
        this.insertarLibros = new JMenuItem("Insertar libros");
        this.insertarLibros.addActionListener(this);

        this.buscarLibros = new JMenuItem("buscar libros");
        this.buscarLibros.addActionListener(this);

        this.mostrarLibros = new JMenuItem("mostrar libros");
        this.mostrarLibros.addActionListener(this);

        this.jmArchivo.add(this.insertarLibros);
        this.jmArchivo.add(this.buscarLibros);
        this.jmArchivo.add(this.mostrarLibros);

        this.jmbMenu.add(this.jmArchivo);
        this.jmbMenu.setBounds(0, 0, this.getWidth(), 20);

        this.panelFondo = new PanelFondoSecundario(1, 800, 600);
        panelFondo.setBounds(0, 0, 800, 600);

        this.add(this.jmbMenu);

        this.add(panelFondo);

        this.add(this.desktoPane);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.insertarLibros) {

            InsertarLibro insertarLibro = new InsertarLibro();
            insertarLibro.setVisible(true);

        }
        if (e.getSource() == this.buscarLibros) {
            BuscarLibro buscar = new BuscarLibro();
            buscar.setVisible(true);

        }

        if (e.getSource() == this.mostrarLibros) {

            ListadoLibros listado;
            try {
                listado = new ListadoLibros(1, "");
                listado.setVisible(true);

            } catch (HeadlessException ex) {
                Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
}
