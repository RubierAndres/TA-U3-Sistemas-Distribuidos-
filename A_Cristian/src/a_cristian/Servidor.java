package a_cristian;

import java.io.*;
import java.net.*;
import java.util.*;

public class Servidor {

    public static void main(String[] args) throws IOException {
        String port;
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        int portNumber = 2222;
        System.out.println("Servidor Iniciado");
        try (
                ServerSocket serverSocket = new ServerSocket(portNumber);
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));) {
            String inputLine;

            while (true) {
                inputLine = in.readLine();
                if (inputLine.equalsIgnoreCase("Salida")) {
                    System.out.println("Saliendo");
                    out.println("Saliendo del servidor");
                    break;
                }
                out.println(System.currentTimeMillis() + 5000);
            }
        } catch (IOException e) {
            System.out.println("Excepción detectada al intentar escuchar en el puerto " + portNumber + " o escuchando una conexión");
            System.out.println(e.getMessage());
        }
    }
}
