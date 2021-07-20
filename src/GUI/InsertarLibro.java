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

public class InsertarLibro extends JFrame implements ActionListener {

    private JLabel lblTitulo, lblPagina, lblAutor, lblEditorial, lblISBN, lblContenido, lblFecha;
    private JTextField jtxTitulo, jtxPagina, jtxAutor, jtxEditorial, jtxISBN, jtxFecha;
    private JTextArea jtxContenido;
    private JPanel panelFondo;
    private JButton btnInsertar;

    public InsertarLibro() {

        init();
    }

    private void init() {

        this.setLayout(null);
        this.setTitle("Insertar libros");
        this.setSize(600, 800);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.panelFondo = new PanelFondoSecundario(2, 600, 800);
        panelFondo.setBounds(0, 0, 600, 800);

        this.lblTitulo = new JLabel("Titulo");
        this.lblTitulo.setBounds(30, 20, 100, 25);
        this.jtxTitulo = new JTextField();
        this.jtxTitulo.setBounds(20, 50, 140, 25);

        this.lblAutor = new JLabel("Autor");
        this.lblAutor.setBounds(200, 20, 100, 25);
        this.jtxAutor = new JTextField();
        this.jtxAutor.setBounds(200, 50, 140, 25);

        this.lblEditorial = new JLabel("Editorial");
        this.lblEditorial.setBounds(30, 100, 100, 25);
        this.jtxEditorial = new JTextField();
        this.jtxEditorial.setBounds(20, 130, 140, 25);

        this.lblFecha = new JLabel("Fecha creaciòn");
        this.lblFecha.setBounds(200, 100, 100, 25);
        this.jtxFecha = new JTextField();
        this.jtxFecha.setBounds(200, 130, 140, 25);

        this.lblISBN = new JLabel("ISBN ");
        this.lblISBN.setBounds(30, 180, 100, 25);
        this.jtxISBN = new JTextField();
        this.jtxISBN.setBounds(20, 210, 140, 25);

        this.lblPagina = new JLabel("Cantidad de pàginas");
        this.lblPagina.setBounds(200, 180, 120, 25);
        this.jtxPagina = new JTextField();
        this.jtxPagina.setBounds(200, 210, 140, 25);

        this.lblContenido = new JLabel("Contenido del libro");
        this.lblContenido.setBounds(200, 280, 120, 25);
        this.jtxContenido = new JTextArea();

        this.btnInsertar = new JButton("Insertar");

        JScrollPane scroll = new JScrollPane(jtxContenido);
        scroll.setBounds(15, 320, 500, 300);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        this.btnInsertar.setBounds(250, 680, 100, 30);
        this.btnInsertar.addActionListener(this);

        add(lblTitulo);
        add(jtxTitulo);
        add(lblAutor);
        add(jtxAutor);
        add(lblEditorial);
        add(jtxEditorial);
        add(lblFecha);
        add(jtxFecha);
        add(lblISBN);
        add(jtxISBN);
        add(lblPagina);
        add(jtxPagina);
        add(lblContenido);
        add(scroll);
        add(btnInsertar);
        add(panelFondo);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(jtxAutor.getText().length()!=0 &&jtxTitulo.getText().length()!=0 && jtxEditorial.getText().length()!=0 && jtxFecha.getText().length()!=0 && jtxISBN.getText().length()!=0 && jtxPagina.getText().length()!=0 && jtxContenido.getText().length()!=0){
        
        
        }

    }

}
