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

    public Comunicacion() {
    }

    
    
    
    public boolean insert(Libro libro) throws SocketException, UnknownHostException, IOException {

        DatagramSocket socketUDP;

        socketUDP = new DatagramSocket();

        InetAddress host = InetAddress.getByName("localhost");

        String peticion = "registrar";

        byte[] mensaje = peticion.getBytes();
        int porcion = mensaje.length;

        DatagramPacket datagramPacket;
        datagramPacket = new DatagramPacket(mensaje, porcion, host, 69);
        socketUDP.send(datagramPacket);

        byte[] buffer = new byte[1000];

        DatagramPacket datagramPacketReceive = new DatagramPacket(buffer, buffer.length);

        socketUDP.receive(datagramPacketReceive);

        String peticionLlegada = new String(datagramPacketReceive.getData(), 0, datagramPacketReceive.getLength());

        if (peticionLlegada.equalsIgnoreCase("si")) {

            byte[] data = SerializationUtils.serialize(libro);
            int tamano = data.length;

            DatagramPacket datagramPacketEnvio;
            datagramPacketEnvio = new DatagramPacket(data, tamano, host, 69);
            socketUDP.send(datagramPacketEnvio);
            return true;

        }
        return false;
    }

    public ArrayList<Libro> getListaLibros() throws SocketException, UnknownHostException, IOException {

        ArrayList<Libro> libros = new ArrayList<>();

        DatagramSocket socketUDP;

        socketUDP = new DatagramSocket();

        InetAddress host = InetAddress.getByName("localhost");

        String msj = "lista";
        byte[] mensaje = msj.getBytes();
        int porcion = mensaje.length;
        DatagramPacket datagramPacket = new DatagramPacket(mensaje, porcion, host, 69);
        socketUDP.send(datagramPacket);

        byte[] buffer = new byte[1000];
        DatagramPacket datagramPacketReceive = new DatagramPacket(buffer, buffer.length);
        socketUDP.receive(datagramPacketReceive);
        String peticionLlegada = new String(datagramPacketReceive.getData(), 0, datagramPacketReceive.getLength());

        while (!peticionLlegada.equalsIgnoreCase("end")) {

            DatagramPacket temp = new DatagramPacket(buffer, buffer.length);
            socketUDP.receive(temp);

            Libro libro = SerializationUtils.deserialize(temp.getData());
            libros.add(libro);

        }
        return libros;

    }

    public String mostrarContenidoLibroSeleccionado(String titulo) throws UnknownHostException, IOException {

        ArrayList<Libro> libros = getListaLibros();

        String contenido = "";

        for (int i = 0; i < libros.size(); i++) {

            if (libros.get(i).getMetadata().getTitulo().equals(titulo)) {
                
                contenido=libros.get(i).getMetadata().getIsbn()+"-"+ libros.get(i).getContenido().getContenido();
                break;

            }

        }

        return contenido;
    }

}
