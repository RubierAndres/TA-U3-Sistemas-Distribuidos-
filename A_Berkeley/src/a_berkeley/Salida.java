package a_berkeley;

public class Salida {

    private long TiempoServidor;
    private long[] difftime;
    private long sumDiffs;
    private final int numClients = 3;
    private int countClientsOpered;

    public Salida() {
        this.TiempoServidor = 0;
        this.countClientsOpered = this.numClients;
        this.difftime = new long[this.numClients];
        this.sumDiffs = 0;
    }

    public synchronized void setTiempoServidor(long TiempoServidor) {
        this.TiempoServidor = TiempoServidor;
        try {
            notifyAll();
            wait();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void setDiffTimes(long time, int n) {
        try {
            if (TiempoServidor == 0) {
                wait();
                this.difftime[n] = (time - TiempoServidor);
                this.sumDiffs += time;
                countClientsOpered--;
                if (countClientsOpered == 0) {
                    notify();
                }
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void calcAvgAndSet() {
        long avg = (this.sumDiffs / (this.numClients + 1));
        for (int i = 0; i < this.numClients; i++) {
            this.difftime[i] = ((-this.difftime[i]) + avg);
        }
        notifyAll();
    }

    public synchronized long getSettingTime(int n) {
        return this.difftime[n];
    }

    public synchronized long getAverage() {
        return this.sumDiffs / (this.numClients + 1);
    }

    public synchronized void restartProcess() {
        this.TiempoServidor = 0;
        this.countClientsOpered = this.numClients;
        this.sumDiffs = 0;
    }
}
