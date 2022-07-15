package a_berkeley;

public class Servidor extends Thread {

    private Salida am;
    private final int sleepMSeconds;
    private long TiempoServidor;

    public Servidor(Salida am) {
        this.am = am;
        this.sleepMSeconds = 10000;
        this.TiempoServidor = System.nanoTime();
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(this.sleepMSeconds);
                System.out.println("Temporizacion (servidor) : " + this.TiempoServidor);
                this.am.setTiempoServidor(this.TiempoServidor);
                this.am.calcAvgAndSet();
                this.TiempoServidor += this.am.getAverage();
                System.out.println("Temporizacion acordada (servidor): " + this.TiempoServidor);
                this.am.restartProcess();

            } catch (InterruptedException e) {
            }
        }
    }
}
