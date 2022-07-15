package a_berkeley;

public class Cliente extends Thread {

    private int clientID;
    private long clientTime;
    private Salida am;
    private final boolean addDelay = true;

    public Cliente(int clientID, Salida am) {
        this.am = am;
        this.clientID = clientID;
        this.clientTime = System.nanoTime();
    }

    public void run() {
        while (true) {
            this.clientTime += (this.addDelay) ? (this.clientID + 1) * 2 : 0;
            System.out.println("Temporizacion (cliente " + clientID + ") : " + this.clientTime);
            this.am.setDiffTimes(this.clientTime, this.clientID);
            this.clientTime += this.am.getSettingTime(this.clientID);
            System.out.println("Temporizacion acordada (cliente " + clientID + ") : " + this.clientTime);
        }
    }

}
