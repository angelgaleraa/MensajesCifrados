package servidor;

import cifrado.CifradoAES;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {
    private static final int puerto = 5000;

    public static void main(String[] args){

        System.out.println("Servidor iniciando en el puerto: " + puerto);

        try (ServerSocket serverSocket = new ServerSocket(puerto)) {
            while (true){
                Socket cliente = serverSocket.accept();
                System.out.println("Cliente conectado");

                BufferedReader entrada = new BufferedReader(
                        new InputStreamReader(cliente.getInputStream())
                );

                String mensajeCifrado = entrada.readLine();
                String mensajeDescifrado = CifradoAES.descifrar(mensajeCifrado);

                System.out.println("Mensaje recibido (cifrado): " + mensajeCifrado);

                System.out.println("Mensaje recibido (descifrado): " + mensajeDescifrado);

                cliente.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
