package a_cristian;

import java.io.*;
import java.net.*;
import java.text.*;
import java.util.*;

public class Cliente {

    public static void main(String[] args) throws IOException {

        String port, hostName;
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        int portNumber = 2222;
        hostName = "localhost";
        try (
                Socket echoSocket = new Socket(hostName, portNumber);
                PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));) {
            String userInput;
            System.out.println("Client iniciado");
            System.out.println("Ingrese Exit para detener");

            long T0;
            long Tiempo_Servidor;
            long T1;
            long Tiempo_final;
            out.println(T0 = System.currentTimeMillis());
            Tiempo_Servidor = Long.parseLong(in.readLine());
            T1 = System.currentTimeMillis();
            Tiempo_final = Tiempo_Servidor + (T1 - T0) / 2;
            DateFormat formatter = new SimpleDateFormat("HH:mm:ss:SSS");
            System.out.println("Tiempo del cliente: " + formatter.format(new Date(T1)));
            System.out.println("Tiempo del servidor: " + formatter.format(new Date(Tiempo_Servidor)));
            System.out.println("Tiempo del cliente despues del reinicio: " + formatter.format(new Date(Tiempo_final)));
            out.println("Salida");

        } catch (UnknownHostException e) {
            System.err.println("No sé sobre el anfitrión" + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("No se pudo obtener E/S para la conexión a " + hostName);
            System.exit(1);
        }
    }
}
