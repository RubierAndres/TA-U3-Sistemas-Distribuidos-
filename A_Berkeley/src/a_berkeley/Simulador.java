package a_berkeley;

public class Simulador {

    public static void main(String[] args) {
        Salida am = new Salida();
        Servidor srv = new Servidor(am);
        srv.start();
        Cliente clv[] = new Cliente[3];
        for (int i = 0; i < 3; i++) {
            clv[i] = new Cliente(i, am);
            clv[i].start();
        }
    }
}
