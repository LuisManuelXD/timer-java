package controller;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis
 */
public class HiloTimer extends Thread {

    private int seconds = 0;
    public int minutes = 0;
    private int hours = 0;

    public HiloTimer() {
        super();
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (this.seconds != 60) {
                    this.seconds++;
                } else {
                    this.seconds = 0;
                    this.minutes++;
                    if (this.minutes == 60) {
                        this.minutes = 0;
                        this.hours++;
                    }
                }
                System.out.printf("%02d:%02d:%02d%n", this.hours, this.minutes, this.seconds);
                sleep(1000);

                if (this.minutes == 1 && this.seconds == 30) {
                    break;
                }
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloTimer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int getSeconds() {
        return seconds;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getHours() {
        return hours;
    }
}
