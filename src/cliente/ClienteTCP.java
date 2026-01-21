package cliente;

import cifrado.CifradoAES;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTCP {
    private static final String host = "10.13.7.189";
    private static final int puerto = 5000;

    public static void main(String[] args) {
        try (
            Socket socket = new Socket(host, puerto);
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
            Scanner teclado = new Scanner(System.in);
        ) {
            System.out.println("Escribe un mensaje: ");
            String mensaje = teclado.nextLine();
            String mensajeCifrado = CifradoAES.cifrar(mensaje);
            salida.println(mensajeCifrado);
            System.out.println("Mensaje cifrado enviado al servidor");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
