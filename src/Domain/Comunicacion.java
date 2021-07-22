package Domain;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import org.apache.commons.lang3.SerializationUtils;

public class Comunicacion {

    private DatagramSocket socketUDP;
    private static Comunicacion comunicacion;
    private final InetAddress host = InetAddress.getByName("localhost");
    private int port = 69;

    private Comunicacion() throws SocketException, UnknownHostException {

        socketUDP = new DatagramSocket();
    }

    public static Comunicacion getInstance() throws SocketException, UnknownHostException {
        if (comunicacion == null) {
            comunicacion = new Comunicacion();
        }
        return comunicacion;
    }

    public boolean insert(Libro libro) throws SocketException, UnknownHostException, IOException {

        String peticion = "registrar";

        DatagramPacket datagramPacket = new DatagramPacket(peticion.getBytes(), peticion.getBytes().length, host, port);
        socketUDP.send(datagramPacket);

        byte[] buffer = new byte[100];

        DatagramPacket datagramPacketReceive = new DatagramPacket(buffer, buffer.length, host, port);
        socketUDP.receive(datagramPacketReceive);

        String peticionLlegada = new String(datagramPacketReceive.getData(), 0, datagramPacketReceive.getLength());

        if (peticionLlegada.equalsIgnoreCase("si")) {

            System.out.println("server dijo: si");

            byte[] data = SerializationUtils.serialize(libro);

            DatagramPacket datagramPacketEnvio = new DatagramPacket(data, data.length, host, port);
            socketUDP.send(datagramPacketEnvio);

            System.out.println("libro enviado");
            return true;

        }

        return false;
    }

    public ArrayList<Libro> getListaLibros() throws SocketException, UnknownHostException, IOException {

        ArrayList<Libro> libros = new ArrayList<>();

        String msj = "lista";
        byte[] mensaje = msj.getBytes();
        int porcion = mensaje.length;
        DatagramPacket datagramPacket = new DatagramPacket(mensaje, porcion, host, port);
        socketUDP.send(datagramPacket);

        byte[] buffer = new byte[30000];

        while (true) {

            DatagramPacket temp = new DatagramPacket(buffer, buffer.length, host, port);
            socketUDP.receive(temp);
            String peticionLlegada = new String(temp.getData(), 0, temp.getLength());

            if (!peticionLlegada.equalsIgnoreCase("end")) {
                break;
            } else {
                Libro libro = SerializationUtils.deserialize(temp.getData());
                libros.add(libro);
            }

        }
        return libros;

    }

    public String mostrarContenidoLibroSeleccionado(String titulo) throws UnknownHostException, IOException {

        ArrayList<Libro> libros = getListaLibros();

        String contenido = "";

        for (int i = 0; i < libros.size(); i++) {

            if (libros.get(i).getMetadata().getTitulo().equals(titulo)) {

                contenido = libros.get(i).getMetadata().getIsbn() + "-" + libros.get(i).getContenido().getContenido();
                break;

            }

        }

        return contenido;
    }

    public ArrayList<Libro> mostrarLibroMetadata(String palabraBuscar) throws UnknownHostException, IOException {

        ArrayList<Libro> libros = getListaLibros();
        ArrayList<Libro> aux = new ArrayList<>();

        for (int i = 0; i < libros.size(); i++) {

            if (libros.get(i).getMetadata().getAutor().contains(palabraBuscar)
                    || libros.get(i).getMetadata().getEditorial().contains(palabraBuscar)
                    || libros.get(i).getMetadata().getGenero().contains(palabraBuscar)
                    || libros.get(i).getMetadata().getTitulo().contains(palabraBuscar)
                    || String.valueOf(libros.get(i).getMetadata().getIsbn()).contains(palabraBuscar)
                    || libros.get(i).getMetadata().getPaginas().contains(palabraBuscar)) {

                aux.add(libros.get(i));

            }
        }

        return aux;
    }
}
