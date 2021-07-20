package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class MostrarLibro extends JFrame {

    private JLabel lblContenido;

    private JTextArea jtxContenido;
    private JPanel panelFondo;

    public MostrarLibro(String titulo,String isbn,String contenido) {

        init(titulo,isbn,contenido);
    }

    private void init(String titulo,String isbn,String contenido) {

        this.setLayout(null);
        this.setTitle("Titulo: "+titulo+" isbn:"+ isbn);
        this.setSize(400, 500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.panelFondo = new PanelFondoSecundario(2, 400, 500);
        panelFondo.setBounds(0, 0, 400, 500);

        jtxContenido = new JTextArea(contenido);

        JScrollPane scroll = new JScrollPane(jtxContenido);
        scroll.setBounds(20, 20, 330, 410);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        add(scroll);

        add(panelFondo);
    }

}
